package com.devlhse.kotlinapi.controller

import com.devlhse.kotlinapi.exception.UserNotFoundException
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
    @GetMapping("/contacts/{id}")
    fun getContactById(@PathVariable("id") id: Long): ResponseEntity<ContactDto> {
        return ResponseEntity.ok().body(contactService.findOneContact(id))
    }

    @GetMapping("/contacts")
    fun getContacts(): ResponseEntity<List<ContactDto>> {
        return ResponseEntity.ok().body(contactService.findAllContacts())
    }

    @PostMapping("/contacts")
    fun createContact(@RequestBody contactDto: ContactDto): ResponseEntity<String> {
        contactService.create(contactDto)
        return ResponseEntity.created(URI("/contacts")).body("Inserted")
    }

    @PutMapping("/contacts/{id}")
    fun updateContact(@RequestBody contactDto: ContactDto, @PathVariable("id") id: Long): ResponseEntity<String> {
        contactService.update(contactDto, id)
        return ResponseEntity.ok().body("Updated")
    }

    @Throws(UserNotFoundException::class)
    @DeleteMapping("/contacts/{id}")
    fun deleteContact(@PathVariable("id") id: Long): ResponseEntity<String> {
        contactService.delete(id)
        return ResponseEntity.ok().body("Deleted")
    }
}