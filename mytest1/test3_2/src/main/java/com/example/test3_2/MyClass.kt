
    package com.example.test3_2

    import com.example.test3_2.Myclass.Companion.data


    // 최고 상위 영역 : 선언과 동시에 초깃값 할당.
//    val name = "이상용"
    val name2:String = "이상용2"
    val num1 = 10;

    val data4 : Int by lazy {
        println("lazy 테스트")
        10
    }


    class MyClass2 {
        // 클래스 안에 영역, 선언과 동시에 초깃값 할당.
//     var name4 :
        var name = "이상용3"
        var age = 40;
        val name2 = "이상용4"
    }


    class User{
        var name = "lsy"
        constructor(name: String){
            this.name = name
        }
        fun someFun() {
            println("name : $name")
        }

    }
    class User2(name: String, age:Int){
        init {
            println("객체 생성 할 때 마다, init 실행이 됨.")
        }
    }

    class User5(val name:String,val age:Int) {
        init {
            println("init 안에서는 주생성자 매개변수 사용가능. : $name, $age")
        }
    }

    class User4(name: String, age: Int, phone: String) {
//        constructor(name: String, age: Int):this(name)
//        constructor(name: String, age: Int, phone:String):this(name,age)
    }
//    class Super(name: String){
//    }
//    class Sub: Super{
//        constructor(name: String): super(name){
//        }
//    }

    class NonDataClass(val name:String, val age:Int)

    data class DataClass(val name:String, val age:Int)

    // 타입을 명시 안하면 외부에서 사용못함.
    val obj = object{
        var data = 10
        fun some() {
            println("익명 클래스 테스트")
        }
    }


    fun main() {

//? 연산자를 이용해서  null 할당 가능.
        var data33: String? = null
        //? 연산자를 사용한 변수로 특정 함수에 접근시 ? 기호를 사용하거나
        // 또는 !! 예외 발생 연산자를 사용해야함.
        //참고. 널 체크 가 빠지게 되면 컴파일러가 친절히 알려줌.
        data33?.length

        //만약에, 널이 아니면 해당 길이를 반환하고,
        //만약에 널이면 지정한 값을 사용한다.
        //nvl 함수와 비슷한 구조
        //삼항 다항식 비슷한 구조
        data33?.length ?: 0

        println("널안정성 체크해보기")
        println( data33?.length ?: 0)

    }
        class Myclass {
            companion object {
                var data = 10
                fun some() {
                    println("컴패니언 object 테스트")
                }
            }




        val nonData1 = NonDataClass("lsy1",30)
        val nonData2 = NonDataClass("lsy2",20)
        val dataClass1 = NonDataClass("lsy3",40)
        val dataClass2 = NonDataClass("lsy3",40)
//        println(nonData1.equals(nonData2))
//        println(dataClass1.equals(dataClass2))
//        println(nonData1.toString())
//        println(nonData2.toString())







        var user2 = User2("lsy2",30)



//        var myClass2 : MyClass2()
//        myClass2.age

        //객체 생성시 new 없이, 바로 생성자 호출 방법.
//        val user = User("lsy2")
//        user.someFun()
//
//        var data23 = arrayOf<Int>(10,20,30)
//        for ((index, value) in data23.withIndex()) {
//            print(value)
//            if (index !== data23.size - 1) print(",")
//        }
//        println("========================")
//
//        var data22 = arrayOf<Int>(10,20,30)
//        for (i in data22.indices) {
//            print(data22[i])
//            if (i !== data22.size - 1) print(",")
//        }
//
//        println("========================")
//
//        var sum: Int = 0
//        for (i in 1..10){
//            sum += i}
//        println(sum)
//
//        var data21 :Any = "hi"
//        val result21 = when (data21) {
//            is String -> println("data is String")
//            in 1..10 -> println("data is 1..10")
//            else ->{
//                println("data is not valid")
//            }
//        }
//
//        var data19 = "hi"
//        when (data19) {
//            "hi" -> println("data is hi")
//            "hi2" -> println("data is hi2")
//            else -> {
//                println("data is not valid")
//            }
//        }
//
//        var data = 10
//        val result = if(data >0){
//            println("테스트")
//            true
//        } else{
//            println("else 테스트")
//            false
//        }
//
//        println("result 결과값 테스트 : $result")
//
//
//    //가변 길이의 리스트, 맵
//    val data18 = mutableMapOf<String,String>()
//    data18.set("key","value")
//    data18.set("key2",2)
////    data18.set("key3",MyClass2)
//    println(data18.get("key"))
//
//    val data17 = mutableListOf<Int>()
//    data17.add(1)
//    data17.add(2)
//    println(data17[0])
//
//    val data15 = intArrayOf(10,20,30)
//    val data16 = booleanArrayOf(true,false)
//
//
//    val data14 : Array<Int> = Array(3,{0})
//    data14[0] =10
//    data14[1] =20
//    data14.set(2,30)
//
//    println(
//        """
// array size : ${data14.size}
// array data : ${data14[0]}, ${data14[1]}, ${data14.get(2)}
//            """
// )
//
//
//    
//    
////    fun some ( data1: Int, data2: Int = 10): Int{
////        return data1 * data2
////    }
////    println(some(data1 = 200, data2 = 100))
////
////    fun some2(): Nothing {
////        throw Exception()
////    }
////
//////    var n1 : Int?
//////     n1 : null
////
////    var data13 : Nothing? = null
//
//    var data12: Any = 10
//    var data2: Any = "String"
//    var data3: Any = MyClass2()
//
//    fun test3():Unit {
//        println(data12)
//        println(data2)
//        println(data3)
//    }
//
//    fun addSum(no: Int):Int {
//        var sum = 0
//        for(i in 1..no) {
//            sum += i
//        }
//        return sum
//    }
//    val name = "yong"
//    println("name: $name, sum: ${addSum(10)}")
//    //함수 내부에서 선언만
//    val str1 = "hi \n yong"
//    val str2 = """
// hi
// world
// """
//    println("str1 : $str1")
//    println("str2 : $str2")
//
//    var data1: Int = 10
//
//    data1 = data1 + 10
//    data1 = data1.plus(10)
//
//    var name10: String
//    //
//    var myclass2 = MyClass2()
//    //myclass2.name2= "이상용5"
//    println(myclass2.name)
//    println(myclass2.age)
//    println(myclass2.name2)
//    println("lazy 테스트 및 결과값 재할당해서 연산 확인"+ data4+10)
//    println("hello world")
}