package me.dio.credit.application.dto


import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.entity.Customer
import me.dio.credit.application.entity.Loan
import java.math.BigDecimal
import java.time.LocalDate


data class LoanDto(
    @field:NotNull(message = "Invalid") val loanValue: BigDecimal,
    @field:Future(message = "Invalid") val firstInstallmentDate: LocalDate,
    @field:NotNull(message = "Invalid") val numberOfInstallments: Int,
    @field:NotNull(message = "Invalid") val customerId: Long

) {

    fun toEntity(): Loan = Loan(
        loanValue = this.loanValue,
        firstInstallmentDate = this.firstInstallmentDate,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )

}





