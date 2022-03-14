package io.github.actar233.brainfuck

class Brainfuck(text:String){
    private val list:List<Token>
    init {
        list = Tokenizer.parse(text)
    }
    fun exec(){
        val brainfuck = BrainfuckRuntime(list)
        brainfuck.exec()
    }
}