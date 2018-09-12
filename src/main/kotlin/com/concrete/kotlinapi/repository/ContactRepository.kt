package com.concrete.kotlinapi.repository

import com.concrete.kotlinapi.model.ContactDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface ContactRepository: MongoRepository<ContactDocument, String> {
}