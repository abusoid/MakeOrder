package com.example.makeorder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.makeorder.databinding.FragmentChoseBinding
import com.example.makeorder.databinding.FragmentLoginBinding
import com.rengwuxian.materialedittext.MaterialEditText

private const val CLIENT_NAME = "email"
private const val CLIENT_PASSWORD = "password"


class ChoseFragment : Fragment() {
    private var email: String? = null
    private var password: String? = null
    private var drink: String = ""
    private var drinkType: String = ""
    private val coffeArray = arrayOf("Americano ","Cappuccino")
    private val teaArray = arrayOf("Green","Black")
    private val dataModel : DataModel by activityViewModels()
    lateinit var binding : FragmentChoseBinding
    private lateinit var orderButton: Button
    private lateinit var cancelButton: Button
    private lateinit var helloTextView: TextView
    private lateinit var selectedDrink: RadioButton
    private lateinit var drinkRadioGroup: RadioGroup
    private lateinit var sugarCheckBox: CheckBox
    private lateinit var milkCheckBox: CheckBox
    private lateinit var lemonCheckBox: CheckBox
    private lateinit var spinner: Spinner


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChoseBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("Start onViewCreated")
        dataModel.userData.observe(activity as LifecycleOwner) {
            email = it.email
            password = it.password
        }
        println("email $email")
        println("password $password")
        helloTextView = view.findViewById(R.id.helloText)
        helloTextView.text = "Hello, $email!"
        orderButton = view.findViewById(R.id.buttonOrder)
        drinkRadioGroup = view.findViewById(R.id.radioDrink)
        sugarCheckBox = view.findViewById(R.id.checkBoxSugar)
        milkCheckBox = view.findViewById(R.id.checkBoxMilk)
        lemonCheckBox = view.findViewById(R.id.checkBoxLemon)
        spinner = view.findViewById(R.id.spinner)


        drinkRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            selectedDrink = view.findViewById(drinkRadioGroup.checkedRadioButtonId)
            drink = selectedDrink.text.toString()
            if(drink != "Tea") {
                lemonCheckBox.visibility = View.GONE
                spinner?.adapter = ArrayAdapter(
                    activity?.applicationContext!!,
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, coffeArray)
            } else {
                lemonCheckBox.visibility = View.VISIBLE
                spinner?.adapter = ArrayAdapter(
                    activity?.applicationContext!!,
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, teaArray)
            }
        }
        spinner?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                drinkType = parent?.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        binding.buttonOrder.setOnClickListener {
            var userData = UserData()
            userData.email = email
            userData.password = password
            userData.stage = "info"
            userData.sugar = sugarCheckBox.isChecked
            userData.milk = milkCheckBox.isChecked
            userData.lemon = lemonCheckBox.isChecked
            userData.drink = drink
            userData.drinkType = drinkType
            dataModel.userData.value = userData

        }
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            ChoseFragment().apply {
            }
    }
}