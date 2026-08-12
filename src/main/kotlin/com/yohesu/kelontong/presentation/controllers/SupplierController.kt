package com.yohesu.kelontong.presentation.controllers

import com.yohesu.kelontong.application.usecases.supplier.CreateSupplierUseCase
import com.yohesu.kelontong.application.usecases.supplier.DeleteSupplierUseCase
import com.yohesu.kelontong.application.usecases.supplier.GetSupplierUseCase
import com.yohesu.kelontong.application.usecases.supplier.GetSuppliersUseCase
import com.yohesu.kelontong.application.usecases.supplier.UpdateSupplierUseCase
import com.yohesu.kelontong.presentation.dtos.supplier.request.CreateSupplierRequest
import com.yohesu.kelontong.presentation.dtos.supplier.request.UpdateSupplierRequest
import com.yohesu.kelontong.presentation.dtos.supplier.response.SupplierDTO
import com.yohesu.kelontong.shared.utils.GenericResponse
import jakarta.validation.Valid
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
@RequestMapping("/supplier")
class SupplierController(
    private val createSupplierUseCase: CreateSupplierUseCase,
    private val getSuppliersUseCase: GetSuppliersUseCase,
    private val getSupplierUseCase: GetSupplierUseCase,
    private val updateSupplierUseCase: UpdateSupplierUseCase,
    private val deleteSupplierUseCase: DeleteSupplierUseCase
) {

    @PostMapping
    fun create(
        @Valid @RequestBody request: CreateSupplierRequest
    ): GenericResponse<SupplierDTO> {

        val supplier = createSupplierUseCase.execute(request)

        return GenericResponse(
            status = true,
            message = "Successfully created supplier",
            data = supplier
        )
    }

    @GetMapping
    fun getAll(
        @RequestParam(defaultValue = "1") page: Int
    ): GenericResponse<List<SupplierDTO>> {

        val suppliers = getSuppliersUseCase.execute(page)

        return GenericResponse(
            status = true,
            message = "Successfully retrieved suppliers data",
            data = suppliers
        )
    }

    @GetMapping("/{id}")
    fun getById(
        @PathVariable id: Long
    ): GenericResponse<SupplierDTO> {

        val supplier = getSupplierUseCase.execute(id)

        return GenericResponse(
            status = true,
            message = "Successfully retrieved supplier data",
            data = supplier
        )
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @Valid @RequestBody request: UpdateSupplierRequest
    ): GenericResponse<SupplierDTO> {

        val supplier = updateSupplierUseCase.execute(
            id = id,
            request = request
        )

        return GenericResponse(
            status = true,
            message = "Successfully updated supplier",
            data = supplier
        )
    }

    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable id: Long
    ): GenericResponse<Unit> {

        deleteSupplierUseCase.execute(id)

        return GenericResponse(
            status = true,
            message = "Successfully deleted supplier",
            data = null
        )
    }
}