package com.example.demoandroid.demomvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demoandroid.demomvvm.DemoViewModelPage
import com.example.demoandroid.demostateful.Person
import com.example.demoandroid.ui.theme.EniButton
import com.example.demoandroid.ui.theme.EniPage
import com.example.demoandroid.ui.theme.WrapPadding
import kotlinx.coroutines.flow.MutableStateFlow

class DemoViewModelActivity : ComponentActivity() {

    // Déclarer un viewModel
    var viewModel = DemoViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoViewModelPage(viewModel)
        }
    }
}

@Composable
fun DemoViewModelPage(viewModel: DemoViewModel) {
    // J'ecoute les changements de Person en temps réel
    val personState by viewModel.persons.collectAsState()

    EniPage {
        Column(modifier = Modifier.padding(30.dp)) {
            LazyColumn {
                items(personState) { person ->
                    Text(
                        text = "Pseudo : ${person.pseudo}",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White, fontWeight = FontWeight.Bold
                    )
                }
            }
            WrapPadding {
                EniButton(buttonText = "Incrementer", onClick = {
                    viewModel.persons.value+=Person("Titi", 69)
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemoViewModelPreview() {

    var viewModel = DemoViewModel()

    DemoViewModelPage(viewModel)
}