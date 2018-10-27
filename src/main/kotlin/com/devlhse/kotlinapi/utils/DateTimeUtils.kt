package com.devlhse.kotlinapi.utils

import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtils {

    fun dateToSimpleString(date: Date) : String {
        try{
            val dateFormat = SimpleDateFormat("dd/MM/yyyy hh:mm:ss a")
            return dateFormat.format(date)
        }catch (e: Exception){
            return ""
        }
    }
}