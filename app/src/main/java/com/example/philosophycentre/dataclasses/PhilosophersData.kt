package com.example.philosophycentre.dataclasses

import com.example.philosophycentre.model.Philosopher

val philosopherList : List<Philosopher> = listOf(
    Philosopher(
        "Friedrich Nietzsche",
        listOf("Philology", "Ethics/Morality", "Aesthetics", "Ontology", "Philosophy of Religion")
    ),
    Philosopher(
        "Socrates",
        listOf("Epistemology", "Ethics/Morality", "Teleology")
    ),
    Philosopher(
        "Voltaire",
        listOf("Political Philosophy", "Social Philosophy", "Literature")
    ),
    Philosopher(
        "Plato",
        listOf("Epistemology", "Ethics/Morality", "Metaphysics", "Political Philosophy")
    ),
    Philosopher(
        "Boethius",
        listOf("Fate", "Epistemology", "Theology")
    )
)