package com.example.travel_tendency_test.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.travel_tendency_test.R
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    lateinit var navController : NavController// 선언하는 당시에는 초기화 안 할거라서 lateinit 붙여줘야 함

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { //뷰가 만들어지고 나고나서 호출되는 함수를 오버라이드
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btn_next.setOnClickListener{ //버튼 클릭 시 어떤 일이 일어나는가?
            navController.navigate(R.id.action_mainFragment_to_questionFragment)
        }
    }

}