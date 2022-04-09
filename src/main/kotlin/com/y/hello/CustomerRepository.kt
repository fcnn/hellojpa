package com.y.hello

import org.springframework.data.repository.CrudRepository
import java.util.*


interface CustomerRepository : CrudRepository<Customer?, Long?> {
    fun findByLastName(lastName: String?): List<Customer?>?
    override fun findById(id: Long): Optional<Customer?>
}