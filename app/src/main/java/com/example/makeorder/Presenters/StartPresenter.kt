package com.example.makeorder.Presenters

import android.content.DialogInterface
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.makeorder.*
import com.example.makeorder.Data.OrderData
import com.example.makeorder.Data.UserData

class StartPresenter(private val model: StartMVP.UserModel):StartMVP.Presenter {
    private var view: StartMVP.StartView? = null
    private lateinit var support: FragmentManager
    private lateinit var user: UserData
    private lateinit var fragment:Fragment
    private var nextFragment: Fragment? = null
    private var idHolder:Int = 0
    private var order: OrderData? = null

    override fun setView(view: StartMVP.StartView){
        this.view = view
    }

    override fun setView(view: StartMVP.LoginView) {
        TODO("Not yet implemented")
    }

    override fun setView(view: StartMVP.ChoseView) {
        TODO("Not yet implemented")
    }


    override fun setSupportFragmentManager(support: FragmentManager) {
        this.support = support
    }


    override fun setFragment(fragment:Fragment, idHolder: Int) {
        this.fragment = fragment
        this.idHolder = idHolder
    }
    override fun setNextFragment(fragment:Fragment) {
        this.nextFragment=fragment
       // this.idHolder=idHolder
    }
    override fun positiveButtonClicked() {
        if (view != null) {
            //model.saveUser(view!!.getLogin(),view!!.getPassword(), view!!.getPhone(), view!!.getName())
            //changeFragment(fragment, nextFragment, idHolder)
            println("Start Presenter")
            openFragment(fragment, idHolder)
        }
    }
    override fun registrationButtonClicked() {

    }
    object DismissClickListener : DialogInterface.OnClickListener {
        override fun onClick(dialogInterface: DialogInterface, which: Int) {
            dialogInterface.dismiss()
        }
    }

    override fun getCurrentUser(): UserData {
        return model.getUser()
    }

    override fun changeFragment(fragmentHide:Fragment, fragmentShow:Fragment){
        hideFragment(fragmentHide)
        openFragment(fragmentShow, idHolder)

    }
    override fun openFragment(f:Fragment, idHolder:Int){
        support.beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
    override fun hideFragment(f:Fragment){
        support.beginTransaction()
            .hide(f)
            .commit()
    }
}


