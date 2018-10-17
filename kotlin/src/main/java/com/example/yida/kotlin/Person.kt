package com.example.yida.kotlin

/**
 * Created by yida on 2018/8/13.
 */
class Person{
    class Person constructor(name: String) {



        // 初始化代码需放入init中
        init {

        }
    }


    fun aa() {
        var aaaa = Aaaa("张三", 1);
        var aaaa1 = Aaaa("", "");

        // 由于Qq这个类构造被私有了, 所以在类外不能使用
//        var q = Qq();

    }

}



class Aaaa constructor(name: String) {
    var startName = name;

    constructor(name: String, age: Int): this(name) {}

    constructor(name: String, start: String): this(name) {}


    fun main(args: Array<String>) {
        var test = Test1()
        test.setInterface(object : Test {
            override fun test() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                println()
            }
        })



    }
}


class Qq private constructor() {


}


open class Base {
    open fun f() {}
}

abstract class MyBase: Base() {
    override fun f() {
        super.f()
    }
}



interface Test {
    fun test()
}

class Test1 {
    fun setInterface(test: Test) {
        test.test()
    }
}

fun main(ages: Array<String>) {

    var test = Test1()
    // 匿名内部类
    test.setInterface(object : Test {
        override fun test() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.


        }
    })

}