package com.example.philosophycentre.dataclasses

import com.example.philosophycentre.model.Philosopher
import com.example.philosophycentre.model.PhilosophyBranch

val philosopherList : List<Philosopher> = listOf(
    Philosopher(
        "Socrates",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Epistemology"]!!,
            philosophyBranchMap["Metaphysics"]!!
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
        "Aristotle",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Logic"]!!,
            philosophyBranchMap["Epistemology"]!!,
            philosophyBranchMap["Metaphysics"]!!,
            philosophyBranchMap["Axiology"]!!,
            philosophyBranchMap["Aesthetics"]!!,
            philosophyBranchMap["Political Philosophy"]!!
        )
    ),
    Philosopher(
        "Jesus Christ",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Metaphysics"]!!,
            philosophyBranchMap["Axiology"]!!
        )
    ),
    Philosopher(
        "Marcus Aurelius",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Axiology"]!!
        )
    ),
    Philosopher(
        "Boethius",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Epistemology"]!!
        )
    ),
    Philosopher(
        "Al-Kindi",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Logic"]!!,
            philosophyBranchMap["Metaphysics"]!!
        )
    ),
    Philosopher(
        "Thomas Aquinas",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Logic"]!!,
            philosophyBranchMap["Metaphysics"]!!,
            philosophyBranchMap["Epistemology"]!!
        )
    ),
    Philosopher(
        "Michel De Montaigne",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Axiology"]!!
        )
    ),
    Philosopher(
        "Francis Bacon",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Axiology"]!!
        )
    ),
    Philosopher(
        "Thomas Hobbes",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Political Philosophy"]!!,
            philosophyBranchMap["Ethics"]!!
        )
    ),
    Philosopher(
        "Blaise Pascal",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Logic"]!!,
            philosophyBranchMap["Epistemology"]!!
        )
    ),
    Philosopher(
        "Baruch Spinoza",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Metaphysics"]!!,
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Epistemology"]!!
        )
    ),
    Philosopher(
        "Voltaire",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Political Philosophy"]!!
        )
    ),
    Philosopher(
        "Friedrich Nietzsche",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Aesthetics"]!!,
            philosophyBranchMap["Axiology"]!!
        )
    ),
)