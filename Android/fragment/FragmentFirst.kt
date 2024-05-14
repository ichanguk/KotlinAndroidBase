package com.example.androidpractice

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpractice.databinding.FirstFragmentBinding

class FragmentFirst : Fragment() {
    lateinit var _binding:FirstFragmentBinding
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflater : XML을 화면에 사용할 준비를 한다 (XML -> View로 만들어 준다)
        // container : fragment에서 사용될 XML의 부모뷰
        // attachToRoot : root view에 붙일지 말지 (false면 바로 붙음)
        // return inflater.inflate(R.layout.first_fragment, container, false)
        _binding = FirstFragmentBinding.inflate(inflater, container, false)

        binding.callActivity.setOnClickListener {
            (activity as FragmentActivity).printTestLog()
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data:String? = arguments?.getString("key")
        Log.d("testt", "data is " + data)
    }

    fun printTestLog() {
        Log.d("testt", "print test log from fragment")
    }
}