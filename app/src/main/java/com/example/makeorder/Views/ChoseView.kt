package com.example.makeorder.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.makeorder.Models.OrderModel
import com.example.makeorder.Presenters.ChosePresenter
import com.example.makeorder.Repositories.OrderRepository
import com.example.makeorder.StartMVP
import com.example.makeorder.databinding.FragmentChoseBinding

private const val CLIENT_NAME = "email"
private const val CLIENT_PASSWORD = "password"


class ChoseFragment : Fragment(), StartMVP.ChoseView {
    private var email: String? = null
    private var password: String? = null
    private var drink: String = ""
    private var drinkType: String = ""
    private val coffeArray = arrayOf("Americano ","Cappuccino")
    private val teaArray = arrayOf("Green","Black")
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
    private lateinit var presenter: StartMVP.Presenter

    override fun getEmail(): String? {
        return email
    }

    override fun getPassword(): String? {
        return password
    }

    override fun getMilk(): Boolean {
        return binding.checkBoxMilk.isChecked
    }

    override fun getSugar(): Boolean {
        return binding.checkBoxSugar.isChecked
    }

    override fun getDrink(): String? {
        return drink
    }

    override fun getLemon(): Boolean {
        return binding.checkBoxLemon.isChecked
    }

    override fun getDrinkType(): String? {
        return drinkType
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChoseBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("Start onViewCreated")
        presenter = ChosePresenter(OrderModel(OrderRepository()))
        email = arguments?.getString("email")!!
        password = arguments?.getString("password")!!
        println("email $email")
        println("password $password")
        helloTextView = binding.helloText
        helloTextView.text = "Hello, $email!"
        orderButton = binding.buttonOrder
        drinkRadioGroup = binding.radioDrink
        sugarCheckBox = binding.checkBoxSugar
        milkCheckBox = binding.checkBoxMilk
        lemonCheckBox = binding.checkBoxLemon
        spinner = binding.spinner


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
            var fragmentInfo: OrderInfoFragment = OrderInfoFragment.newInstance()
            presenter!!.setView(this)
            presenter!!.setFragment(this, this.id)
            presenter!!.setNextFragment(fragmentInfo)
            presenter!!.positiveButtonClicked()
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            ChoseFragment().apply {
            }
    }


}