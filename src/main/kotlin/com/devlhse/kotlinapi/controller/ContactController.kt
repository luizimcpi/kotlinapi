package com.devlhse.kotlinapi.controller

import com.devlhse.kotlinapi.exception.UserNotFoundException
import com.devlhse.kotlinapi.model.ContactDocument
import com.devlhse.kotlinapi.model.ContactDto
import com.devlhse.kotlinapi.service.ContactService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
class ContactController {

    @Autowired
    private lateinit var contactService: ContactService

    @Throws(UserNotFoundException::class)
    @GetMapping("/contacts/{id}", produces = ["application/json"])
    fun getContactById(@PathVariable("id") id: Long): ResponseEntity<ContactDto> {
        return ResponseEntity.ok().body(contactService.findOneContact(id))
    }

    @GetMapping("/contacts", produces = ["application/json"])
    fun getContacts(): ResponseEntity<List<ContactDto>> {
        return ResponseEntity.ok().body(contactService.findAllContacts())
    }

    @PostMapping("/contacts", produces = ["application/json"], consumes = ["application/json"])
    fun createContact(@RequestBody contactDto: ContactDto): ResponseEntity<ContactDocument> {
        return ResponseEntity.created(URI("/contacts")).body(contactService.create(contactDto))
    }

    @PutMapping("/contacts/{id}", produces = ["application/json"], consumes = ["application/json"])
    fun updateContact(@RequestBody contactDto: ContactDto, @PathVariable("id") id: Long): ResponseEntity<ContactDocument> {
        return ResponseEntity.ok().body(contactService.update(contactDto, id))
    }

    @Throws(UserNotFoundException::class)
    @DeleteMapping("/contacts/{id}")
    fun deleteContact(@PathVariable("id") id: Long): ResponseEntity<String> {
        contactService.delete(id)
        return ResponseEntity.ok().body("")
    }
}