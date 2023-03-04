package com.example.philosophycentre.model

import android.content.Context
import android.util.Log

class PhilosophyBranch(val name: String) {
    val branchNameAsLower: String = getNameAsResources()
    lateinit var branchDescription: String
    val interestedPhilosophers: MutableList<Philosopher> = mutableListOf<Philosopher>()

    private fun getNameAsResources(): String {
        var resourceName = ""
        for (i in 0 until name.length) {
            if (name[i] == ' ' || name[i] == '-') {
                resourceName += '_'
            } else {
                resourceName += name[i]
            }
        }
        Log.d(TAG, "getNameAsResources: $resourceName")
        return resourceName.lowercase()
    }

    companion object {
        private val TAG: String = "[PhilosophyBranch]"
    }
}