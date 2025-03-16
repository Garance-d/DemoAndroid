package com.example.demoandroid.demointent

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.demoandroid.MainActivity
import com.example.demoandroid.ui.theme.EniButton
import com.example.demoandroid.ui.theme.EniPage
import com.example.demoandroid.ui.theme.WrapPadding

class DemoPage1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoPage1()
        }
    }
}

@Composable
fun DemoPage1() {
    // Récupérer le context de l'app
    val context = LocalContext.current

    EniPage {
        Column(modifier = Modifier.padding(30.dp)) {
            WrapPadding {
                EniButton(buttonText = "Ouvrir page 2", onClick = {
                    // Specifier quelle action : PS quel activity à ouvrir
                    val intent = Intent(context, MainActivity::class.java)
                    // Ouvrir l'ativity
                    context.startActivity(intent)
                })
            }
            ClickableText(
                text = AnnotatedString("Test"),
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    textAlign = TextAlign.Center
                ),
            ) { }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemoPage1Preview() {
    DemoPage1()
}