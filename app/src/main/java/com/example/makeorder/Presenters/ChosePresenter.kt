package com.example.makeorder.Presenters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.makeorder.*
import com.example.makeorder.Data.OrderData
import com.example.makeorder.Data.UserData
import com.example.makeorder.databinding.FragmentChoseBinding

private const val CLIENT_NAME = "email"
private const val CLIENT_PASSWORD = "password"


class ChosePresenter(private val model: StartMVP.OrderModel): StartMVP.Presenter {
    private var view: StartMVP.ChoseView? = null
    //private val dataModel : DataModel by activityViewModels()
    lateinit var binding : FragmentChoseBinding

    private lateinit var fragment:Fragment
    private lateinit var nextFragment:Fragment


    override fun setView(view: StartMVP.StartView) {

    }

    override fun setView(view: StartMVP.LoginView) {
        TODO("Not yet implemented")
    }

    override fun setView(view: StartMVP.ChoseView) {
        this.view = view
    }

    override fun setFragment(fragment: Fragment, idHolder: Int) {
        this.fragment = fragment
    }

    override fun setNextFragment(fragment: Fragment) {
        this.nextFragment = fragment
    }

    override fun changeFragment(fragmentHide: Fragment, fragmentShow: Fragment) {
        hideFragment(fragmentHide)
        fragment.parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentLogin, nextFragment)
            .commit()
    }

    override fun openFragment(f: Fragment, idHolder: Int) {
        f.parentFragmentManager.beginTransaction()
            .replace(idHolder, f)
            .commit()
    }

    override fun hideFragment(f: Fragment) {
        f.parentFragmentManager.beginTransaction()
            .hide(f)
            .commit()
    }

    override fun positiveButtonClicked() {
        var userData = UserData()
        var orderData = OrderData()
        println("Start positiveButtonClicked ChosePresenter")
        userData.email = view!!.getEmail()
        println("email: " + view!!.getEmail())
        userData.password = view!!.getPassword()
        println("password: " + view!!.getPassword())
        orderData.email = view!!.getEmail()
        orderData.sugar = view!!.getSugar()
        println("sugar: " + view!!.getSugar())
        orderData.milk = view!!.getMilk()
        println("milk: " + view!!.getMilk())
        orderData.lemon = view!!.getLemon()
        println("lemon: " + view!!.getLemon())
        orderData.drink = view!!.getDrink()
        println("drink: " + view!!.getDrink())
        orderData.drinkType = view!!.getDrinkType()
        println("drinkType: " + view!!.getDrinkType())
        model.saveOrder(orderData)
        var bundle = Bundle()
        bundle.putString("email", view!!.getEmail())
        bundle.putString("password", view!!.getPassword())
        bundle.putString("drink", view!!.getDrink())
        bundle.putString("drinkType", view!!.getDrinkType())
        bundle.putBoolean("lemon", view!!.getLemon())
        bundle.putBoolean("milk", view!!.getMilk())
        bundle.putBoolean("sugar", view!!.getSugar())
        nextFragment.arguments = bundle
        changeFragment(fragment, nextFragment)
    }

    override fun registrationButtonClicked() {
        TODO("Not yet implemented")
    }

    override fun getCurrentUser(): UserData {
        TODO("Not yet implemented")
    }

    override fun setSupportFragmentManager(support: FragmentManager) {
        TODO("Not yet implemented")
    }
}