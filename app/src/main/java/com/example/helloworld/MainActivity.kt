package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        abstract class Animal {
            abstract var name: String
            abstract var age: Int
            abstract fun talk(): String
        }

        class Dog(override var age: Int, override var name: String) : Animal() {
            override fun talk(): String {
                return "Woof"
            }
        }

        class Cat(override var age: Int,override var name: String) : Animal() {
            override fun talk(): String {
                return "Meow"
            }

        }

        val dogsAge = arrayListOf<Dog>()
        val catsAge = arrayListOf<Cat>()
        val catNames = arrayOf("Lili","Meep","Patchy","Furball","Furball")
        val dogNames = arrayOf("Toto","Ruby","Guly","Bob","Tim")

        for (i in 0..4) {
            dogsAge.add(Dog(Random.nextInt(3, 11),dogNames[i]))
            catsAge.add(Cat(Random.nextInt(3, 11),catNames[i]))
        }


        for (myCat in catsAge) {
            println("${myCat.name}: ${myCat.talk()}")
            for (theDog in dogsAge){
                if (myCat.age < theDog.age){
                    Log.d("MainActivity","${theDog.name}: ${theDog.talk()}")
                    theDog.talk()
                }
            }
            Log.d("MainActivity" , "-------------------------------")
        }

    }
}