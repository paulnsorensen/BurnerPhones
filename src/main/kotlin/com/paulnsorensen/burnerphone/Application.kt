package com.paulnsorensen.burnerphone

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class Application

fun main(args: Array<String>) {
    System.setProperty("MY_NUMBER", System.getenv("MY_NUMBER"))
    SpringApplication.run(Application::class.java, *args)
}