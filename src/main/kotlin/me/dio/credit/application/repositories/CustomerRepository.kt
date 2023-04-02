package me.dio.credit.application.repositories

import me.dio.credit.application.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Long> {



}