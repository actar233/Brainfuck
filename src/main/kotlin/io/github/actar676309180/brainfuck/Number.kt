package io.github.actar676309180.brainfuck

class Number(private var number:Long=0L) : Token {
    fun value()=number

    fun set(number: Long){
        this.number=number
    }

    fun plus(other: Number){
        this.number+=other.number
    }

    fun minus(other: Number){
        this.number-=other.number
    }

    fun inc() {
        number++
    }

    fun dec() {
        number--
    }

    fun isZero():Boolean{
        return number==0L
    }

    fun isNotZero():Boolean{
        return number!=0L
    }

    override fun toString(): String {
        return "Number:$number"
    }

}