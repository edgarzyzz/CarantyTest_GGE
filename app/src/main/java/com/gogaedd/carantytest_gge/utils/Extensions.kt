package com.gogaedd.carantytest_gge.utils

import android.widget.EditText


fun EditText.isvalid():Boolean{
    return !text.toString().isNullOrEmpty()
}
