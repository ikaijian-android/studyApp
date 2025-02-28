package com.ikaijian.studyapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.ikaijian.studyapp.R

/**
 *
 */
class MessageFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    // 在MessageFragment中接收数据，并处理

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 动态切换传过来的参数，获取arguments中的键值对的数据 键名称：key
        val msg = arguments?.getString("key")
        // 显示到EditText中
        view.findViewById<EditText>(R.id.message).setText(msg)
    }
}