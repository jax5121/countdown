package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.round
import kotlin.random.Random

class NumbersRound : AppCompatActivity() {

    val bigNumbers = intArrayOf(25,50,75,100)
    val smallNumbers = intArrayOf(1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10)
    val n = 6
    var nBig = 1


    lateinit var number1:TextView
    lateinit var number2:TextView
    lateinit var number3:TextView
    lateinit var number4:TextView
    lateinit var number5:TextView
    lateinit var number6:TextView
    lateinit var numbers:Array<TextView>
    lateinit var nBigNumbers:TextView
    lateinit var target: TextView
    lateinit var txtTimer: TextView

    lateinit var btnPick: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers_round)

        // get number boxes
        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        number3 = findViewById(R.id.number3)
        number4 = findViewById(R.id.number4)
        number5 = findViewById(R.id.number5)
        number6 = findViewById(R.id.number6)
        nBigNumbers = findViewById(R.id.nBig)
        numbers = arrayOf(number1, number2, number3, number4, number5, number6)
        target = findViewById(R.id.txtTarget)
        txtTimer = findViewById(R.id.txtTimer)

        // set text
        number1.text = ""
        number2.text = ""
        number3.text = ""
        number4.text = ""
        number5.text = ""
        number6.text = ""
        nBigNumbers.text = nBig.toString()
        target.text = ""
        txtTimer.text = ""

        btnPick = findViewById(R.id.btnPickNumbers)
    }

    public fun increase(view:View) {
        if(nBig < 4) nBig++
        nBigNumbers.text = nBig.toString()
    }

    public fun decrease(view:View) {
        if(nBig > 1) nBig--
        nBigNumbers.text = nBig.toString()
    }

    public fun pickNumbers(view:View) {
        var nb = nBig
        var selected = List(nb) { Random.nextInt(0,3) } + List(n - nb) { Random.nextInt(0,19) }

        var i = 0
        for(number in numbers) {
            if(nb == 0) {
                number.text = smallNumbers[selected[i]].toString()
            } else {
                number.text = bigNumbers[selected[i]].toString()
                nb--
            }
            i++
        }

        target.text = Random.nextInt(100, 999).toString()
        txtTimer.text = "30"
        Timer()
    }

    fun Timer() {
        btnPick.isEnabled = false
        var v:Double
        val timer = object: CountDownTimer(30000,1000) {
            override fun onTick(p0: Long) {
                txtTimer.text = (p0/1000+1).toString()
            }

            override fun onFinish() {
                txtTimer.text = "0"
                btnPick.isEnabled = true
            }
        }
        timer.start()
    }
}