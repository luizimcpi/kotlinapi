package com.devlhse.kotlinapi.controller

import com.devlhse.kotlinapi.exception.UserNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class GlobalExceptionController {

    @ExceptionHandler(UserNotFoundException::class)
    fun handleNotFoundException(e: UserNotFoundException): ResponseEntity<String> {
        return ResponseEntity<String>(e.message, HttpStatus.NOT_FOUND)
    }

}