package com.projectbox.koinviewmodelreport

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel

/**
 * Created by adinugroho
 */
class MainVM : ViewModel() {
    private var pendingList = MutableLiveData<List<String>>()
    var filteredPendingList: LiveData<List<String>> = Transformations.map(pendingList, { it })

    var list = listOf("Hello", "Where", "Are", "You", "From", "It's", "Lonely", "Here")

    fun filterList(searchString: String = "") {
        if (searchString.isEmpty()) {
            pendingList.value = list
        } else {
            pendingList.value = list.filter { it.contains(searchString, true) }
        }
    }
}