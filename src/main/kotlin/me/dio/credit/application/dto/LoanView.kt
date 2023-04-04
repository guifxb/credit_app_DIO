package me.dio.credit.application.dto

import me.dio.credit.application.entity.Loan
import me.dio.credit.application.entity.Status
import java.math.BigDecimal
import java.util.*

data class LoanView(
    val loanId: UUID,
    val loanValue: BigDecimal,
    val numberOfInstallments: Int,
    val status: Status,
    val customerEmail: String?,
    val customerIncome: BigDecimal?,
    ) {

    constructor(loan: Loan): this (
        loanId = loan.loanId,
        loanValue = loan.loanValue,
        numberOfInstallments = loan.numberOfInstallments,
        status = loan.status,
        customerEmail = loan.customer?.email,
        customerIncome = loan.customer?.income,
    )

}
