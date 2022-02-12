package com.example.diceroller

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    //안드로이드는 ㅊ음 호출에 onCreate()호출함. 기본적으로 kotlin은 main()이 필요한 것과 차이가 있ㅇ므.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener{
            rollDice()
        }

        rollDice()

    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        //crate new Dice object with 6 sides and roll the dice
        val dice1 = Dice(6)
        val dice2 = Dice(6)
        val diceRoll1 = dice1.roll()
        val diceRoll2 = dice2.roll()
        val diceImage1: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        diceImage1.setImageResource(getDrawableResource(diceRoll1))
        diceImage2.setImageResource(getDrawableResource(diceRoll2))

    }

    private fun getDrawableResource(diceRoll: Int): Int{
        return when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}

class Dice(val numSides: Int){

    fun roll(): Int{
        return (1..numSides).random()
    }

}