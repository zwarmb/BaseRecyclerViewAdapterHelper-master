package com.example.yida.kotlin

/**
 * Created by yida on 2018/8/14.
 */
class Example {
    fun main(args: Array<String>) {
        val s = student("张三", 12)
        println()
    }


}

class MmClass {
    companion object {}
}

fun MmClass.Companion.foo() {
    println("伴随对象的扩展函数")
}

val MmClass.Companion.i: Int
    get() = 10

fun Mm() {
    println("no: ${MmClass.i}")
    MmClass.foo()
}


class ll {
    fun bar() {
        println("ll bar")
    }
}
class l {
    fun baz() {
        println("l baz")
    }

    fun ll.b() {
        bar()
        baz()
        this@l.baz()
    }

    fun caller(d: ll) {
        d.b()
    }
}

fun lll() {
    var l = l()
    var ll = ll()
    l.caller(ll)
}





/*
// 扩展函数 swap,调换不同位置的值
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]     //  this 对应该列表
    this[index1] = this[index2]
    this[index2] = tmp
}

fun m(args: Array<String>) {

    val l = mutableListOf(1, 2, 3)
    // 位置 0 和 2 的值做了互换
    l.swap(0, 2) // 'swap()' 函数内的 'this' 将指向 'l' 的值

    println(l.toString())
}*/

// 扩展函数 swap, 调换不同位置的值
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // this 对应的是该列表, 所以不能省略
    this[index1] = this[index2]
    this[index2] = tmp
}

fun mm() {
    var mutableListOf = mutableListOf(1, 2, 3)
    // 位置0 和 1 的值做了互换
    mutableListOf.swap(0,1) // 'swap() ' 函数内的 this 将指向 mutableList 的值
    println(mutableListOf.toString())
}



open class Person2(name: String) {

    fun main(name: String) {
        println("名字 : " + name)
    }
}


class student(name: String, age: Int) : Person2(name) {}


open class A {
    open fun f() {
        print("A")
    }

    fun a() {
        print("a")
    }
}

interface B {
    fun f() {
        print("B")
    } //接口的成员变量默认是 open 的

    fun b() {
        print("b")
    }
}

class C() : A(), B {
    override fun f() {
        println("c")
        // 注释掉也没关系
//        super<A>.f()//调用 A.f()
//        super<B>.f()//调用 B.f()
    }

    fun v() {
        super<B>.b() // 调用 B.b()
    }
}

fun main(args: Array<String>) {
    val c = C()
    c.f();

}


interface Foo {
    val count: Int
    fun a() {
        println("Foo  " + count)
    }
}

class Q(override val count: Int) : Foo {
    fun main() {
        println("Q " + count)
    }
}

class W() : Foo {
    override val count: Int
        get() = 12

    fun aq() {
        println("W " + count)
    }
}

class E : Foo {
    override val count: Int = 20
}


open class Person1(var name: String, var age: Int) {
    open var sex: String = "unknow"

    init {
        println("基类初始化" + sex)
    }
}

// 一下是正确用法
class Student(name: String, age: Int, var phone: Int) : Person1(name, age) {
    override var sex: String = ""
        get() = super.sex
        set(value) {
            field = "12315"
        }

    //    init {
//        println(sex)
//    }
    fun main() {
        println("数据" + sex)
    }
}


interface AInterFace {
    var name: String // name 属性, 抽象的
    fun bar() {
        // 可选的方法体
        println("啥都可以")
    }
    fun foo()
}

class BB : AInterFace {
    override var name: String = "suibianxiedianshenme" // 重载属性
    override fun foo() {
        super<AInterFace>.bar()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //这几种方法重写都可以
    fun aa() {
        super<AInterFace>.bar()
    }

    // 方法体
    override fun bar() {
        super.bar()
    }

}


class User(var name: String)

/**
 * 扩展函数
 */
fun User.Print() {
    println("用户名 $name")
}

fun main() {
    var user = User("张三")
    user.Print()
}



