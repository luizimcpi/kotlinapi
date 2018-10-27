package com.devlhse.kotlinapi.repository

import com.devlhse.kotlinapi.model.ContactDocument
import org.springframework.data.repository.PagingAndSortingRepository

interface ContactRepository: PagingAndSortingRepository<ContactDocument, String> {
}