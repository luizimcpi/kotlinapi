package com.devlhse.kotlinapi.service

import com.devlhse.kotlinapi.model.ContactDocument
import com.devlhse.kotlinapi.model.ContactDto
import com.devlhse.kotlinapi.repository.ContactRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ContactService {

    @Autowired
    private lateinit var contactRepository: ContactRepository

    fun findAllContacts(): List<ContactDto> {
        val contacts = contactRepository.findAll()
        var contactsDto: MutableList<ContactDto> = mutableListOf()
        for (contactDocument in contacts){
            var contactDto = ContactDto(contactDocument.id, contactDocument.name, contactDocument.email, contactDocument.phoneNumber, contactDocument.creationDate)
            contactsDto.add(contactDto)
        }
        return contactsDto
    }

    fun create(contactDto: ContactDto): ContactDocument {
        var contactDocument = ContactDocument(contactDto.id, contactDto.name, contactDto.email, contactDto.phoneNumber)
        return contactRepository.insert(contactDocument)
    }

    fun delete(id: String) {
        return contactRepository.deleteById(id)
    }


}