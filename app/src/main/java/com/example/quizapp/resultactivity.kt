package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.widget.Button
import android.widget.TextView

class resultactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultactivity)

        val tvName:TextView=findViewById(R.id.textView4)
        val tvScore:TextView=findViewById(R.id.textView3)
        val lastBUtton:Button=findViewById(R.id.lastbtn)

        tvName.text=intent.getStringExtra(constants.USER_NAME)
        val totalQuestions = intent.getIntExtra(constants.TOTAL_QUESTION,0)
       var correctAnswer=intent.getIntExtra(constants.CORRECT_ANSWER,0)
       // var correctAnswer=intent.getIntExtra("nayaInt",10)

        tvScore.text="Your score is ${correctAnswer} out of $totalQuestions"
        lastBUtton.setOnClickListener{
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}