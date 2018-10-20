package io.github.actar676309180.brainfuck

fun main(args: Array<String>) {
    val code = """
        #48.#49.#50.>,.
    """.trimIndent()
    Brainfuck(code).exec()
}