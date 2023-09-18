package com.k1melo.springapi.model.entities

import jakarta.persistence.*


@Entity
data class People(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(nullable = false)
    var name: String
){
    constructor() : this(0, "")
}