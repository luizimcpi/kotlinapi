package com.devlhse.kotlinapi.controller

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

    @GetMapping("/contacts")
    fun getContacts(): ResponseEntity<List<ContactDto>> {
        return ResponseEntity.ok().body(contactService.findAllContacts())
    }

    @PostMapping("/contacts")
    fun createContact(@RequestBody contactDto: ContactDto): ResponseEntity<String> {
        contactService.create(contactDto)
        return ResponseEntity.created(URI("/contacts")).body("Inserted")
    }

    @DeleteMapping("/contacts/{id}")
    fun deleteContact(@PathVariable("id") id: String): ResponseEntity<String> {
        contactService.delete(id)
        return ResponseEntity.ok().body("Deleted")
    }
}