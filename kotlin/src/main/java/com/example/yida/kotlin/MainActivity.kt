package com.example.yida.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val v = Example()
//        v.main(arrayOf("aaa", "bbb"))

/*
        var w = W()
        w.aq()

        var q = Q(45)
        q.main()

        w.a()
        q.a()

        var s = Student("12", 12, 12345678)
        s.main()*/


//        main()
//        mm()

//        main(arrayOf(1, 2, 3))
//        ShuJu1()
//        box()


//        lei()

        ee()



//        a1()
//        qujian()

//        zifu('5')


//        max(1, 5)
//
//        var i = mm(9, 6)
//        println(i)
//
//        ziduchuan()

        /*   var s = "mdajdf"  // 类型参数都可用var替代
           var f = 6.6f;
           var a : Int = 3;

           val q:String = "dkahduq"*/
    }

    public fun max(a: Int, b: Int) : Unit { // 无返回参数用unit 来表明, 和java中的void一样 (kotlin中无返回参数可以忽略类型)
        var i = a + b
//        Log.e("tag", a+b)
        println(a+b)

    }


    fun mm(a: Int, b: Int) : Int {
        return a+b
    }


    fun ziduchuan() {

        var a = 1;
        val s1 = "a is $a"


        a = 5
        val s2 = "${s1.replace("is", "wwww")}, but not is $a"

        println("s1   " + s1 + "   s2" + s2)
    }


    fun jianchaNull() {

        // 类型后面加 ? 表示值可以为空
        var age : String? = "dmaw"

        // 字段/ 参数值后面加 !! 跑出空指针异常
        val ages = age!!.toInt()

        // 字段/参数值后加?可不做处理,返回值为空
        val age1 = age?.toInt()

        // age为空的时候返回-1
        val age2 = age?.toInt() ?: -1
    }


    fun qujian() : Unit {

        for (i in 1..10) {
            println(i)
        }

//        if (i in 1..10) { // 等同于 1 <= i && i <= 10
//            println()
//        }

        for (i in 1..8 step 3) { // 跳三步打印一个  step
            println(i)
        }

        val q = 1_0000_0000

        println(q)


        var a = 10
        var b = 20
        if (a and b == a) {

        }

    }



    fun zifu(c : Char) : Unit {
        if (c !in '0'..'5') {
            println("数据不对啊老铁")
            return
        }

        println("c  " + c.toInt())
    }


    fun shuzu(args : Array<Int>) {

        val list = arrayOf(1, 2, 3)

        val list1 = Array(5, {i ->(i * 2)})
    }


    fun zifuchuan() {

        val text : String = """
              你好
            我好
             大家好
        """.trimMargin()  // 去掉多余空格


        val t1 : String = ""

        var b = true;
        var i = 1
        when(b) {
//            1 -> {
//                println()
//                println()
//                println()
//            }
            true -> zifu('1')

            false -> {

            }
            else -> {
                Toast.makeText(applicationContext, "", Toast.LENGTH_LONG).show();
            }

        }

//        for (a in 1..10)

        when(t1) {
            is String -> {}
        }


        var bb1 = com.example.yida.kotlin.bb.bb("")


    }



    fun a1() {

        val bb = com.example.yida.kotlin.bb()
        bb.name = "zhangsan"
        bb.age = 5
        println("name  : ${bb.name},  age  : ${bb.age}")
        bb.age = 20
        println("name  : ${bb.name},  age  : ${bb.age}")



//            var name: String = "张三"
    }
}

class cc {

    fun main(name: String) {
        println(name)
    }
}

class Aaa {
    fun aa() {
        println("aa")
    }
}


class bb {

    class bb(name : String) {


    }

        var name: String = "asasas"
            get() = field.toUpperCase() // 将变量赋值后转化为大写

        var age = 12
            get() = field
            set(value) {
                if (value < 10) {
                    field = value
                } else {
                    field = -1
                }
            }
}
