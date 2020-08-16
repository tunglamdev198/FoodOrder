package com.lamnt.foodorder.utils

import android.widget.EditText
import java.util.*

object ValidateUtil {
    @JvmStatic
    fun checkNull(input: Any?): Boolean {
        if (input == null) {
            return true
        }
        if (input is String) {
            return input.toString().trim { it <= ' ' }.isEmpty()
        }
        if (input is EditText) {
            return input.text.toString().trim { it <= ' ' }.isEmpty()
        }
        if (input is List<*>) {
            return input.isEmpty()
        }
        return if (input is HashMap<*, *>) {
            input.isEmpty()
        } else false
    }
}