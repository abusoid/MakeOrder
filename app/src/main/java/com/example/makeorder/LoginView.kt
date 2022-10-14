package com.example.makeorder

import android.R
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewModelScope
import com.example.makeorder.Models.StartModel
import com.example.makeorder.Presenters.LoginPresenter
import com.example.makeorder.Repositories.UserRepository
import com.example.makeorder.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.rengwuxian.materialedittext.MaterialEditText


class LoginView : Fragment(), StartMVP.LoginView {
    private val dataModel : DataModel by activityViewModels()
    lateinit var binding : FragmentLoginBinding
    private lateinit var buttonLogIn: Button
    private lateinit var buttonCancel: Button
    private lateinit var emailField: MaterialEditText
    private lateinit var passwordField: MaterialEditText
    private lateinit var auth: FirebaseAuth
    private lateinit var presenter: LoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }



    override fun getEmail(): String {
        return binding.emailField.toString()
    }

    override fun getPassword(): String {
        return binding.passwordField.toString()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var root: FrameLayout = binding.rootLogin
        buttonLogIn = binding.buttonLogIn
        buttonCancel = binding.buttonCancel
        presenter = LoginPresenter(StartModel(UserRepository()))
        binding.buttonLogIn.setOnClickListener {
            emailField = binding.emailField
            passwordField = binding.passwordField
            if(TextUtils.isEmpty(emailField.text.toString())){
                Snackbar.make(root, "Enter your email", Snackbar.LENGTH_SHORT).show()
            } else if(passwordField.text.toString().length < 5){
                Snackbar.make(root, "Enter your password, more 5 symbols", Snackbar.LENGTH_SHORT).show()
            } else {
                var fragmentChose: ChoseFragment = ChoseFragment.newInstance()
                var support = parentFragmentManager

                presenter!!.setSupportFragmentManager(support)
                presenter!!.setFragment(this, this.id)
                presenter!!.setNextFragment(fragmentChose, activity!!.findViewById(R.id.c))
                presenter!!.setView(this)
                presenter!!.loginButtonClicked()
            }
        }
        binding.buttonCancel.setOnClickListener {

        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = LoginView()
    }

    override fun setPassword(password: String?) {
        TODO("Not yet implemented")
    }

    override fun setLogin(login: String?) {
        TODO("Not yet implemented")
    }
}