package com.example.makeorder.Presenters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.makeorder.*
import com.example.makeorder.Data.UserData

class LoginPresenter(private val model: StartMVP.UserModel):StartMVP.Presenter {
    private lateinit var view: StartMVP.LoginView
    private lateinit var support: FragmentManager
    private lateinit var fragment:Fragment
    private lateinit var nextFragment:Fragment
    private var idHolder:Int = 0

    override fun setSupportFragmentManager(support: FragmentManager) {
        this.support = support
    }

    override fun setView(view: StartMVP.StartView) {
        TODO("Not yet implemented")
    }

    override fun setView(view: StartMVP.LoginView) {
        this.view = view
    }

    override fun setView(view: StartMVP.ChoseView) {
        TODO("Not yet implemented")
    }

    override fun setFragment(fragment:Fragment, idHolder: Int) {
        this.fragment = fragment
        this.idHolder = idHolder
        println("setFragment fragment: $fragment")
        println("setFragment idHolder: $idHolder")
    }
    override fun setNextFragment(fragment:Fragment) {
        this.nextFragment=fragment
        println("setNextFragment nextFragment: $fragment")
    }
    override fun positiveButtonClicked() {
        println("LoginPresenter loginButtonClicked")
        println(view)

        if (view != null) {
            model.saveUser(view!!.getEmail(),view!!.getPassword())

            var bundle = Bundle()
            bundle.putString("email", view!!.getEmail())
            bundle.putSerializable("password", view!!.getPassword())
            nextFragment.arguments = bundle
                println("Start Presenter")
            changeFragment(fragment, nextFragment)
        }
    }
    override fun registrationButtonClicked() {
        if (view != null) {
            //model.saveUser(view!!.getLogin(),view!!.getPassword(), view!!.getPhone(), view!!.getName())
        }
    }

    override fun getCurrentUser(): UserData {
        return model.getUser()
    }

    override fun changeFragment(fragmentHide:Fragment, fragmentShow:Fragment){
        hideFragment(fragmentHide)
        //openFragment(fragmentShow, R.id.fragmentLogin)
        fragment.parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentLogin, nextFragment)
            .commit()
    }
    override fun openFragment(f:Fragment, idHolder:Int){
        f.parentFragmentManager.beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
    override fun hideFragment(f:Fragment){
        f.parentFragmentManager.beginTransaction()
            .hide(f)
            .commit()
    }
}


