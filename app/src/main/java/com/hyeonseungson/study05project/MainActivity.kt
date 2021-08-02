package com.hyeonseungson.study05project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var car : Car? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hyundaiButton.setOnClickListener {

            Toast.makeText(this, "현대자동차를 구입하였다.", Toast.LENGTH_SHORT).show()
            val crNm = carName.text.toString()
            car = Hyundai(crNm, outputView)
        }
        kiaButton.setOnClickListener {

            Toast.makeText(this,"기아자동차를 구입하였다.", Toast.LENGTH_SHORT).show()
            val crNm = carName.text.toString()
            car = Kia(crNm, outputView)
        }
        checkButton.setOnClickListener {

            if (car is Hyundai) {
                carCheck.setText("자동차 : 현대자동차 / ${(car as Hyundai).name}")
            } else if (car is Kia) {
                carCheck.setText("자동차 : 기아자동차 / ${(car as Kia).name}")
            } else {
                carCheck.setText("선택된 자동차가 없습니다.")
            }
        }
        startButton.setOnClickListener {
            car?.doStart()
        }
        runButton.setOnClickListener {
            car?.doRun()
        }
        turnButton.setOnClickListener {
            car?.doTurn()
        }
        stopButton.setOnClickListener {
            car?.doStop()
        }
    }
}

interface Car {

    val name : String

    fun doStart ()
    fun doRun ()
    fun doTurn ()
    fun doStop ()
}

class Hyundai (override val name : String, val output : TextView) : Car {
    override fun doStart() {
        output?.setText("현대자동차 $name 의 doStart Function 호출")
    }

    override fun doRun() {
        output?.setText("현대자동차 $name 의 doRun Function 호출")
    }

    override fun doTurn() {
        output?.setText("현대자동차 $name 의 doTurn Function 호출")
    }

    override fun doStop() {
        output?.setText("현대자동차 $name 의 doStop Function 호출")
    }
}

class Kia (override val name : String, val output : TextView) : Car {
    override fun doStart() {
        output?.setText("기아자동차 $name 의 doStart Function 호출")
    }

    override fun doRun() {
        output?.setText("기아자동차 $name 의 doRun Function 호출")
    }

    override fun doTurn() {
        output?.setText("기아자동차 $name 의 doTurn Function 호출")
    }

    override fun doStop() {
        output?.setText("기아자동차 $name 의 doStop Function 호출")
    }
}
