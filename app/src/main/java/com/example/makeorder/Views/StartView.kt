package com.example.makeorder.Views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.makeorder.*
import com.example.makeorder.Models.StartModel
import com.example.makeorder.Presenters.StartPresenter
import com.example.makeorder.Repositories.UserRepository
import com.example.makeorder.databinding.ActivityMainBinding


class StartView : AppCompatActivity(), StartMVP.StartView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentLogin: LoginView
    private lateinit var choseFragment: ChoseFragment
    private val dataModel: DataModel by viewModels()
    private lateinit var root: ConstraintLayout
    private lateinit var presenter: StartPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("start onCreate Start Activity")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println(binding)
        presenter = StartPresenter(StartModel(UserRepository()))
        //this.setPresenter(presenter)
        presenter.setView(this)
        var support = supportFragmentManager
        presenter.setSupportFragmentManager(support)
        var fragmentLogin: LoginView = LoginView.newInstance()
        presenter.setFragment(fragmentLogin, binding.fragmentLogin.id)


        //presenter.setNextFragment(choseFragment, binding.fragmentChose.id)
        //Зарегистрироваться
        binding.buttonSignUp.setOnClickListener() {
            println("Start Registration")
        }
        //Войти
        binding.buttonLogIn.setOnClickListener {
            println("Start LogIn")
            presenter!!.loginButtonClicked()
        }
    }


}


