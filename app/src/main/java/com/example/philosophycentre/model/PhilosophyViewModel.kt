package com.example.philosophycentre.model

import android.util.Log
import androidx.lifecycle.ViewModel

class PhilosophyViewModel : ViewModel() {
    val fullQuoteList: MutableList<Quote> = mutableListOf<Quote>()
    val philosopherList: MutableList<Philosopher> = mutableListOf<Philosopher>()
    val branchList: MutableList<PhilosophyBranch> = mutableListOf<PhilosophyBranch>()
    var currentPhilosopher: Philosopher? = null
    var currentBranch: PhilosophyBranch? = null

    fun addPhilosophyBranch(philosophyBranch: PhilosophyBranch) {
        branchList.add(philosophyBranch)
    }

    fun addPhilosopher(philosopher: Philosopher) {
        philosopherList.add(philosopher)

        addQuotes(philosopher.name, philosopher.quotes)
    }

    private fun addQuotes(philosopherName: String, addedQuoteList: List<Int>) {
        for (quoteID in addedQuoteList) {
            fullQuoteList.add(
                Quote(quoteID, philosopherName)
            )
        }
    }

    companion object {
        val TAG: String = "[PhilosophyViewModel]"
    }
}