package com.y.hello

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@SpringBootApplication
class HelloJpaApplication {
	@Bean
	fun demo(repository: CustomerRepository): CommandLineRunner {
		return CommandLineRunner { args: Array<String?>? ->
			// save a few customers
			repository.save(Customer("Jack", "Bauer"))
			repository.save(Customer("Chloe", "O'Brian"))
			repository.save(Customer("Kim", "Bauer"))
			repository.save(Customer("David", "Palmer"))
			repository.save(Customer("Michelle", "Dessler"))

			// fetch all customers
			log.info("Customers found with findAll():")
			log.info("-------------------------------")
			for (customer in repository.findAll()) {
				log.info(customer.toString())
			}
			log.info("")

			// fetch an individual customer by ID
			val customer = repository.findById(1L)
			if (customer.isPresent) {
				log.info("Customer found with findById(1L):")
				log.info("--------------------------------")
				log.info(customer.toString())
				log.info("")
			}

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):")
			log.info("--------------------------------------------")
			repository.findByLastName("Bauer")!!.forEach {
				//log.info(it.toString())
				println(it)
			}
			log.info("")
		}
	}

	companion object {
		private val log = LoggerFactory.getLogger(HelloJpaApplication::class.java)
	}
}

fun main(args: Array<String>) {
	runApplication<HelloJpaApplication>(*args)
}
