package com.example.philosophycentre.model

import android.content.Context
import android.util.Log

class Philosopher(val name: String, val interests: List<PhilosophyBranch>) {
    val quotes = mutableListOf<Quote>()
    private val _lastNameLower = getLastNameLowerCase()
    val lastNameLower: String
        get() = _lastNameLower
    lateinit var biography: String
    // private val quotes = mutableListOf<String>()

    init {
        attachToBranches()
    }

    private fun getLastNameLowerCase(): String {
        for (idx in name.length - 1 downTo 0) {
            if (name[idx] == ' ' || name[idx] == '-') {
                return name.substring(idx + 1).lowercase()
            }
        }
        return name.lowercase()
    }

    private fun attachToBranches() {
        for (branch in interests) {
            branch.interestedPhilosophers.add(this)
        }
    }

    companion object {
        val TAG: String = "Philosopher"
    }
}
