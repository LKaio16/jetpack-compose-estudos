package com.example.firstapplication

data class MyScreenState(
    val text: String = "",
    val namesList: MutableList<String> = mutableListOf()
)
