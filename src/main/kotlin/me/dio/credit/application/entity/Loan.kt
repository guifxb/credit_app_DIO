package me.dio.credit.application.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID



@Entity
@Table
data class Loan(
    @Column(nullable = false, unique = true) val loanId: UUID = UUID.randomUUID(),
    @Column(nullable = false) val loanValue: BigDecimal,
    @Column(nullable = false) val firstInstallmentDate: LocalDate,
    @Column(nullable = false) val numberOfInstallments: Int,
    @Column(nullable = false) @Enumerated val status: Status,
    @ManyToOne var customer: Customer,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long

)