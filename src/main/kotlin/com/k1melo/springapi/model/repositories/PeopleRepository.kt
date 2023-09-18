package com.k1melo.springapi.model.repositories

import com.k1melo.springapi.model.entities.People
import org.springframework.data.jpa.repository.JpaRepository

interface PeopleRepository: JpaRepository<People, Long> {
}