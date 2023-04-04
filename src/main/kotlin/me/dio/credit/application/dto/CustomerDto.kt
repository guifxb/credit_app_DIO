package me.dio.credit.application.dto

import me.dio.credit.application.entity.Address
import me.dio.credit.application.entity.Customer
import java.math.BigDecimal


data class CustomerDto(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val password: String,
    val zipCode: String,
    val street: String

) {


    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            streetName = this.street
        )
    )


}
