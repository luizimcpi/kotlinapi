package com.concrete.kotlinapi.controller

import com.concrete.kotlinapi.model.ContactDto
import com.concrete.kotlinapi.service.ContactService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
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
}