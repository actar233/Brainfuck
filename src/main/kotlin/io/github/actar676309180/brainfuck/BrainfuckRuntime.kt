package io.github.actar676309180.brainfuck

import java.util.*

class BrainfuckRuntime(private val list: List<Token>) {
    private val memory = HashMap<Long, Number>()

    fun exec() {
        var operator = 0
        var pointer = 0L
        val scanner = Scanner(System.`in`)

        fun number(): Number {
            var number = memory[pointer]
            if (number == null) {
                number = Number()
                memory[pointer] = number
            }
            return number
        }

        fun valuePlus() {
            number().inc()
        }

        fun valueMinus() {
            number().dec()
        }

        fun valuePlusNumber() {
            val number = list[++operator]
            if (number is Number) {
                number().plus(number)
            }
        }

        fun valueMinusNumber() {
            val number = list[++operator]
            if (number is Number) {
                number().minus(number)
            }
        }

        fun pointerPlus() {
            pointer++
        }

        fun pointerMinus() {
            pointer--
        }

        fun pointerPlusNumber() {
            val number = list[++operator]
            if (number is Number) {
                pointer += number.value()
            }
        }

        fun pointerMinusNumber() {
            val number = list[++operator]
            if (number is Number) {
                pointer -= number.value()
            }
        }

        fun input() {
            val text = scanner.next()
            if (text.isNotEmpty()) {
                number().set(text[0].toLong())
            }
        }

        fun output() {
            print(number().value().toChar())
        }

        fun openJump() {
            if (number().isZero()) {
                var count = 1
                while (count != 0) {
                    operator++
                    if (list[operator] == Operator.OPEN_JUMP) {
                        count++
                    }
                    if (list[operator] == Operator.CLOSE_JUMP) {
                        count--
                    }
                }
            }
        }

        fun closeJump() {
            if (number().isNotZero()) {
                var count = -1
                while (count != 0) {
                    operator--
                    if (list[operator] == Operator.OPEN_JUMP) {
                        count++
                    }
                    if (list[operator] == Operator.CLOSE_JUMP) {
                        count--
                    }
                }
            }
        }

        fun setNumber() {
            val number = list[++operator]
            if (number is Number) {
                number().set(number.value())
            }
        }

        fun setPointer() {
            val number = list[++operator]
            if (number is Number) {
                pointer = number.value()
            }
        }

        while (operator < list.size) {
            when (list[operator]) {
                Operator.VALUE_PLUS -> valuePlus()
                Operator.VALUE_MINUS -> valueMinus()
                Operator.VALUE_PLUS_NUMBER -> valuePlusNumber()
                Operator.VALUE_MINUS_NUMBER -> valueMinusNumber()
                Operator.POINTER_PLUS -> pointerPlus()
                Operator.POINTER_MINUS -> pointerMinus()
                Operator.POINTER_PLUS_NUMBER -> pointerPlusNumber()
                Operator.POINTER_MINUS_NUMBER -> pointerMinusNumber()
                Operator.INPUT -> input()
                Operator.OUTPUT -> output()
                Operator.OPEN_JUMP -> openJump()
                Operator.CLOSE_JUMP -> closeJump()
                Operator.SET_NUMBER -> setNumber()
                Operator.SET_POINTER -> setPointer()
            }
            operator++
        }
    }
}