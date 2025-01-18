package com.btu_davaleba.davaleba3_basic_firebase_rv_project

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.btu_davaleba.davaleba3_basic_firebase_rv_project.data.FirebasePost
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.getValue

class FirebaseViewModel: ViewModel() {

    private val database = FirebaseDatabase.getInstance("https://davaleba3-b79c9-default-rtdb.europe-west1.firebasedatabase.app/")

    private val _items = MutableLiveData<List<FirebasePost>>()
    val items: LiveData<List<FirebasePost>> get() = _items

    private val _isLoading = MutableLiveData<Boolean>(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    init {
        fetchItems()
    }

    private fun fetchItems() {
        _isLoading.value = true

        database.getReference("items").get().addOnSuccessListener { snapshot ->
            val itemList = snapshot.children.mapNotNull { it.getValue<FirebasePost>() }
            _items.value = itemList
            _isLoading.value = false
        }.addOnFailureListener { exception ->
            exception.printStackTrace()
            _isLoading.value = false
        }
    }

}