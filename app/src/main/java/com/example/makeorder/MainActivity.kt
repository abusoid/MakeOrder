package com.example.makeorder

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.makeorder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var buttonLogIn: Button
    private lateinit var buttonSignUp: Button
    private lateinit var fragmentLogin: LoginFragment
    private lateinit var choseFragment: ChoseFragment
    private val dataModel: DataModel by viewModels()
    //private lateinit var auth: FirebaseAuth
    //private lateinit var db: FirebaseDatabase
    //private lateinit var users: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonLogIn = findViewById(R.id.buttonLogIn)
        buttonSignUp = findViewById(R.id.buttonSignUp)
        var email: String? = ""
        var password: String? = ""
        var drink: String? = ""
        var drinkType: String? = ""
        var stage: String? = ""
        var sugar: Boolean = false
        var milk: Boolean = false
        var lemon: Boolean = false
        //auth = FirebaseAuth.getInstance()
       // db = FirebaseDatabase.getInstance()
        //users = db.getReference("Users")
        //val transaction = supportFragmentManager.beginTransaction()
        val loginFragment = LoginFragment.newInstance()
        val choseFragment = ChoseFragment.newInstance()
        val infoFragment = OrderInfoFragment.newInstance()
        dataModel.userData.observe(this) {
            println("Start observe")
            email = it.email
            println("email: $email")
            password = it.password
            println("password: $password")
            drink = it.drink
            println("drink: $drink")
            sugar = it.sugar
            println("sugar: $sugar")
            milk = it.milk
            println("milk: $milk")
            lemon = it.lemon
            println("lemon: $lemon")
            stage = it.stage
            println("stage: $stage")
            drinkType = it.drinkType
            println("drinkType: $drinkType")
            if (savedInstanceState == null) {
                when(stage) {
                    "chose" -> {
                        println("Скрываем фрагмент с логином")
                        hideFragment(loginFragment)
                        println("Открываем фрагмент с выбором опций по заказу")
                        openFragment(choseFragment, R.id.fragmentChose)
                    }
                    "info" -> {
                        println("Скрываем фрагмент с выбором опций")
                        hideFragment(choseFragment)
                        println("Открываем фрагмент с информацией по заказу")
                        openFragment(infoFragment, R.id.fragmentOrderInfo)
                    }
                }
            }
        }
        //Зарегистрироваться
        buttonSignUp.setOnClickListener() {
            println("Start Registration")
        }
        //Войти
        buttonLogIn.setOnClickListener {
            if(savedInstanceState == null){

                openFragment(loginFragment, R.id.fragmentLogin)
                //openFragment(ChoseFragment.newInstance("Денис"), R.id.fragmentChose)
            }

        }
    }

    private fun openFragment(f:Fragment, idHolder:Int){
        supportFragmentManager.beginTransaction()
        .replace(idHolder, f)
        .commit()
    }
    private fun hideFragment(f:Fragment){
        supportFragmentManager.beginTransaction()
            .hide(f)
            .commit()
    }
    private fun showRegisterWindow() {
        println("Start showRegisterWindow")

            /* var dialog = AlertDialog.Builder(this)
        println(dialog)
        dialog.setTitle("Registration")
        dialog.setMessage("Input register data")

        var inflater = LayoutInflater.from(this)
        println(inflater)
        var registerWindow = inflater.inflate(R.layout.register_window, null)
        println(registerWindow)
        dialog.setView(registerWindow)

        var email = registerWindow.findViewById<MaterialEditText>(R.id.emailField)
        var pass = registerWindow.findViewById<MaterialEditText>(R.id.passwordField)
        var name = registerWindow.findViewById<MaterialEditText>(R.id.nameField)
        var phone = registerWindow.findViewById<MaterialEditText>(R.id.phoneField)

        dialog.setNegativeButton("Cancel", DismissClickListener)
        val OkCliclListener = DialogInterface()
        dialog.setPositiveButton(
            "Ok",
            new DialogInterface.OnClickListener() {
                fun onClick(dialogInterface: DialogInterface, which: Int) {
                    if (TextUtils.isEmpty(email.text.toString()))
                }
            }
        )*/
    }
    /*
    object DismissClickListener : DialogInterface.OnClickListener {
        override fun onClick(dialogInterface: DialogInterface, which: Int) {
            dialogInterface.dismiss()
        }
    }
    */


}


