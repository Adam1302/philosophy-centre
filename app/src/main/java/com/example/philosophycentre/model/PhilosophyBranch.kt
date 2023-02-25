package com.example.philosophycentre.model

import android.content.Context
import android.util.Log

class PhilosophyBranch(val name: String, val context: Context) {
    val branchDescription = getDescription()
    val interestedPhilosophers: MutableList<Philosopher> = mutableListOf<Philosopher>()

    private fun getDescription(): String {
        val descriptionStringName: String = getNameAsResources()
        return context.resources.getString(
            context.resources.getIdentifier(
                descriptionStringName,
                "string",
                context.packageName
            )
        )
    }

    private fun getNameAsResources(): String {
        var resourceName = ""
        for (i in 0 until name.length) {
            if (name[i] == ' ' || name[i] == '-') {
                resourceName += '_'
            } else if (name[i] >= 'A' && name[i] <= 'Z') {
                resourceName += name[i].lowercase()
            } else {
                resourceName += name[i]
            }
        }
        Log.d(TAG, "getNameAsResources: $resourceName")
        return resourceName + "_desc"
    }

    companion object {
        private val TAG: String = "[PhilosophyBranch]"
    }
}