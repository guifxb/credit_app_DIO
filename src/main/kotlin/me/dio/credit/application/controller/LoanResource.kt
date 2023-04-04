package me.dio.credit.application.controller

import jakarta.validation.Valid
import me.dio.credit.application.dto.LoanDto
import me.dio.credit.application.dto.LoanView
import me.dio.credit.application.dto.LoanViewList
import me.dio.credit.application.entity.Loan
import me.dio.credit.application.service.impl.LoanService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/loans")
class LoanResource(
    private val loanService: LoanService
) {

    @PostMapping
    fun saveLoan(@RequestBody @Valid loanDto: LoanDto): ResponseEntity<String> {
        this.loanService.save(loanDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Loan created.")
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") costumerId: Long): ResponseEntity<List<LoanViewList>> {
        val loanViewList =
            this.loanService.findAllByCustomer(costumerId).stream().map { loan: Loan -> LoanViewList(loan) }
                .collect(Collectors.toList())

        return ResponseEntity.status(HttpStatus.OK).body(loanViewList)
    }

    @GetMapping("/id/{loanId}")
    fun findByLoanId(
        @RequestParam(value = "customerId") costumerId: Long, @PathVariable loanId: UUID
    ): ResponseEntity<LoanView> {
        val loan = this.loanService.findByLoanCode(costumerId, loanId)
        return ResponseEntity.status(HttpStatus.OK).body(LoanView(loan))
    }


}