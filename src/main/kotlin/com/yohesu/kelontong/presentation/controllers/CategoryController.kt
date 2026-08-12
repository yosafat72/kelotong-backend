package com.yohesu.kelontong.presentation.controllers

import com.yohesu.kelontong.application.usecases.category.CreateCategoryUseCase
import com.yohesu.kelontong.application.usecases.category.DeleteCategoryUseCase
import com.yohesu.kelontong.application.usecases.category.GetCategoriesUseCase
import com.yohesu.kelontong.application.usecases.category.GetCategoryUseCase
import com.yohesu.kelontong.application.usecases.category.UpdateCategoryUseCase
import com.yohesu.kelontong.domain.presentation.dtos.user.response.UserDTO
import com.yohesu.kelontong.presentation.dtos.category.request.CreateCategoryRequest
import com.yohesu.kelontong.presentation.dtos.category.request.UpdateCategoryRequest
import com.yohesu.kelontong.presentation.dtos.category.response.CategoryDTO
import com.yohesu.kelontong.shared.utils.GenericResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/category")
class CategoryController(
    private val createCategoryUseCase: CreateCategoryUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getCategoryUseCase: GetCategoryUseCase,
    private val updateCategoryUseCase: UpdateCategoryUseCase,
    private val deleteCategoryUseCase: DeleteCategoryUseCase
) {

    @PostMapping("/create-category")
    fun create(
        @RequestBody request: CreateCategoryRequest
    ): GenericResponse<CategoryDTO> {

        val result = createCategoryUseCase.execute(
            request = request,
            userId = null
        )

        return GenericResponse(
            status = true,
            message = "Successfully created user",
            data = result
        )
    }

    @GetMapping("/get-categories")
    fun getAll(
        @RequestParam(defaultValue = "1")
        page: Int
    ): GenericResponse<List<CategoryDTO>> {

        val result = getCategoriesUseCase.execute(page)

        return GenericResponse(
            status = true,
            message = "Successfully retrieved categories",
            data = result
        )
    }

    @GetMapping("/get-categories/{id}")
    fun getById(
        @PathVariable id: Long
    ): GenericResponse<CategoryDTO> {

        val result = getCategoryUseCase.execute(id)

        return GenericResponse(
            status = true,
            message = "Successfully retrieved categories",
            data = result
        )
    }

    @PutMapping("/update-category/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody request: UpdateCategoryRequest
    ): GenericResponse<CategoryDTO> {

        val result = updateCategoryUseCase.execute(
            id = id,
            request = request,
            userId = null
        )

        return GenericResponse(
            status = true,
            message = "Successfully updated user",
            data = result
        )
    }

    @DeleteMapping("/delete-category/{id}")
    fun delete(
        @PathVariable id: Long
    ): GenericResponse<Unit> {

        deleteCategoryUseCase.execute(id)

        return GenericResponse(
            status = true,
            message = "Successfully deleted user",
            data = Unit
        )
    }
}