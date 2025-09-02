package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = Color(0xFFD2E8D4))
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        IntroSection(modifier = modifier)
        Spacer(modifier = Modifier.weight(1f))
        ContactSection(modifier = modifier)
    }
}

@Composable
fun IntroSection(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = image,
            contentDescription = "Android logo",
            modifier = Modifier
                .background(color = Color(0xFF073042))
                .width(120.dp)
                .height(120.dp)
                .padding(8.dp)
        )
        Text(
            text = "Jennifer Doe",
            modifier = Modifier.padding(top = 8.dp),
            fontSize = 40.sp,
            fontWeight = FontWeight.Light,
        )
        Text(
            text = "Android Developer Extraordinaire",
            fontWeight = FontWeight.Bold,
            color = Color(0xFF006837),
        )
    }
}

@Composable
fun ContactSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(bottom = 16.dp)) {
        ContactRow(
            imageVector = Icons.Filled.Phone,
            text = "+11 (123) 444 555 666",
        )
        ContactRow(
            imageVector = Icons.Filled.Share,
            text = "@AndroidDev"
        )
        ContactRow(
            imageVector = Icons.Filled.Email,
            text = "jen.doe@android.com"
        )
    }
}

@Composable
fun ContactRow(modifier: Modifier = Modifier, imageVector: ImageVector, text: String) {
    Row(modifier = modifier.padding(vertical = 4.dp)) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint = Color(0xFF006d3b)
        )
        Spacer(
            modifier = modifier.width(16.dp)
        )
        Text(
            text = text,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}