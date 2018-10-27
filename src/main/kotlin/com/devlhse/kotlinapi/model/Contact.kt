package com.devlhse.kotlinapi.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

data class ContactDto(
        var id:String?,
        var name:String,
        var email:String,
        var phoneNumber: String,
        var createdAt: String?,
        var updatedAt: String?
)

@Document(collection = "contact")
data class ContactDocument(
        @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
        @Id var id:String = UUID.randomUUID().toString(),
        var name:String,
        var email:String,
        var phoneNumber: String,
        val createdAt: Date? = null,
        val updatedAt: Date? = null
)
