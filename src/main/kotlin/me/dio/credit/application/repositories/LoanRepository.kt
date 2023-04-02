package me.dio.credit.application.repositories

import me.dio.credit.application.entity.Loan
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.UUID


interface LoanRepository: JpaRepository<Loan, Long> {

    fun findByLoanId(loanId: UUID): Loan?


    @Query(value = "SELECT * FROM LOAN where CUSTOMER_ID = ?1", nativeQuery = true)
    fun findAllByCustomer(customerId: Long): List<Loan>



}