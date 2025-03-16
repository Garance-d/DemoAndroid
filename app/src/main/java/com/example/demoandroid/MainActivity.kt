package com.example.demoandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demoandroid.ui.theme.DemoAndroidTheme
import com.example.demoandroid.ui.theme.WrapPadding
import com.example.demoandroid.ui.theme.WrapPaddingRowWeight
import com.example.demoandroid.ui.theme.EniButton
import com.example.demoandroid.ui.theme.EniPage
import com.example.demoandroid.ui.theme.EniTextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoPage()
        }
    }
}

@Composable
fun DemoPage(){
    EniPage {
        Column(modifier = Modifier.padding(30.dp)) {
            Spacer(modifier = Modifier.weight(0.7f))
            Text(
                text = "Personal Details",
                color = Color(0xDDFFFFFF),
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
                textAlign = TextAlign.Center
            )
            WrapPadding {
                EniTextField(hintText = "First Name")
            }
            WrapPadding {
                EniTextField(hintText = "Last Name")
            }
            WrapPadding {
                EniTextField(hintText = "Email")
            }
            Row {
                WrapPaddingRowWeight {
                    EniTextField()
                }
                WrapPaddingRowWeight(2f) {
                    EniTextField()
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                WrapPaddingRowWeight {
                    EniTextField(hintText = "DD")
                }
                WrapPaddingRowWeight {
                    EniTextField(hintText = "MM")
                }
                WrapPaddingRowWeight {
                    EniTextField(hintText = "YYYY")
                }
            }
            Row {
                WrapPaddingRowWeight {
                    EniButton(buttonText = "Back")
                }
                WrapPaddingRowWeight {
                    EniButton(buttonText = "Next Page")
                }
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemoPage()
}