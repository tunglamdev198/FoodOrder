package com.lamnt.foodorder.utils

import java.util.*

object StringUtil {
    @JvmStatic
    fun appendEndPoint(vararg strings: String?): String {
        val builder = StringBuilder()
        val length = strings.size
        for (i in 0 until length) {
            if (i < length - 1) {
                builder.append("/").append(strings[i])
            } else {
                builder.append(strings[i])
            }
        }
        return builder.toString()
    }

    @JvmStatic
    fun appendEndPoint(request: HashMap<String?, String?>): String {
        val builder = StringBuilder()
        for ((key, value) in request) {
            builder.append(key).append("/").append(value)
        }
        return builder.toString()
    }
}