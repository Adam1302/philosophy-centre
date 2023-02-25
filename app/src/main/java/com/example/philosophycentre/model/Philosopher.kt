package com.example.philosophycentre.model

import android.content.Context
import android.util.Log

class Philosopher(val name: String, val interests: List<String>, val context: Context) {
    val quotes = mutableListOf<Int>()
    private val lastNameLower = getLastNameLowerCase()
    val biography: String = getDescription()
    // private val quotes = mutableListOf<String>()

    init {
        populateQuoteList()
    }

    fun getDescription(): String {
        val descriptionStringName: String = lastNameLower + "_desc"
        return context.resources.getString(
            context.resources.getIdentifier(
                descriptionStringName,
                "string",
                context.packageName
            )
        )
    }

    private fun populateQuoteList() {
        var quoteCounter = 1

        while (true) {
            val stringName: String = lastNameLower + quoteCounter.toString()
            val quoteResID: Int = context.resources.getIdentifier(
                stringName,
                "string",
                context.packageName
            )
            if (quoteResID == 0) {
                break
            } else {
                // quotes.add(context.resources.getString(quoteResID))
                quotes.add(quoteResID)
            }
            ++quoteCounter
        }
    }

    private fun getLastNameLowerCase(): String {
        for (idx in name.length - 1 downTo 0) {
            if (name[idx] == ' ' || name[idx] == '-') {
                return name.substring(idx + 1).lowercase()
            }
        }
        return name.lowercase()
    }

    companion object {
        val TAG: String = "Philospher"
    }
}
