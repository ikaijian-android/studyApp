package com.ikaijian.studyapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ikaijian.studyapp.ui.HomeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 绑定某个行为
        val button = findViewById<Button>(R.id.button)
        // 设置点击事件监听器
        button.setOnClickListener {
            goToHome()
        }
    }

    private fun goToHome() {
        Toast.makeText(this,"跳转到首页",Toast.LENGTH_SHORT).show()
        // 显示跳转
//        Intent(this,HomeActivity::class.java).apply {
//            putExtra("postId","12132312")
//            startActivity(this)
//        }
        // 另一种写法
        val intent = Intent(this,HomeActivity::class.java)
        intent.putExtra("postId","12345678")
        startActivity(intent)

        // 隐式跳转，不用activity引用
//        Intent("com.ikaijian.studyapp.home").apply {
//            startActivity(this)
//        }
    }
}