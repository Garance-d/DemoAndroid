package com.example.demoandroid.demomvvm

import androidx.lifecycle.ViewModel
import com.example.demoandroid.demostateful.Person
import kotlinx.coroutines.flow.MutableStateFlow

class DemoViewModel : ViewModel() {
    var persons = MutableStateFlow<List<Person>>(
        mutableListOf(
            Person("Chocolatine", 33),
            Person("CrevetteNutella", 36)
        )
    )
}