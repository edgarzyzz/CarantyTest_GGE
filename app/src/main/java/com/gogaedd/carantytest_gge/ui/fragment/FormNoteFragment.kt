package com.gogaedd.carantytest_gge.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gogaedd.carantytest_gge.R
import com.gogaedd.carantytest_gge.databinding.FragmentFormNoteBinding
import com.gogaedd.carantytest_gge.utils.isvalid
import com.gogaedd.carantytest_gge.viewmodel.MainViewModel

class FormNoteFragment : Fragment() {
    lateinit var binding: FragmentFormNoteBinding
    lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormNoteBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAcceptFgmntfn.setOnClickListener {

            if (!binding.etTitleFgmntfn.isvalid()) {
                binding.etTitleFgmntfn.error = ""
                binding.etTitleFgmntfn.requestFocus()
            } else if (!binding.etTitleFgmntfn.isvalid()) {
                binding.etTitleFgmntfn.error = ""
                binding.etTitleFgmntfn.requestFocus()
            }else{

                viewModel.createNote(binding.etTitleFgmntfn.text.toString(),binding.etMessageFgmntfn.text.toString())
                val action= FormNoteFragmentDirections.actionGoNotesFragment()
                findNavController().navigate(action)
            }

        }
        binding.btnCancelFgmntfn.setOnClickListener {
            findNavController().navigateUp()
        }

    }


}