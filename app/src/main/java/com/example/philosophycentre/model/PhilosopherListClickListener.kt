package com.example.philosophycentre.model

// This interface allows us to call navigate from an adapter
interface PhilosopherListClickListener {
    fun onPhilosopherListItemClick(philosopher: Philosopher)
}