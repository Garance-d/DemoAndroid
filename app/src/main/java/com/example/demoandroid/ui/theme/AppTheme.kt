package com.example.demoandroid.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.demoandroid.R

@Composable
fun EniTextField(hintText : String = "", modifier: Modifier = Modifier){
    TextField(value = "", onValueChange = {},
        modifier = modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0x66000000),
            focusedContainerColor = Color(0x99000000),
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(40.dp),
        placeholder = {
            Text(text = hintText, color = Color(0xAAFFFFFF))
        })
}

@Composable
fun EniButton(buttonText : String, modifier: Modifier = Modifier, onClick: () -> Unit = {}){
    Button(onClick = onClick,
        border = BorderStroke(2.dp, Color(0x55FFFFFF)),
        contentPadding = PaddingValues(),
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.background(brush = Brush.linearGradient(
                listOf(Color(0xFF54668b), Color(0xFF4188b5))
            )).fillMaxWidth().padding(vertical = 14.dp)
        ) {
            Text(text = buttonText)
        }
    }
}

@Composable
fun WrapPadding(content: @Composable () -> Unit){
    Box(modifier = Modifier.padding(10.dp)) {
        content()
    }
}

@Composable
fun RowScope.WrapPaddingRowWeight(weight: Float = 1f, content: @Composable () -> Unit){
    Box(modifier = Modifier.padding(10.dp).weight(weight)) {
        content()
    }
}

@Composable
fun EniPage(content: @Composable () -> Unit){
    DemoAndroidTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                Image(
                    painter = painterResource(R.drawable.mobile_2),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                content()
            }
        }
    }
}