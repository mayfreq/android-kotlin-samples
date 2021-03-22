package com.example.rolldice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener  {
    private lateinit var btnRole: Button
    private lateinit var imgView1: ImageView
    private lateinit var imgView2: ImageView
    private lateinit var spinner: Spinner
    private lateinit var layout: ConstraintLayout
    private var state:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(
                this,
                R.array.select,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }


        val spinner: Spinner = findViewById(R.id.spinner)
        spinner.onItemSelectedListener = this

        imgView1 = findViewById(R.id.imgView1)
        imgView1.setImageResource(R.drawable.dice1)

        imgView2 = findViewById(R.id.imgView2)

        layout = findViewById(R.id.layout)
        btnRole = findViewById(R.id.btnRoll)

        btnRole.setOnClickListener{
            rollDice()
        }
    }

    private fun rollDice() = GlobalScope.launch {
        runOnUiThread {
            btnRole.isEnabled = false
            spinner.isEnabled = false
        }
        val randomNumber = (1..6).random()
        val randomNumber2 = (1..6).random()
        for (i in 1..4) {
            for (j in 1..6) {
                delay((90L * i))
                val resource = getResource(j)
                if(imgView2.visibility== View.VISIBLE){
                    runOnUiThread {
                        imgView1.setImageResource(resource)
                        imgView2.setImageResource(resource)
                    }
                }
                else{
                    runOnUiThread {
                        imgView1.setImageResource(resource)
                    }
                }
            }
        }

        if(imgView2.visibility== View.VISIBLE){
            runOnUiThread {
                var resource = getResource(randomNumber)
                imgView1.setImageResource(resource)
                resource = getResource(randomNumber2)
                imgView2.setImageResource(resource)
            }
        }
        else{
            runOnUiThread {
                val resource = getResource(randomNumber)
                imgView1.setImageResource(resource)
            }
        }

        runOnUiThread {
            btnRole.isEnabled = true
            spinner.isEnabled = true
        }
    }

    private fun getResource(diceNumber: Int): Int{
        return when (diceNumber) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        if(spinner.selectedItem.toString() == "1"){
            if(state){
                imgView2.visibility = View.INVISIBLE
                setLayout(1)
            }
            else state=true
        }
        else{
            imgView2.visibility = View.VISIBLE
            setLayout(2)
        }
    }

    private fun setLayout(layoutState: Int){
        val set = ConstraintSet()
        set.clone(layout)
        set.clear(R.id.imgView1, ConstraintSet.RIGHT)

        if(layoutState == 1){
            set.connect(R.id.imgView1, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT)
        }
        else{
            set.connect(R.id.imgView1, ConstraintSet.RIGHT, imgView2.id, ConstraintSet.LEFT)
        }

        set.applyTo(layout)
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        println("onNothingSelected")
    }
}