package com.devlhse.kotlinapi.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    fun toSimpleString(date: Date) : String {
        try{
            val format = SimpleDateFormat("dd/MM/yyyy")
            return format.format(date)
        }catch (e: Exception){
            return ""
        }
    }
}