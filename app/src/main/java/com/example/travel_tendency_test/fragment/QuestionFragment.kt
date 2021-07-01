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


class QuestionFragment : Fragment(), View.OnClickListener{ // Fragment 상속받았고, view.onclickListener 인터페이스를 구현하려고 하는 것

    lateinit var navController : NavController// 선언하는 당시에는 초기화 안 할거라서 lateinit 붙여줘야 함

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { //뷰가 만들어지고 나고나서 호출되는 함수를 오버라이드
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        btn_next.setOnClickListener(this) // 클래스 파일에서 구현된 onClick 메소드를 쓰겠다.
    }

    override fun onClick(v: View?) { // 버튼이 10개면 이 안에서 다 관리를 해줄 수 있는 것, onViewCreated 에서 setOnClickListener로 일일히 다 하는 게 아니라.
        when(v?.id){
            R.id.btn_next -> {
                navController.navigate(R.id.action_questionFragment_to_selectionFragment)
            }
        }
    }

}