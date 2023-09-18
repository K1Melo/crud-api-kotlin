package com.k1melo.springapi.controller

import com.k1melo.springapi.model.entities.People
import com.k1melo.springapi.model.repositories.PeopleRepository
import jakarta.websocket.server.PathParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.lang.NullPointerException
import java.util.*

@RestController
@RequestMapping(path = ["/peoples"])
class PeopleController {

    @Autowired
    lateinit var peopleRepository: PeopleRepository


    @PostMapping
    fun postPeople(@RequestBody people: People): People {
        return peopleRepository.save(people)
    }

    @GetMapping
    fun getAllFromPeople(): List<People> {
        return peopleRepository.findAll()
    }

    @GetMapping(path = ["/{id}"])
    fun getPeopleById(@PathVariable id: Long): Optional<People> {
        return peopleRepository.findById(id)
    }

    @PutMapping("{id}")
    fun updatePeople(@PathVariable id: Long, @RequestBody people: People): People {
        val oldPeople: People = peopleRepository.findById(id).orElseThrow { RuntimeException("ID $id not found") }

        return peopleRepository.save(oldPeople.copy(name = people.name))
    }

    @DeleteMapping
    fun deletePeople(@RequestParam id: Long){
        return peopleRepository.deleteById(id)
    }
}
