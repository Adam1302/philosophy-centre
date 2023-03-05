package com.example.philosophycentre.dataclasses

import com.example.philosophycentre.model.PhilosophyBranch

/*
val philosophyBranchList: List<PhilosophyBranch> = listOf(
    PhilosophyBranch(
        "Ethics"
    ),
    PhilosophyBranch(
        "Aesthetics"
    ),
    PhilosophyBranch(
        "Political Philosophy"
    ),
    PhilosophyBranch(
        "Epistemology"
    ),
    PhilosophyBranch(
        "Axiology"
    ),
    PhilosophyBranch(
        "Metaphysics"
    ),
    PhilosophyBranch(
        "Logic"
    )
)
 */

val philosophyBranchMap: Map<String, PhilosophyBranch> = mapOf(
    Pair("Ethics", PhilosophyBranch("Ethics")),
    Pair("Aesthetics", PhilosophyBranch("Aesthetics")),
    Pair("Political Philosophy", PhilosophyBranch("Political Philosophy")),
    Pair("Epistemology", PhilosophyBranch("Epistemology")),
    Pair("Axiology", PhilosophyBranch("Axiology")),
    Pair("Metaphysics", PhilosophyBranch("Metaphysics")),
    Pair("Logic", PhilosophyBranch("Logic")),
    Pair("Philosophy of Science", PhilosophyBranch("Philosophy of Science")),
    Pair("Philosophy of Religion", PhilosophyBranch("Philosophy of Religion")),
    Pair("Theology", PhilosophyBranch("Theology"))
)