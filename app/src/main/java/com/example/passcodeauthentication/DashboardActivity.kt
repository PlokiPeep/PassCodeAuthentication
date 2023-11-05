package com.example.passcodeauthentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {
    private lateinit var showAnswerButton: Button
    private lateinit var answerTextView: TextView

    private var isAnswerVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        showAnswerButton = findViewById(R.id.showAnswerButton)
        answerTextView = findViewById(R.id.answerTextView)

        showAnswerButton.setOnClickListener {
            if (isAnswerVisible) {
                // Answer is currently visible, hide it and change the button text
                answerTextView.visibility = View.GONE
                showAnswerButton.text = getString(R.string.show_answer_button_text)
                isAnswerVisible = false
            } else {
                // Answer is currently hidden, show it and change the button text
                answerTextView.visibility = View.VISIBLE
                showAnswerButton.text = getString(R.string.return_to_question_button_text)
                isAnswerVisible = true
            }
        }
    }

    protected override fun onRestart() {
        super.onRestart()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}