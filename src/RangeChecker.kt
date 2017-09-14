import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val userInput = input.nextInt()
    if (userInput in 1..9)
        println("OK")
    for (a in 1..5)
        print("${a} ")
    println()
    val array = arrayListOf<String>()
    array.add("aaa")
    array.add("bbb")
    array.add("ccc")
    if (userInput !in 0..array.size - 1)
        println("Out: array has only ${array.size} elements. userInput = ${userInput}")
    else println("IN: array has only ${array.size} elements. userInput = ${userInput}")
    if ("aaa" in array)
        println("Yes: array contains aaa")
    if ("ddd" in array)
        println("Yes: array contains ddd")
    else
        println("No: array doesn't contains ddd")
}