package com.devlhse.kotlinapi.service

import com.devlhse.kotlinapi.exception.UserNotFoundException
import com.devlhse.kotlinapi.model.ContactDocument
import com.devlhse.kotlinapi.model.ContactDto
import com.devlhse.kotlinapi.repository.ContactRepository
import com.devlhse.kotlinapi.utils.DateUtils
import org.joda.time.LocalDateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class ContactService {

    @Autowired
    private lateinit var contactRepository: ContactRepository

    @Throws(UserNotFoundException::class)
    fun findOneContact(id: Long): ContactDto {
        if(contactRepository.existsById(id)) {
            val contactDocument = contactRepository.findById(id)
            return ContactDto(
                    id = contactDocument.get().id,
                    name = contactDocument.get().name,
                    email = contactDocument.get().email,
                    phoneNumber = contactDocument.get().phoneNumber,
                    createdAt = DateUtils.toSimpleString(contactDocument.get().createdAt!!),
                    updatedAt = DateUtils.toSimpleString(contactDocument.get().updatedAt!!)
            )
        }
        throw UserNotFoundException("User not found.")
    }

    fun findAllContacts(): List<ContactDto> {
        val contacts = contactRepository.findAll()
        var contactsDto: MutableList<ContactDto> = mutableListOf()
        for (contactDocument in contacts){
            var contactDto = ContactDto(
                    contactDocument.id,
                    contactDocument.name,
                    contactDocument.email,
                    contactDocument.phoneNumber,
                    DateUtils.toSimpleString(contactDocument.createdAt!!),
                    DateUtils.toSimpleString(contactDocument.updatedAt!!)
            )
            contactsDto.add(contactDto)
        }
        return contactsDto
    }

    fun create(contactDto: ContactDto): ContactDocument {
        var lastContactDocument: ContactDocument
        var nextId: Long = 0

        try{
            lastContactDocument = contactRepository.findFirstByOrderByIdDesc()
            nextId = lastContactDocument.id
            nextId++
        }catch (e: EmptyResultDataAccessException){
            nextId++
        }

        var contactDocument = ContactDocument(
                id = nextId,
                name = contactDto.name,
                email = contactDto.email,
                phoneNumber = contactDto.phoneNumber,
                createdAt = LocalDateTime.now().toDate(),
                updatedAt = LocalDateTime.now().toDate()
        )
        return contactRepository.insert(contactDocument)
    }

    fun update(contactDto: ContactDto, id: Long): ContactDocument {
        if(contactRepository.existsById(id)) {
            var contactDocument = contactRepository.findById(id)
            var alteredContact = ContactDocument(
                    id = id,
                    name = contactDto.name,
                    email = contactDto.email,
                    phoneNumber = contactDto.phoneNumber,
                    createdAt = contactDocument.get().createdAt,
                    updatedAt = LocalDateTime.now().toDate())
            return contactRepository.save(alteredContact)
        }
        throw UserNotFoundException("User not found.")
    }

    @Throws(UserNotFoundException::class)
    fun delete(id: Long) {
        if(contactRepository.existsById(id)) {
            return contactRepository.deleteById(id)
        }
        throw UserNotFoundException("User not found.")
    }

}