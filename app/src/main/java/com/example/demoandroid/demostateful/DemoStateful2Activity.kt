package com.example.demoandroid.demostateful

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demoandroid.ui.theme.EniButton
import com.example.demoandroid.ui.theme.EniPage
import com.example.demoandroid.ui.theme.WrapPadding
import kotlinx.coroutines.flow.MutableStateFlow

class DemoStateful2Activity : ComponentActivity() {

    // Déclarer un compteur en entier écoutable
    var person = MutableStateFlow<Person>(Person("Chocolatine", 32))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoStateful2Page(person)
        }
    }
}

@Composable
fun DemoStateful2Page(person: MutableStateFlow<Person>) {
    // J'ecoute les changements de Person en temps réel
    val personState by person.collectAsState()

    EniPage {
        Column(modifier = Modifier.padding(30.dp)) {
            WrapPadding {
                Text(text = "Pseudo : ${personState.pseudo}",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.White, fontWeight = FontWeight.Bold)
            }
            WrapPadding {
                EniButton(buttonText = "Incrementer", onClick = {
                    //person.value.pseudo = "Beurre Doux"
                    // person.value = person.value
                    // person.value = Person("Beurre Doux", 32)
                   person.value = person.value.copy(pseudo = "Beurre Doux")
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemoStateful2Preview() {

    var person = MutableStateFlow<Person>(Person("Chocolatine", 32))

    DemoStateful2Page(person)
}