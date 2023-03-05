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
            philosophyBranchMap["Political Philosophy"]!!,
            philosophyBranchMap["Philosophy of Science"]!!
        )
    ),
    Philosopher(
        "Jesus Christ",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Theology"]!!,
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
            philosophyBranchMap["Epistemology"]!!,
            philosophyBranchMap["Theology"]!!
        )
    ),
    Philosopher(
        "Al-Kindi",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Theology"]!!,
            philosophyBranchMap["Logic"]!!,
            philosophyBranchMap["Metaphysics"]!!,
            philosophyBranchMap["Philosophy of Science"]!!
        )
    ),
    Philosopher(
        "Thomas Aquinas",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Theology"]!!,
            philosophyBranchMap["Logic"]!!,
            philosophyBranchMap["Metaphysics"]!!,
            philosophyBranchMap["Epistemology"]!!
        )
    ),
    Philosopher(
        "Michel De Montaigne",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Philosophy of Religion"]!!,
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Axiology"]!!
        )
    ),
    Philosopher(
        "Francis Bacon",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Philosophy of Science"]!!,
            philosophyBranchMap["Logic"]!!
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
            philosophyBranchMap["Philosophy of Science"]!!,
            philosophyBranchMap["Logic"]!!,
            philosophyBranchMap["Epistemology"]!!,
            philosophyBranchMap["Theology"]!!
        )
    ),
    Philosopher(
        "Baruch Spinoza",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Metaphysics"]!!,
            philosophyBranchMap["Philosophy of Religion"]!!,
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Epistemology"]!!
        )
    ),
    Philosopher(
        "Isaac Newton",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Logic"]!!,
            philosophyBranchMap["Philosophy of Science"]!!
        )
    ),
    Philosopher(
        "Voltaire",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Political Philosophy"]!!,
            philosophyBranchMap["Philosophy of Religion"]!!
        )
    ),
    Philosopher(
        "David Hume",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Axiology"]!!,
            philosophyBranchMap["Epistemology"]!!,
            philosophyBranchMap["Metaphysics"]!!,
            philosophyBranchMap["Philosophy of Religion"]!!
        )
    ),
    Philosopher(
        "Immanuel Kant",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Axiology"]!!,
            philosophyBranchMap["Epistemology"]!!,
            philosophyBranchMap["Metaphysics"]!!,
            philosophyBranchMap["Philosophy of Religion"]!!,
            philosophyBranchMap["Theology"]!!
        )
    ),
    Philosopher(
        "Jean-Jacques Rousseau",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Political Philosophy"]!!
        )
    ),
    Philosopher(
        "Jeremy Bentham",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Axiology"]!!,
            philosophyBranchMap["Political Philosophy"]!!
        )
    ),
    Philosopher(
        "Friedrich Schiller",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Aesthetics"]!!,
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Metaphysics"]!!,
            philosophyBranchMap["Axiology"]!!,
            philosophyBranchMap["Political Philosophy"]!!
        )
    ),
    Philosopher(
        "Georg Wilhelm Friedrich Hegel",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Metaphysics"]!!,
            philosophyBranchMap["Logic"]!!,
            philosophyBranchMap["Aesthetics"]!!,
            philosophyBranchMap["Political Philosophy"]!!,
            philosophyBranchMap["Philosophy of Science"]!!,
            philosophyBranchMap["Philosophy of Religion"]!!,
        )
    ),
    Philosopher(
        "Arthur Schopenhauer",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Metaphysics"]!!,
            philosophyBranchMap["Aesthetics"]!!,
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Philosophy of Religion"]!!,
            philosophyBranchMap["Axiology"]!!
        )
    ),
    Philosopher(
        "Ralph Waldo Emerson",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Aesthetics"]!!,
            philosophyBranchMap["Axiology"]!!
        )
    ),
    Philosopher(
        "John Stuart Mill",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Axiology"]!!,
            philosophyBranchMap["Logic"]!!,
            philosophyBranchMap["Political Philosophy"]!!
        )
    ),
    Philosopher(
        "Soren Kierkegaard",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Epistemology"]!!,
            philosophyBranchMap["Aesthetics"]!!,
            philosophyBranchMap["Philosophy of Religion"]!!,
            philosophyBranchMap["Theology"]!!,
            philosophyBranchMap["Axiology"]!!
        )
    ),
    Philosopher(
        "Henry David Thoreau",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Philosophy of Religion"]!!,
            philosophyBranchMap["Aesthetics"]!!,
            philosophyBranchMap["Political Philosophy"]!!
        )
    ),
    Philosopher(
        "William James",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Epistemology"]!!,
            philosophyBranchMap["Philosophy of Science"]!!,
            philosophyBranchMap["Philosophy of Religion"]!!,
            philosophyBranchMap["Axiology"]!!
        )
    ),
    Philosopher(
        "Friedrich Nietzsche",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Aesthetics"]!!,
            philosophyBranchMap["Axiology"]!!,
            philosophyBranchMap["Philosophy of Religion"]!!,
            philosophyBranchMap["Ethics"]!!,
        )
    ),
    Philosopher(
        "Sigmond Freud",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Axiology"]!!,
            philosophyBranchMap["Philosophy of Religion"]!!
        )
    ),
    Philosopher(
        "Carl Jung",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Axiology"]!!,
            philosophyBranchMap["Philosophy of Religion"]!!
        )
    ),
    Philosopher(
        "Carlos Santayana",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Epistemology"]!!,
            philosophyBranchMap["Metaphysics"]!!,
            philosophyBranchMap["Axiology"]!!,
            philosophyBranchMap["Political Philosophy"]!!,
            philosophyBranchMap["Philosophy of Religion"]!!
        )
    ),
    Philosopher(
        "Bertrand Russell",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Logic"]!!,
            philosophyBranchMap["Epistemology"]!!,
            philosophyBranchMap["Metaphysics"]!!,
            philosophyBranchMap["Philosophy of Science"]!!
        )
    ),
    Philosopher(
        "Ludwig Wittgenstein",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Logic"]!!,
            philosophyBranchMap["Metaphysics"]!!,
            philosophyBranchMap["Epistemology"]!!,
            philosophyBranchMap["Philosophy of Science"]!!,
            philosophyBranchMap["Philosophy of Religion"]!!,
            philosophyBranchMap["Aesthetics"]!!
        )
    ),
    Philosopher(
        "Martin Heidegger",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Metaphysics"]!!,
            philosophyBranchMap["Logic"]!!,
            philosophyBranchMap["Epistemology"]!!
        )
    ),
    Philosopher(
        "Jean-Sartre Sartre",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Metaphysics"]!!,
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Epistemology"]!!
        )
    ),
    Philosopher(
        "Ayn Rand",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Philosophy of Religion"]!!
        )
    ),
    Philosopher(
        "Hannah Arendt",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Political Philosophy"]!!
        )
    ),
    Philosopher(
        "Albert Camus",
        listOf<PhilosophyBranch>(
            philosophyBranchMap["Ethics"]!!,
            philosophyBranchMap["Metaphysics"]!!,
            philosophyBranchMap["Political Philosophy"]!!
        )
    )
)