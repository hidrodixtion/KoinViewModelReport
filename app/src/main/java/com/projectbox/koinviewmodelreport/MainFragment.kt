package com.projectbox.koinviewmodelreport


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.architecture.ext.viewModel


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    companion object {
        fun INSTANCE(title: String): MainFragment {
            val bundle = Bundle()
            bundle.putString("title", title)
            val fragment = MainFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    //TODO: 1. comment injection below to use ViewModelProviders
    val vmMain by viewModel<MainVM>()

    //TODO: 2. uncomment below to use ViewModelProviders
//    lateinit var vmMain: MainVM

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =// Inflate the layout for this fragment
            inflater!!.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        //TODO: 3. uncomment below to use ViewModelProviders
//        vmMain = ViewModelProviders.of(this).get(MainVM::class.java)

        createObservers()

        vmMain.filterList()

        if (arguments.getString("title") == "Title A") {
            Handler().postDelayed({vmMain.filterList("e")}, 100L)
        }
    }

    private fun createObservers() {
        // on Got filtered pending list
        vmMain.filteredPendingList.observe(this, Observer<List<String>> {
            txt_title.text = it?.joinToString(" ")
        })
    }
}
