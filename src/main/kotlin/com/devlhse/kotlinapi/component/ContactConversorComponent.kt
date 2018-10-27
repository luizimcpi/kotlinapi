package com.devlhse.kotlinapi.component

import com.devlhse.kotlinapi.model.ContactDocument
import com.devlhse.kotlinapi.model.ContactDto
import com.devlhse.kotlinapi.utils.DateTimeUtils
import org.springframework.stereotype.Component
import java.util.*

@Component
class ContactConversorComponent {

    fun toContactDto(contactDocument: ContactDocument): ContactDto {
        return ContactDto(
                id = contactDocument.id,
                name = contactDocument.name,
                email = contactDocument.email,
                phoneNumber = contactDocument.phoneNumber,
                createdAt = DateTimeUtils.dateToSimpleString(contactDocument.createdAt!!),
                updatedAt = DateTimeUtils.dateToSimpleString(contactDocument.updatedAt!!)
        )
    }

    fun toContactDocument(id: String, contactDto: ContactDto, createdAt: Date): ContactDocument {
        return ContactDocument(
                id = id,
                name = contactDto.name,
                email = contactDto.email,
                phoneNumber = contactDto.phoneNumber,
                createdAt = createdAt,
                updatedAt = Date.from(java.time.ZonedDateTime.now().toInstant())
        )
    }
}