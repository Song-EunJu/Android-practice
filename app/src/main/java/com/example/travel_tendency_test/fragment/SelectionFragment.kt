package com.example.travel_tendency_test.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.travel_tendency_test.R
import kotlinx.android.synthetic.main.fragment_selection.*

class SelectionFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btn_back.setOnClickListener(this)
        option_1.setOnClickListener(this)
        option_2.setOnClickListener(this)
        option_3.setOnClickListener(this)
        option_4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) { // ? 를 쓰면 view 가 null이 아니면 id를 가져온다.
            R.id.option_1 -> {
                navigateWithIndex(1)
            }
            R.id.option_2 -> {
                navigateWithIndex(2)
            }
            R.id.option_3 -> {
                navigateWithIndex(3)
            }
            R.id.option_4 -> {
                navigateWithIndex(4)
            }

            R.id.btn_back -> {
                navController.popBackStack()
                //fragment는 이동할 때 stack에 쌓임, a->b->c 순서대로 이동했으면 stack에 a가 밑바닥부터 쌓임
                // 뒤로가기를 누르면 stack에 있는 거를 하나 pop해주면 됨
            }
        }
    }

    fun navigateWithIndex(index: Int) {  // fragment를 데이터로 보내기 위해서는 bundle 로 싸서 보내줌
        val bundle = bundleOf("index" to index) // 위의 파라미터로 오는 index를 index라는 키에 넣어준다
        navController.navigate(R.id.action_selectionFragment_to_resultFragment, bundle)
    }

}