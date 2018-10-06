package com.devlhse.kotlinapi.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

data class ContactDto(
        var id:Long = 0,
        var name:String,
        var email:String,
        var phoneNumber: String,
        var createdAt: LocalDateTime?,
        var updatedAt: LocalDateTime?
)

@Document(collection = "contact")
data class ContactDocument(
        @Id var id:Long,
        var name:String,
        var email:String,
        var phoneNumber: String,
        val createdAt: LocalDateTime? = null ,
        val updatedAt: LocalDateTime? = null
)
