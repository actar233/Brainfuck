package io.github.actar233.brainfuck

fun main() {
    val code = """
        #48.#49.#50.>,.
    """.trimIndent()
    Brainfuck(code).exec()
}