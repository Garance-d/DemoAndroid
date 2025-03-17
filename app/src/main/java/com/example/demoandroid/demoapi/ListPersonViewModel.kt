package com.example.demoandroid.demoapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoandroid.demostateful.Person
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ListPersonViewModel : ViewModel() {

    // Déclarer liste personne vide
    var persons = MutableStateFlow<List<Person>>(mutableListOf())

    /**
     * Fonction qui permet de charger la liste des personnes dans le view model
     */
    fun reloadPersons(){
        // Simuler une api
        persons.value = mutableListOf(
            Person(pseudo = "Po", age = 26),
            Person(pseudo = "Lala", age = 32),
            Person(pseudo = "Tinky-Winky", age = 25),
        )

        // Coroutine (tâche async)
        viewModelScope.launch {
            // Appeler le service API
            // Pour le moment: apiResponse = le retour de l'API
            // Dans notre cas getPerson retourne une Liste de Personne
            val apiResponse = PersonService.PersonApi.personService.getPersons()

            // Remplacer la liste des personnes du viewmodel par celle récupérée dans l'API
            persons.value = apiResponse;
        }
    }
}