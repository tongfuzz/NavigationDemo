package com.kk.tongfu.navigationdemo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_info.*

/**
 * A simple [Fragment] subclass.
 */
class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_infoFragment_pop)
        }

        requireActivity().onBackPressedDispatcher.addCallback {
            findNavController().navigate(R.id.action_infoFragment_pop)
        }

    }


}
