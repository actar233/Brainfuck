package io.github.actar233.brainfuck

object Tokenizer {
    fun parse(text: String): List<Token> {
        val list = ArrayList<Token>()
        var index = 0

        fun readNumber(): Number? {
            var i = index + 1
            var number: Long? = null
            while (i < text.length) {
                val n = text[i]
                if (n in '0'..'9') {
                    if (number == null) {
                        number = (n.toLong() - 48)
                    } else {
                        number = 10 * number + (n.toLong() - 48)
                    }
                } else {
                    break
                }
                i++
            }
            if (number != null) return Number(number)
            return null
        }

        while (index < text.length) {
            when (text[index]) {
                '+' -> {
                    val number = readNumber()
                    if (number != null) {
                        list += Operator.VALUE_PLUS_NUMBER
                        list += number
                    } else {
                        list += Operator.VALUE_PLUS
                    }
                }
                '-' -> {
                    val number = readNumber()
                    if (number != null) {
                        list += Operator.VALUE_MINUS_NUMBER
                        list += number
                    } else {
                        list += Operator.VALUE_MINUS
                    }
                }
                '>' -> {
                    val number = readNumber()
                    if (number != null) {
                        list += Operator.POINTER_PLUS_NUMBER
                        list += number
                    } else {
                        list += Operator.POINTER_PLUS
                    }
                }
                '<' -> {
                    val number = readNumber()
                    if (number != null) {
                        list += Operator.POINTER_MINUS_NUMBER
                        list += number
                    } else {
                        list += Operator.POINTER_MINUS
                    }
                }
                ',' -> list += Operator.INPUT
                '.' -> list += Operator.OUTPUT
                '[' -> list += Operator.OPEN_JUMP
                ']' -> list += Operator.CLOSE_JUMP
                '#' -> {
                    val number = readNumber()
                    list += Operator.SET_NUMBER
                    list += if (number != null) {
                        number
                    } else {
                        Number()
                    }
                }
                '&' -> {
                    val number = readNumber()
                    list += Operator.SET_POINTER
                    list += if (number != null) {
                        number
                    } else {
                        throw RuntimeException("&后必须有数字")
                    }
                }
            }
            index++
        }
        return list
    }
}