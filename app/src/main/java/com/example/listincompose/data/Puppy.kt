package com.example.listincompose.data

import java.io.Serializable

data class Puppy(
    val id: Int,
    val title: String,
    val gender: String,
    val age: Int,
    val description: String,
    val imageId: Int = 0
) : Serializable