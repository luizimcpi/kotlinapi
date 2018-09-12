package com.concrete.kotlinapi.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.*

data class ContactDto(
        var id:String = UUID.randomUUID().toString(),
        var name:String,
        var email:String,
        var phoneNumber: String,
        var creationDate: LocalDateTime?
)

data class ContactModel(
        var name:String,
        var email:String,
        var phoneNumber: String,
        val creationDate: LocalDateTime
)

@Document(collection = "contact")
data class ContactDocument(
        @Id var id:String,
        var name:String,
        var email:String,
        var phoneNumber: String,
        val creationDate: LocalDateTime = LocalDateTime.now()
)
