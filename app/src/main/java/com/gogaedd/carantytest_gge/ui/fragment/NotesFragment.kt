package com.gogaedd.carantytest_gge.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gogaedd.carantytest_gge.adapters.NoteAdapter
import com.gogaedd.carantytest_gge.databinding.FragmentNotesBinding
import com.gogaedd.carantytest_gge.interfaces.NoteListener
import com.gogaedd.carantytest_gge.model.Note
import com.gogaedd.carantytest_gge.viewmodel.MainViewModel


class NotesFragment : Fragment(), NoteListener {

    lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentNotesBinding
    lateinit var notesAdapter: NoteAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesAdapter = NoteAdapter()
        notesAdapter.setListener(this)

        binding.fabAddNoteFgmntn.setOnClickListener {
            val action = NotesFragmentDirections.actionGoFormNoteFragment(null)
            findNavController().navigate(action)
        }

        binding.rvAllNotesFgmntn.apply {
            adapter = notesAdapter
            layoutManager = LinearLayoutManager(requireContext())

        }

        viewModel.loadAllNotes()


    }

    override fun onEditNote(note: Note) {
        val action = NotesFragmentDirections.actionGoFormNoteFragment(note)
        findNavController().navigate(action)
    }

    override fun onDeleteNote(note: Note, adapterPosition: Int) {
        viewModel.deleteNote(note)
        notesAdapter.removeItem(adapterPosition)
    }

    override fun onNoteChanged(note: Note) {
        viewModel.updateNote(note)
    }


}