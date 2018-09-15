package com.devlhse.kotlinapi.repository

import com.devlhse.kotlinapi.model.ContactDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface ContactRepository: MongoRepository<ContactDocument, String> {
}