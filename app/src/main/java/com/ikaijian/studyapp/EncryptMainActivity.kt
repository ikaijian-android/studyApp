package com.ikaijian.studyapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.ikaijian.studyapp.ui.fragment.WelcomeFragment

/**
 * 定义接口
 * 为了能向切换的Fragment对象进行通信发送数据，接口方法参数
 */
interface ReplaceFragmentListener {
    fun onReplace(className: String, message: String)
}

// EncryptMainActivity 类中进行ReplaceFragmentListener接口实现
// 即EncryptMainActivity实现了ReplaceFragmentListener接口
class EncryptMainActivity : AppCompatActivity(), ReplaceFragmentListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.encrypt_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.encrypt_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 控制代码中动态关联WelcomeFragment
        // 首先找到EncryptMainActivity布局中的FragmentContainerView
        findViewById<FragmentContainerView>(R.id.encrypt_main).let { fragmentContainerView ->
            // 实例化WelcomeFragment
            val welcomeFragment = WelcomeFragment()
            // 使用上下文的FragmentManager来动态添加WelcomeFragment进行事务操作
            supportFragmentManager
                // 开启事务
                .beginTransaction()
                // 添加WelcomeFragment到FragmentContainerView中
                .add(fragmentContainerView.id, welcomeFragment)
                // 提交事务
                .commit()
        }
    }

    /**
     * 接口实现
     */
    override fun onReplace(className: String,message: String) {
        // 通过类名字符串获取Class对象
        val fragmentClass = Class.forName(className)
        // 实例化
        val fragment = fragmentClass.getConstructor().newInstance() as Fragment

        // 准备数据，使用Bundle保存键值对方式，键为key
        val bundle = Bundle().apply {
            putString("key",message)
        }
        // 将添加的键值对数据保存到要切换的Fragment的arguments属性中
        fragment.arguments = bundle

        // 获取布局中的FragmentContainerView
        findViewById<FragmentContainerView>(R.id.encrypt_main).let { fragmentContainerView ->
            // 使用上下文的FragmentManager来动态添加Fragment进行事务操作
            supportFragmentManager
                // 开启事务
                .beginTransaction()
                // 添加WelcomeFragment到FragmentContainerView中
                .add(fragmentContainerView.id, fragment)
                // 提交事务
                .commit()
        }
    }
}