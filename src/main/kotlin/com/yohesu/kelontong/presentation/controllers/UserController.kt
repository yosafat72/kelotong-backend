package com.yohesu.kelontong.presentation.controllers

import com.yohesu.kelontong.application.usecases.user.CreateUserUseCase
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import com.yohesu.kelontong.application.usecases.user.GetUsersUseCase
import com.yohesu.kelontong.domain.presentation.dtos.user.response.UserDTO
import com.yohesu.kelontong.presentation.dtos.user.request.CreateUserRequest
import org.springframework.web.bind.annotation.RequestParam
import com.yohesu.kelontong.shared.utils.GenericResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping("/user")
class UserController(
    private val getUsersUseCase: GetUsersUseCase,
    private val createUserUseCase: CreateUserUseCase
){

    @GetMapping("/get-users")
    fun getUsers(
        @RequestParam("page") page: Int
    ): GenericResponse<List<UserDTO>> {
       val users = getUsersUseCase.execute(page = page)
       return GenericResponse(
        status = true,
        message = "Successfully retrieved users data",
        data = users
       )
    }

    @PostMapping("/create-user")
    fun createUser(
        @RequestBody request: CreateUserRequest
    ): GenericResponse<UserDTO> {
        val user = createUserUseCase.execute(request)

        return GenericResponse(
            status = true,
            message = "Successfully created user",
            data = user
        )
    }

}