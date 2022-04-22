package jishnu.tutorials.kotlinbasics

fun main(){
    //dataType Exercise

    var androidString : String = "Android Masterclass"
    var floatTask : Float = 13.35F
    var doubleTask : Double = 3.14159265358979
    var shortTask : Byte = 25
    var intTask : Short = 2020
    var longTask : Long = 18881234567
    var booleanTask : Boolean = true
    var charTask : Char = 'a'


    print("$androidString $floatTask $doubleTask $shortTask $intTask $longTask $booleanTask $charTask")

    //loop Exercise:

    for(i in 0..10000){
            if(i == 9001){
                print("\n\nIt's over 9000\n\n")
            }
    }

    var humidity : String = "Humid"

    var humidityLevel : Int = 80

    while(humidity == "Humid"){
        humidityLevel -= 5
        print("Humidity Decreased \n")
        if(humidityLevel == 60){
            humidity = "Comfy"
            print("It's $humidity Now\n")
        }
    }

    helloKotlin()

    print("\n")

    print(summer(1,2))

    print("\n")

    print(averageOfTheTwo(1F,2F))

}
fun averageOfTheTwo(a : Float , b : Float) : Float{
    return (a+b)/2
}

fun summer(a : Int , b: Int) : Int {
    return a+b;
}

fun helloKotlin(){
    print("Started Kotlin")

}

