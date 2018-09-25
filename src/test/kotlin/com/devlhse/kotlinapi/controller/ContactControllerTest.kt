package com.devlhse.kotlinapi.controller

import com.devlhse.kotlinapi.model.ContactDto
import com.devlhse.kotlinapi.service.ContactService
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.runners.MockitoJUnitRunner
import java.time.LocalDateTime


@RunWith(MockitoJUnitRunner::class)
class ContactControllerTest {

    @Mock
    private lateinit var contactService: ContactService

    @InjectMocks
    private lateinit var contactController: ContactController

    @Test
    fun shouldShowAllContactsWithSuccess(){
        val contactDto = ContactDto(
                id = "valid_id",
                name = "valid_user",
                email = "valid_email",
                phoneNumber = "valid_phone_number",
                creationDate = LocalDateTime.now()
        )
        val validContactsList = listOf(contactDto)
        `when`(contactService.findAllContacts()).thenReturn(validContactsList)
        Assert.assertNotNull(contactController.getContacts())
    }

    @Test
    fun shouldFindSpecificContactWithSuccess(){
        val contactDto = ContactDto(
                id = "valid_id",
                name = "valid_user",
                email = "valid_email",
                phoneNumber = "valid_phone_number",
                creationDate = LocalDateTime.now()
        )
        `when`(contactService.findOneContact("valid_id")).thenReturn(contactDto)
        Assert.assertNotNull(contactController.getContactById("valid_id"))
    }
}