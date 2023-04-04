package me.dio.credit.application.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.entity.Address
import me.dio.credit.application.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal


data class CustomerDto(
    @field:NotEmpty(message = "Invalid") val firstName: String,
    @field:NotEmpty(message = "Invalid") val lastName: String,
    @field:NotEmpty(message = "Invalid")
    @CPF(message = "Invalid") val cpf: String,
    @field:NotNull(message = "Invalid") val income: BigDecimal,
    @field:NotEmpty(message = "Invalid")
    @Email(message = "Invalid") val email: String,
    @field:NotEmpty(message = "Invalid") val password: String,
    @field:NotEmpty(message = "Invalid") val zipCode: String,
    @field:NotEmpty(message = "Invalid") val street: String

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
