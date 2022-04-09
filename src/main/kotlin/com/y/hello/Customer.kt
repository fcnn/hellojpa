package com.y.hello

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
class Customer() {
    var firstName:String? = null
    var lastName:String? = null

    constructor(firstName: String?, lastName: String?) : this() {
        this.firstName = firstName
        this.lastName = lastName
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long? = null

    override fun toString(): String {
        return String.format(
            "Customer[id=%d, firstName='%s', lastName='%s']",
            id, firstName, lastName
        )
    }

    fun getId(): Long? {
        return id
    }
}