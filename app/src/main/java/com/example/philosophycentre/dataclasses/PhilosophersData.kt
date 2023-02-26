package com.example.philosophycentre.dataclasses

import com.example.philosophycentre.model.Philosopher
import com.example.philosophycentre.model.PhilosophyBranch

val philosopherList : List<Philosopher> = listOf(
    Philosopher(
        "Friedrich Nietzsche",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Aesthetics"]!!,
            philosophyBranchMap["Axiology"]!!
        )
    ),
    Philosopher(
        "Socrates",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Epistemology"]!!,
            philosophyBranchMap["Metaphysics"]!!
        )
    ),
    Philosopher(
        "Voltaire",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Political Philosophy"]!!
        )
    ),
    Philosopher(
        "Plato",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Epistemology"]!!,
            philosophyBranchMap["Political Philosophy"]!!,
            philosophyBranchMap["Metaphysics"]!!,
            philosophyBranchMap["Axiology"]!!
        )
    ),
    Philosopher(
        "Boethius",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Epistemology"]!!
        )
    )
)