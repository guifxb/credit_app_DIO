package me.dio.credit.application.entity

import jakarta.persistence.*


@Entity
@Table
data class Customer(
    @Column(nullable = false) val firstName: String,
    @Column(nullable = false) val lastName: String,
    @Column(nullable = false, unique = true) val cpf: String,
    @Column(nullable = false, unique = true) val email: String,
    @Column(nullable = false) var password: String,
    @Column(nullable = false) @Embedded var address: Address,
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE],
        mappedBy = "customer") val loans: MutableList<Loan>,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long
)
