package me.dio.credit.application.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Table


@Embeddable
@Table
data class Address(
    @Column(nullable = false) var zipCode: String = "",
    @Column(nullable = false) var streetName: String = ""

    )

