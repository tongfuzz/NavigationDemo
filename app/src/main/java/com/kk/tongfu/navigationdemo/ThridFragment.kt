package com.kk.tongfu.navigationdemo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_thrid.*

/**
 * A simple [Fragment] subclass.
 */
class ThridFragment : Fragment() {

    var param1:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.apply {
            param1=this?.getString("info")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thrid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvInfo.text=param1
        btn1.setOnClickListener {
            navigationUp()
        }

        btn2.setOnClickListener {
            navigationToFirst();
        }
    }

    private fun navigationToFirst() {
        findNavController().navigate(R.id.action_thridFragment_to_firstFragment)
    }

    private fun navigationUp() {
        //相当于点击了返回按键
        findNavController().navigateUp()
    }


}
