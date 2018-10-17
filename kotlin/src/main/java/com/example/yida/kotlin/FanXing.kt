package com.example.yida.kotlin

/**
 * Created by yida on 2018/8/20.
 */
class Box<T>(t: T) {
    var value = t
}


val box: Box<Int> = Box<Int>(12)
// 此处后面可以省略类型
val box2: Box<Int> = Box(88)
// 编译器会进行类型判断, 99 类型为 Int, 所以编译器知道我们说的是 Box<Int>
val box1 = Box(99)


fun box() {
    // 编译器可以识别当前参数类型
    var boxInt = Box(99)
    var boxString = Box("泛型")


    println("Int  " + boxInt.value)
    println("String  " + boxString.value)
}


fun <T> BoxIn(value: T) = Box(value)

// 以下都是合法语句
val box3 = BoxIn(77)
val box4 = BoxIn("什么鬼")     // 这两个会自动进行类型推断

val box5 = BoxIn<Int>(233)


fun lei() {
    val z = 666
    val z1 = "hdahdh"
    val z2 = true

    doPrintln(z)
    doPrintln(z1)
    doPrintln(z2)
}


fun <T> doPrintln(content: T) {

    when(content) {
        is Int -> println("整型数字为  $content")
        is String -> println("字符串转换为大写: ${content.toUpperCase()}")
        else -> println("T 不是整型也不是字符串  $content")

    }
}


fun <T : Comparable<T>> sort(list: List<T>) {

    // ok   Int 是 comparable<Int> 的子类型
    sort(listOf(1, 2, 3))
    // 错误: hashMap<Int, string> 不是 compareable<HashMap<Int, String>> 的子类型
//    sort(listOf(HashMap<Int, String>()))
}

fun <T> copyWhen(list: List<T>, threshold: T): List<String>
    where T: CharSequence,
          T: Comparable<T> {
    return list.filter { it > threshold }.map { it.toString() }
}


// 定义一个支持协变的类
class Runoob<out A>(val a: A) {
    fun foo(): A {
        return a
    }
}

fun xin() {
    var strCo: Runoob<String> = Runoob("a")
    var anyCo: Runoob<Any> = Runoob<Any>("b")
    anyCo = strCo
    println(anyCo.foo())    // 输出 a

}


//// 定义一个支持协变的类
//class Runoobb<in AA>(val b: AA) {
//    fun foo(): A {
//        return b
//    }
//}
//
//fun xin() {
//    var strCo: Runoob<String> = Runoob("a")
//    var anyCo: Runoob<Any> = Runoob<Any>("b")
//    anyCo = strCo
//    println(anyCo.foo())    // 输出 a
//
//}

enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },
    TALKING {
      override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}


//EnumClass.valueOf(value: String): EnumClass  // 转换指定 name 为枚举值，若未匹配成功，会抛出IllegalArgumentException
//EnumClass.values(): Array<EnumClass>        // 以数组的形式，返回枚举值
//
////获取枚举相关信息：
//
//val name: String //获取枚举名称
//val ordinal: Int //获取枚举值在所有枚举数组中定义的顺序



enum class Color{
    RED, BLACK, BLUE, GREEN, WHITE
}

fun ee() {
    var color: Color = Color.BLUE

    println(Color.values())
    println(Color.valueOf("RED"))
    println(color.name)
    println(color.ordinal) // 枚举中的顺序

}


inline fun <reified T : Enum<T>> printAllValues() {
    println(enumValues<T>().joinToString { it.name })
}

fun k11() {
    printAllValues<Color>() // 输出 :  RED, BLACK, BLUE, GREEN, WHITE
}









