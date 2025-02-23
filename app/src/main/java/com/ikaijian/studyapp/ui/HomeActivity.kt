package com.ikaijian.studyapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ikaijian.studyapp.R

class HomeActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 接受activity参数
        val postId = intent.getStringExtra("postId")
        val messageTextView = findViewById<TextView>(R.id.message)
        messageTextView.text = "接受文章ID: $postId"

        // 返回按钮
        val homeButton = findViewById<Button>(R.id.home_button)
        homeButton.setOnClickListener {
            finish()
        }
    }
}