package me.dio.credit.application.service.impl

import me.dio.credit.application.entity.Loan
import me.dio.credit.application.repositories.LoanRepository
import me.dio.credit.application.service.ILoanService
import org.springframework.stereotype.Service
import java.util.*

@Service
class LoanService(
    private val loanRepository: LoanRepository,
    private val customerService: CustomerService
) : ILoanService {

    override fun save(loan: Loan): Loan {
        loan.apply {
            customer = customerService.findById(loan.customer.id)
        }
        return this.loanRepository.save(loan)
    }

    override fun findAllByCustomer(customerId: Long): List<Loan> = this.loanRepository.findAllByCustomer(customerId)

    override fun findByLoanCode(customerId: Long, loanId: UUID): Loan {

        val loan: Loan  = this.loanRepository.findByLoanId(loanId) ?: throw RuntimeException("Loan not found")

        return if (loan.customer.id == customerId) loan else throw RuntimeException("403 UNAUTHORIZED")
    }
}