package me.dio.credit.application.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.entity.Customer
import java.math.BigDecimal


data class CustomerUpdateDto(
    @field:NotEmpty(message = "Invalid") val firstName: String,
    @field:NotEmpty(message = "Invalid") val lastName: String,
    @field:NotNull(message = "Invalid") val income: BigDecimal,
    @field:NotEmpty(message = "Invalid")  val zipCode: String,
    @field:NotEmpty(message = "Invalid") val street: String
) {

    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.streetName = this.street
        return  customer

    }

}
