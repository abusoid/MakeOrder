package com.example.makeorder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.makeorder.databinding.FragmentLoginBinding
import com.rengwuxian.materialedittext.MaterialEditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class LoginFragment : Fragment() {
    private var param1: String? = null
    private val dataModel : DataModel by activityViewModels()
    lateinit var binding : FragmentLoginBinding
    private lateinit var buttonLogIn: Button
    private lateinit var buttonCancel: Button
    private lateinit var emailField: MaterialEditText
    private lateinit var passwordField: MaterialEditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonLogIn = view.findViewById(R.id.buttonLogIn)
        buttonCancel = view.findViewById(R.id.buttonCancel)
        binding.buttonLogIn.setOnClickListener {
            emailField = view.findViewById(R.id.emailField)
            passwordField = view.findViewById(R.id.passwordField)
            var userData = UserData()
            println("emailField " + emailField.text.toString())
            println("passwordField " + passwordField.text.toString())
            userData.email = emailField.text.toString()
            println("userData.email " + userData.email)
            userData.password = passwordField.text.toString()
            userData.stage = "chose"
            println("userData.password " + userData.password)
            dataModel.userData.value = userData
        }
        binding.buttonCancel.setOnClickListener {

        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}