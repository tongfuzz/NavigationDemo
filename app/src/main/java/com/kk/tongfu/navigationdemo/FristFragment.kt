package com.kk.tongfu.navigationdemo

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kk.tongfu.navigationdemo.beans.UserInfo
import kotlinx.android.synthetic.main.fragment_frist.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FristFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FristFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FristFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private var listener: OnFragmentInteractionListener? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn1.setOnClickListener { toSecondFragment() }
        btn2.setOnClickListener { toThridFragment() }
        btn3.setOnClickListener { toFourthFragment() }
        tvInfo.text=arguments?.getString("params")
    }

    private fun toFourthFragment() {
        //安全参数，跳转页面可以通过这种方式确定参数传递正确，且类型正确，对于有defaultValue的参数，可以不传
        //没有defaultValue的参数必须传递，否则报错

        //使用这种安全参数，需要在项目的build.gradle和app的Gradle文件中添加相应关联
        //参数可以使用可序列化对象，但是需要在声明为不混淆的文件，即添加@Keep在文件类上，或者在proguard-rules.pro中设置-keepnames
        val actionFristFragmentToFourthFragment =
            FristFragmentDirections.actionFristFragmentToFourthFragment(10,"tongfu",UserInfo("tongfusun",20))
        findNavController().navigate(actionFristFragmentToFourthFragment)
        //findNavController().navigate(R.id.action_fristFragment_to_fourthFragment)
    }

    fun toSecondFragment(){
        findNavController().navigate(R.id.action_fristFragment_to_secondFragment)
    }

    fun toThridFragment(){

        findNavController().navigate(R.id.action_fristFragment_to_thridFragment,Bundle().also {
            it.putString("info","from first fragment")
        })
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            FristFragment()
    }
}
