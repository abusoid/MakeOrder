package com.example.makeorder

import android.app.Activity
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.makeorder.Views.StartView

interface StartMVP {
    interface StartView {
        /*fun getEmail(): String
        fun getPassword(): String
        fun setPassword(password: String?)
        fun setLogin(login: String?)*/
    }
    interface LoginView {
        fun getEmail(): String
        fun getPassword(): String
        fun setPassword(password: String?)
        fun setLogin(login: String?)
    }
    interface Presenter {
        fun setView(view: StartView)

        fun setView(view: LoginView)
        fun setFragment(fragment: Fragment, idHolder:Int)
        fun setNextFragment(fragment:Fragment, idHolder: Int)
        fun changeFragment(fragmentHide:Fragment, fragmentShow:Fragment, idHolder:Int)
        fun openFragment(f:Fragment, idHolder:Int)
        fun hideFragment(f:Fragment)
        fun loginButtonClicked()
        fun registrationButtonClicked()
        fun getCurrentUser(): UserData
        fun setSupportFragmentManager(support: FragmentManager)
    }
    interface UserModel {
        fun saveUser(email: String?, password: String)
        fun saveUser(email: String?, password: String, phone: String?,
                     name: String?)
        fun getUser(): UserData
    }
    interface OrderModel {
        fun saveOrder(email: String?, name: String?, drink: String?,
                     sugar: Boolean = false, milk: Boolean = false,
                     lemon: Boolean = false, stage: String?, drinkType: String?)
        fun getOrder(): UserData?
    }
}