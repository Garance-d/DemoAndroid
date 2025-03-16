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

class DemoStatefulActivity : ComponentActivity() {

    // Déclarer un compteur en entier écoutable
    var counter = MutableStateFlow<Int>(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoStatefulPage(counter)
        }
    }
}

@Composable
fun DemoStatefulPage(counter: MutableStateFlow<Int>) {
    // J'ecoute les changements de counter en temps réel
    val counterState by counter.collectAsState()

    EniPage {
        Column(modifier = Modifier.padding(30.dp)) {
            WrapPadding {
                Text(text = "Compteur : ${counterState}",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.White, fontWeight = FontWeight.Bold)
            }
            WrapPadding {
                EniButton(buttonText = "Incrementer", onClick = {
                    counter.value += 1
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemoStatefulPreview() {

    var counter = MutableStateFlow<Int>(0)

    DemoStatefulPage(counter)
}