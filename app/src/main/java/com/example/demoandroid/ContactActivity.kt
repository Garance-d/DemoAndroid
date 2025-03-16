package com.example.demoandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demoandroid.ui.theme.EniButton
import com.example.demoandroid.ui.theme.EniPage
import com.example.demoandroid.ui.theme.EniTextField

class ContactActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactPage()
        }
    }
}

@Composable
fun ContactPage(){
    EniPage {
        Column(modifier = Modifier.padding(30.dp)) {
            EniTextField(hintText = "Email")
            EniButton(buttonText = "Envoyer")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactPreview() {
    ContactPage()
}
