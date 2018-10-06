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


@RunWith(MockitoJUnitRunner::class)
class ContactControllerTest {

    @Mock
    private lateinit var contactService: ContactService

    @InjectMocks
    private lateinit var contactController: ContactController

    @Test
    fun shouldShowAllContactsWithSuccess(){
        val contactDto = ContactDto(
                id = 1,
                name = "valid_user",
                email = "valid_email",
                phoneNumber = "valid_phone_number",
                createdAt = "03/03/1990",
                updatedAt = "04/03/1990"
        )
        val validContactsList = listOf(contactDto)
        `when`(contactService.findAllContacts()).thenReturn(validContactsList)
        Assert.assertNotNull(contactController.getContacts())
    }

    @Test
    fun shouldFindSpecificContactWithSuccess(){
        val contactDto = ContactDto(
                id = 1,
                name = "valid_user",
                email = "valid_email",
                phoneNumber = "valid_phone_number",
                createdAt = "03/03/1990",
                updatedAt = "04/03/1990"
        )
        `when`(contactService.findOneContact(1)).thenReturn(contactDto)
        Assert.assertNotNull(contactController.getContactById(1))
    }
}