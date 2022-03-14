package io.github.actar233.brainfuck

enum class Operator : Token {
    // + -
    VALUE_PLUS,VALUE_MINUS,
    VALUE_PLUS_NUMBER,VALUE_MINUS_NUMBER,
    // > <
    POINTER_PLUS,POINTER_MINUS,
    POINTER_PLUS_NUMBER,POINTER_MINUS_NUMBER,
    // , .
    INPUT,OUTPUT,
    // [ ]
    OPEN_JUMP,CLOSE_JUMP,
    // # &
    SET_NUMBER,SET_POINTER
}