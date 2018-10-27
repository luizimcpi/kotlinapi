package com.devlhse.kotlinapi.service

import com.devlhse.kotlinapi.component.ContactConversorComponent
import com.devlhse.kotlinapi.exception.UserNotFoundException
import com.devlhse.kotlinapi.model.ContactDocument
import com.devlhse.kotlinapi.model.ContactDto
import com.devlhse.kotlinapi.repository.ContactRepository
import com.devlhse.kotlinapi.utils.DateTimeUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*


@Service
class ContactService {

    @Autowired
    private lateinit var contactConversorComponent: ContactConversorComponent

    @Autowired
    private lateinit var contactRepository: ContactRepository

    @Throws(UserNotFoundException::class)
    fun findOneContact(id: String): ContactDto {
        if(contactRepository.existsById(id)) {
            val contactDocument = contactRepository.findById(id)
            return  contactConversorComponent.toContactDto(contactDocument.get())
        }
        throw UserNotFoundException("User not found.")
    }

    fun findAllContacts(evalPage: Int, maxItensPerPage: Int): Page<ContactDocument> {
        return contactRepository.findAll(PageRequest.of(evalPage, maxItensPerPage))
    }

    fun create(contactDto: ContactDto): ContactDto {
        val dateTimeNow = Date.from(java.time.ZonedDateTime.now().toInstant())
        var contactDocument = contactConversorComponent.toContactDocument(UUID.randomUUID().toString(), contactDto, dateTimeNow)
        return contactConversorComponent.toContactDto(contactRepository.save(contactDocument))
    }

    fun update(contactDto: ContactDto, id: String): ContactDto {
        if(contactRepository.existsById(id)) {
            var contactDocument = contactRepository.findById(id)
            var alteredContact = contactConversorComponent.toContactDocument(id, contactDto, contactDocument.get().createdAt!!)
            return contactConversorComponent.toContactDto(contactRepository.save(alteredContact))
        }
        throw UserNotFoundException("User not found.")
    }

    @Throws(UserNotFoundException::class)
    fun delete(id: String) {
        if(contactRepository.existsById(id)) {
            return contactRepository.deleteById(id)
        }
        throw UserNotFoundException("User not found.")
    }

}