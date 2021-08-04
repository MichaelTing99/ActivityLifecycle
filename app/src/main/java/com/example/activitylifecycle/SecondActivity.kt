package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.activitylifecycle.Models.QuestionModel

class SecondActivity : AppCompatActivity() {

    private lateinit var myModel:QuestionModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.i("Lifecycle", "onCreate") //i = information

        val btn : Button = findViewById(R.id.btnAdd)
        val tv : TextView = findViewById(R.id.tvQuestion)
        val tvName : TextView = findViewById(R.id.tvName)

//        if(savedInstanceState != null)
//        tv.text = savedInstanceState?.getString("question")

//        myModel = QuestionModel() // this will create new model

//        myModel = ViewModelProvider(this).get(QuestionModel::class.java)

        myModel = QuestionModel.getInstant()

        tvName.text = myModel.name
        tv.text = myModel.getQuestion()

        btn.setOnClickListener(){
            tv.text = myModel.generateQuestion()
        }

    }

    override fun onStart() {
        super.onStart()

        Log.i("Lifecycle", "onStart") //i = information

    }

    override fun onResume() {

        super.onResume()

        Log.i("Lifecycle", "onResume") //i = information

    }

    override fun onStop() {
        super.onStop()

        Log.i("Lifecycle", "onStop") //i = information, w = warning

    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("Lifecycle", "onDestroy") //i = information

    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//
//        val tv : TextView = findViewById(R.id.tvQuestion)
//
//        outState.putString("question",tv.text.toString())
//
//
//    }

}
