package com.example.yida.kotlin

/**
 * Created by yida on 2018/8/17.
 */
class MyClass {

    companion object {
        val myClass1: Int = 1
        val myClass2 = "this is myClass"

        fun companionFun1() {
            println("this is 1st companion function.")
            foo()
        }

        fun companionFun2() {
            println("this is 2st companion function.")
            companionFun1()
        }
    }
    fun MyClass.Companion.foo() {
        println("伴随对象的扩展函数 (内部) ")
    }

    fun test2() {
        MyClass.foo()
    }

    init {
        test2()
    }

}
fun MyClass.Companion.foo() {
    println("foo 伴随对象外部扩展函数")
}

val MyClass.Companion.no: Int
    get() = 10

fun main(args: Array<Int>) {
    println(" no: ${MyClass.no} ")
    println(" class1 : ${MyClass.myClass1} ")
    println(" class2 : ${MyClass.myClass2} ")
    MyClass.foo()
    MyClass.companionFun2()
}