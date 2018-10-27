package com.devlhse.kotlinapi.controller

import com.devlhse.kotlinapi.model.ContactDocument
import com.devlhse.kotlinapi.model.ContactDto
import com.devlhse.kotlinapi.service.ContactService
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.data.domain.PageImpl
import java.time.ZonedDateTime


@RunWith(MockitoJUnitRunner::class)
class ContactControllerTest {

    @Mock
    private lateinit var contactService: ContactService

    @InjectMocks
    private lateinit var contactController: ContactController

    @Test
    fun shouldShowAllContactsWithSuccess(){
        val validPage = 0
        val maxPagePerRequest = 20
        val dateTimeNow = ZonedDateTime.now()
        val contactDocument = ContactDocument(
                id = "043d933c-cbba-4bf3-8aba-6f96bbed8e84",
                name = "valid_user",
                email = "valid_email",
                phoneNumber = "valid_phone_number",
                createdAt = dateTimeNow,
                updatedAt = dateTimeNow
        )

        val validContactsList = listOf(contactDocument)
        val pagedResponse = PageImpl(validContactsList)

        `when`(contactService.findAllContacts(validPage, maxPagePerRequest)).thenReturn(pagedResponse)
        Assert.assertNotNull(contactController.getContacts(validPage))
    }

    @Test
    fun shouldFindSpecificContactWithSuccess(){
        val dateTimeNow = ZonedDateTime.now()
        val contactDto = ContactDto(
                id = "043d933c-cbba-4bf3-8aba-6f96bbed8e84",
                name = "valid_user",
                email = "valid_email",
                phoneNumber = "valid_phone_number",
                createdAt = "03/03/1990",
                updatedAt = "04/03/1990"
        )
        `when`(contactService.findOneContact("043d933c-cbba-4bf3-8aba-6f96bbed8e84")).thenReturn(contactDto)
        Assert.assertNotNull(contactController.getContactById("043d933c-cbba-4bf3-8aba-6f96bbed8e84"))
    }
}