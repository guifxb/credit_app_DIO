package me.dio.credit.application.service

import me.dio.credit.application.entity.Customer

interface ICustomerService {

    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long)

}