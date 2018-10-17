package com.example.yida.kotlin

import android.view.View

/**
 * Created by yida on 2018/8/17.
 */
class ShuJu {

    data class User(val name: String, val age: Int) {}

}


//fun copy(name: String, age: Int) = ShuJu.User(name, age)

fun copy(name: String, age: Int) = ShuJu.User(name, age)



fun ShuJu1() {
    var user = ShuJu.User("zhangsan", 55)
    var copy = user.copy(age = 99)
    var copy1 = user.copy(name = "lisi")

    println(user)
    println(copy)
    println(copy1)


    var user1 = ShuJu.User("wangwu", 22)
    val (name, age) = user1

}



sealed class Expr
data class Const(val number: Double) : Expr()



sealed class Uiop {
    object show: Uiop()
    object Hide: Uiop()

    class TranslateX(val px: Float): Uiop() // 此处定义为 val 常量, 不然调用该方法时无法调取函数
    class TranslateY(val py: Float): Uiop()

}



fun execute(view: View, op: Uiop) = when(op) {
    Uiop.show -> view.visibility = View.VISIBLE
    Uiop.Hide -> view.visibility = View.GONE

    // 这个 when 语句分支不仅告诉 view 要水平移动, 还告诉 view 需要移动多少距离, 这是枚举等 java 传统思想不容易实现的
    is Uiop.TranslateX -> view.translationX = op.px
    is Uiop.TranslateY -> view.translationY = op.py

}


class Ui(val  uiops: List<Any> = emptyList()) { // Any 表示任何类型, 不添加类型会报错
    operator fun plus(uiop: Uiop) = Ui(uiops + uiop)
}

val ui = Ui() + Uiop.show + Uiop.TranslateX(50f) + Uiop.TranslateY(100f) + Uiop.Hide

fun run(view: View, ui: Ui) {

}

fun main(args: Array<String>) {

}