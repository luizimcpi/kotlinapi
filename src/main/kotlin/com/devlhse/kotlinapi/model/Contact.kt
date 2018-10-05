package com.devlhse.kotlinapi.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.*

data class ContactDto(
        var id:Long = 0,
        var name:String,
        var email:String,
        var phoneNumber: String,
        var creationDate: LocalDateTime?
)

@Document(collection = "contact")
data class ContactDocument(
        @Id var id:Long,
        var name:String,
        var email:String,
        var phoneNumber: String,
        val creationDate: LocalDateTime = LocalDateTime.now()
)
