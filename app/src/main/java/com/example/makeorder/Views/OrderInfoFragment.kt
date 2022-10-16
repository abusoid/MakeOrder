package com.example.makeorder.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.example.makeorder.Models.DataModel
import com.example.makeorder.R
import com.example.makeorder.databinding.FragmentOrderInfoBinding


class OrderInfoFragment : Fragment() {
    private val dataModel : DataModel by activityViewModels()
    lateinit var binding : FragmentOrderInfoBinding
    private lateinit var textInfo: TextView
    private var text: String = ""
    private var sugar: String = ""
    private var milk: String = ""
    private var lemon: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderInfoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textInfo = view.findViewById(R.id.infoText)

        //dataModel.userData.observe(activity as LifecycleOwner) {
            if(arguments?.getBoolean("sugar")!!) sugar = "Sugar"
            if(arguments?.getBoolean("milk")!!) milk = "Milk"
            if(arguments?.getBoolean("lemon")!!) lemon = "Lemon"
            text = "Client: ${arguments?.getString("email")!!} \n Password: " +
                    "${arguments?.getString("password")!!} \n \n Order: ${arguments?.getString("drink")!!} \n " +
                    "${arguments?.getString("drinkType")!!} \n \n Add: \n $sugar \n $milk \n $lemon \n" +
                    "Thank you, for your order! \n Please, drink more and don't stop!"
        //}
        textInfo.text = text
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            OrderInfoFragment().apply {
            }
    }
}