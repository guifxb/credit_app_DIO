package me.dio.credit.application.service


import me.dio.credit.application.entity.Loan
import java.util.UUID

interface ILoanService {

    fun save(loan: Loan): Loan

    fun findAllByCustomer(customerId: Long): List<Loan>

    fun findByLoanCode(customerId: Long, loanCode: UUID): Loan

}