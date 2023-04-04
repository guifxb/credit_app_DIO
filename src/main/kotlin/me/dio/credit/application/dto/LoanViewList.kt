package me.dio.credit.application.dto

import me.dio.credit.application.entity.Loan
import java.math.BigDecimal
import java.util.*

data class LoanViewList(
    val loanCode: UUID,
    val loanValue: BigDecimal,
    val numberOfInstallments: Int
    ) {

    constructor(loan: Loan): this(
        loanCode = loan.loanId,
        loanValue = loan.loanValue,
        numberOfInstallments = loan.numberOfInstallments
    )

}
