package com.yohesu.kelontong.presentation.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import com.yohesu.kelontong.application.usecases.user.GetUsersUseCase
import com.yohesu.kelontong.domain.presentation.dtos.user.response.UserDTO
import org.springframework.web.bind.annotation.RequestParam
import com.yohesu.kelontong.shared.utils.GenericResponse

@RestController
@RequestMapping("/user")
class UserController(
    private val getUsersUseCase: GetUsersUseCase
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

    

}