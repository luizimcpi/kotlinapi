package com.devlhse.kotlinapi.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

data class ContactDto(
        var id:Long = 0,
        var name:String,
        var email:String,
        var phoneNumber: String,
        var createdAt: String?,
        var updatedAt: String?
)

@Document(collection = "contact")
data class ContactDocument(
        @Id var id:Long,
        var name:String,
        var email:String,
        var phoneNumber: String,
        val createdAt: Date? = null ,
        val updatedAt: Date? = null
)
