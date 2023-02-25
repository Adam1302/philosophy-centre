package com.example.philosophycentre.model

class SchoolOfThought(val name: String) {
    lateinit var description: String
    private var propenentList: MutableList<String> = mutableListOf()

    fun addPropenent(philosopher: String) {
        propenentList.add(philosopher)
    }
}