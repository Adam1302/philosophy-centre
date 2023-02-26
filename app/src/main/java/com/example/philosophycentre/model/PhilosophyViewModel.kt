package com.example.philosophycentre.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class PhilosophyViewModel : ViewModel() {
    val fullQuoteList: MutableList<Quote> = mutableListOf<Quote>()
    val philosopherList: MutableList<Philosopher> = mutableListOf<Philosopher>()
    val branchList: MutableList<PhilosophyBranch> = mutableListOf<PhilosophyBranch>()
    var currentPhilosopher: Philosopher? = null
    var currentBranch: PhilosophyBranch? = null

    fun addPhilosophyBranch(philosophyBranch: PhilosophyBranch, context: Context) {
        branchList.add(philosophyBranch)

        addDescription(philosophyBranch, context)
    }

    fun addPhilosopher(philosopher: Philosopher, context: Context) {
        philosopherList.add(philosopher)

        populateQuoteList(philosopher, context)
        addDescription(philosopher, context)
    }

    private fun addDescription(philosopher: Philosopher, context: Context) {
        val descriptionStringName: String = philosopher.lastNameLower + "_desc"
        philosopher.biography = context.resources.getString(
            context.resources.getIdentifier(
                descriptionStringName,
                "string",
                context.packageName
            )
        )
    }

    private fun addDescription(philosopherBranch: PhilosophyBranch, context: Context) {
        philosopherBranch.branchDescription = context.resources.getString(
            context.resources.getIdentifier(
                philosopherBranch.branchNameAsLower,
                "string",
                context.packageName
            )
        )
    }

    private fun populateQuoteList(philosopher: Philosopher, context: Context) {
        var quoteCounter = 1

        while (true) {
            val stringName: String = philosopher.lastNameLower + quoteCounter.toString()
            val quoteResID: Int = context.resources.getIdentifier(
                stringName,
                "string",
                context.packageName
            )
            if (quoteResID == 0) {
                break
            } else {
                // quotes.add(context.resources.getString(quoteResID))
                philosopher.quotes.add(quoteResID)
            }
            ++quoteCounter
        }

        for (quoteID in philosopher.quotes) {
            fullQuoteList.add(
                Quote(quoteID, philosopher.name)
            )
        }
    }

    companion object {
        val TAG: String = "[PhilosophyViewModel]"
    }
}