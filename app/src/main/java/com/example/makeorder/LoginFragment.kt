package com.example.makeorder

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.makeorder.databinding.FragmentLoginBinding
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
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
    private lateinit var auth: FirebaseAuth
    private lateinit var root: FrameLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var root: FrameLayout = binding.rootLogin
        buttonLogIn = binding.buttonLogIn//view.findViewById(R.id.buttonLogIn)
        buttonCancel = binding.buttonCancel//view.findViewById(R.id.buttonCancel)
        binding.buttonLogIn.setOnClickListener {
            emailField = binding.emailField//view.findViewById(R.id.emailField)
            passwordField = binding.passwordField//view.findViewById(R.id.passwordField)
            if(TextUtils.isEmpty(emailField.text.toString())){
                Snackbar.make(root, "Enter your email", Snackbar.LENGTH_SHORT).show()
            } else if(passwordField.text.toString().length < 5){
                Snackbar.make(root, "Enter your password, more 5 symbols", Snackbar.LENGTH_SHORT).show()
            } else {
                //Аутентификация
                auth = FirebaseAuth.getInstance()
                auth.signInWithEmailAndPassword(
                    emailField.text.toString(),
                    passwordField.text.toString()
                )
                    .addOnSuccessListener(object: OnSuccessListener<AuthResult> {
                        override fun onSuccess(p0: AuthResult?) {
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
                    })
                    .addOnFailureListener(object: OnFailureListener {
                        override fun onFailure(e: Exception) {
                            Snackbar.make(root, "Error login: ${e.message}", Snackbar.LENGTH_SHORT).show()
                        }
                    })

            }
        }
        binding.buttonCancel.setOnClickListener {

        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}