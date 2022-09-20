package com.example.makeorder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
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

        dataModel.userData.observe(activity as LifecycleOwner) {
            if(it.sugar) sugar = "Sugar"
            if(it.milk) milk = "Milk"
            if(it.lemon) lemon = "Lemon"
            text = "Client: ${it.email} \n Password: ${it.password} \n \n Order: ${it.drink} \n " +
                    "${it.drinkType} \n \n Add: \n $sugar \n $milk \n $lemon \n" +
                    "Thank you, for your order! \n Please, drink more and don't stop!"
        }
        textInfo.text = text
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            OrderInfoFragment().apply {
            }
    }
}