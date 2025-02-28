package com.ikaijian.studyapp.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.ikaijian.studyapp.R
import com.ikaijian.studyapp.ReplaceFragmentListener

/**
 *
 */
class WelcomeFragment : Fragment() {
    // 定义一个延迟初始化的属性成员，继承自Fragment，实现ReplaceFragmentListener接口
    lateinit var replaceFragmentListener: ReplaceFragmentListener

    // 此生命周期回调方法，在Fragment被关联到Activity时调用，用于获取ReplaceFragmentListener接口实例
    // 此时获取Activity的实例最恰当，并赋值给replaceFragmentListener成员变量
    override fun onAttach(context: Context) {
        super.onAttach(context)
        replaceFragmentListener = context as ReplaceFragmentListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.start)
        button.setOnClickListener {
            replaceFragmentListener.onReplace("com.ikaijian.studyapp.ui.fragment.MessageFragment","Hello world")
        }
    }
}