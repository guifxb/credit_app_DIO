package me.dio.credit.application.dto


import me.dio.credit.application.entity.Customer
import me.dio.credit.application.entity.Loan
import java.math.BigDecimal
import java.time.LocalDate


data class LoanDto(
    val loanValue: BigDecimal,
    val firstInstallmentDate: LocalDate,
    val numberOfInstallments: Int,
    val customerId: Long

) {

    fun toEntity(): Loan = Loan(
        loanValue = this.loanValue,
        firstInstallmentDate = this.firstInstallmentDate,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )

}





