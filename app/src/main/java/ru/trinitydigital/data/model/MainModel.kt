package ru.trinitydigital.data.model

data class MainModel(
    val id: Int,
    val title: String,
    val subList: List<SecondModel>
)