package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizapp.constants.getQuestions

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var naya: Int = 0
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<question>? = null
    private var mSelectedOptionInteger: Int = 0
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null
    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var mUserName: String? = null
    private var btnSubmit: Button? = null
    private var mCorrectAnswers: Int = 0
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        mUserName = intent.getStringExtra(constants.USER_NAME)
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_submit)
        mQuestionsList = constants.getQuestions()
        setQuestion()
        defaultOptionView()
    }

    private fun setQuestion() {
        defaultOptionView()
        val Question: question = mQuestionsList!![mCurrentPosition - 1]
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = Question.questions
        ivImage?.setImageResource(Question.image)
        tvOptionOne?.text = Question.OptionOne
        tvOptionTwo?.text = Question.OptionTwo
        tvOptionThree?.text = Question.OptionThree
        tvOptionFour?.text = Question.OptionFour
        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
        if (mCurrentPosition == mQuestionsList!!.size) {
            btnSubmit?.text = "FINISH"
        } else {
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionView() {
        val options = arrayListOf(tvOptionOne, tvOptionTwo, tvOptionThree, tvOptionFour)
        for (option in options) {
            option?.apply {
                setTextColor(Color.parseColor("#7A8089"))
                typeface = Typeface.DEFAULT
                background = ContextCompat.getDrawable(this@QuizQuestionActivity, R.drawable.default_option_border_bg)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_option_one -> selectedOptionView(tvOptionOne!!, 1)
            R.id.tv_option_two -> selectedOptionView(tvOptionTwo!!, 2)
            R.id.tv_option_three -> selectedOptionView(tvOptionThree!!, 3)
            R.id.tv_option_four -> selectedOptionView(tvOptionFour!!, 4)
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> setQuestion()
                        else -> {
                            val intent2 = Intent(this, resultactivity::class.java)
                            intent2.putExtra(constants.USER_NAME, mUserName)
                            intent2.putExtra(constants.CORRECT_ANSWER, mCorrectAnswers)
                            intent2.putExtra(constants.TOTAL_QUESTION, mQuestionsList?.size)
                            intent2.putExtra("nayaInt", naya)
                            startActivity(intent2)
                            finish()
                        }
                    }
                } else {
                    val Question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (Question!!.correctAnswer == mSelectedOptionPosition) {
                        mCorrectAnswers++
                    } else {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    answerView(Question.correctAnswer, R.drawable.correct_option_border_bg)
                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btnSubmit?.text = "FINISH"
                    } else {
                        btnSubmit?.text = "Go_To_Next_Question"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        val options = arrayListOf(tvOptionOne, tvOptionTwo, tvOptionThree, tvOptionFour)
        options[answer - 1]?.background = ContextCompat.getDrawable(this, drawableView)
    }
}
