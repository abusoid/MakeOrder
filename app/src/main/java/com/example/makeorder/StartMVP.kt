package com.example.makeorder

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.makeorder.Data.OrderData
import com.example.makeorder.Data.UserData

interface StartMVP {
    interface StartView {
    }
    interface LoginView {
        fun getEmail(): String
        fun getPassword(): String
        fun setPassword(password: String?)
        fun setLogin(login: String?)
    }
    interface ChoseView {
        fun getEmail(): String?
        fun getPassword(): String?
        fun getMilk(): Boolean
        fun getSugar(): Boolean
        fun getDrink(): String?
        fun getLemon(): Boolean
        fun getDrinkType(): String?
    }
    interface Presenter {
        fun setView(view: StartView)

        fun setView(view: LoginView)
        fun setView(view: ChoseView)
        fun setFragment(fragment: Fragment, idHolder:Int)
        fun setNextFragment(fragment:Fragment)
        fun changeFragment(fragmentHide:Fragment, fragmentShow:Fragment)
        fun openFragment(f:Fragment, idHolder:Int)
        fun hideFragment(f:Fragment)
        fun positiveButtonClicked()
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
        fun saveOrder(order: OrderData?)
        fun getOrder(): OrderData?
    }
}