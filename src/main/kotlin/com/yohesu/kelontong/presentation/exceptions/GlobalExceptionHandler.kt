package com.yohesu.kelontong.presentation.exceptions

import com.yohesu.kelontong.domain.exceptions.DuplicateCategoryException
import com.yohesu.kelontong.domain.exceptions.EmailAlreadyExistsException
import com.yohesu.kelontong.domain.exceptions.ResourceNotFoundException
import com.yohesu.kelontong.domain.exceptions.UserNotFoundException
import com.yohesu.kelontong.domain.exceptions.UsernameAlreadyExistsException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFound(
        exception: UserNotFoundException
    ): ResponseEntity<ErrorResponse> {

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(
                ErrorResponse(
                    message = exception.message ?: "User not found"
                )
            )
    }

    @ExceptionHandler(UsernameAlreadyExistsException::class)
    fun handleUsernameAlreadyExists(
        exception: UsernameAlreadyExistsException
    ): ResponseEntity<ErrorResponse> {

        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(
                ErrorResponse(
                    message = exception.message ?: "Username already exists"
                )
            )
    }

    @ExceptionHandler(EmailAlreadyExistsException::class)
    fun handleEmailAlreadyExists(
        exception: EmailAlreadyExistsException
    ): ResponseEntity<ErrorResponse> {

        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(
                ErrorResponse(
                    message = exception.message ?: "Email already exists"
                )
            )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(
        exception: MethodArgumentNotValidException
    ): ResponseEntity<ErrorResponse> {

        val message = exception.bindingResult
            .fieldErrors
            .firstOrNull()
            ?.defaultMessage
            ?: "Invalid request"

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorResponse(
                    message = message
                )
            )
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataIntegrityViolation(
        exception: DataIntegrityViolationException
    ): ResponseEntity<ErrorResponse> {

        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(
                ErrorResponse(
                    message = "Data already exists"
                )
            )
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgument(
        exception: IllegalArgumentException
    ): ResponseEntity<ErrorResponse> {

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorResponse(
                    message = exception.message ?: "Invalid request"
                )
            )
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(
        exception: Exception
    ): ResponseEntity<ErrorResponse> {

        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(
                ErrorResponse(
                    message = "Internal server error"
                )
            )
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFound(
        exception: ResourceNotFoundException
    ): ResponseEntity<Map<String, Any?>> {

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(
                mapOf(
                    "status" to false,
                    "message" to (exception.message ?: "Resource not found"),
                    "data" to null
                )
            )
    }

    @ExceptionHandler(DuplicateCategoryException::class)
    fun handleDuplicateCategory(
        exception: DuplicateCategoryException
    ): ResponseEntity<Map<String, Any?>> {

        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(
                mapOf(
                    "status" to false,
                    "message" to (exception.message ?: "Resource already exists"),
                    "data" to null
                )
            )
    }
}