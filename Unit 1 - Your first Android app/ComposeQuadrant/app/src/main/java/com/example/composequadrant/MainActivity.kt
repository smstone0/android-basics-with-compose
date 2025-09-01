package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeQuadrantApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(modifier.weight(1f)) {
            Quadrant(
                colour = Color(0xFFEADDFF),
                title = "Text composable",
                description = "Displays text and follows the recommended Material Design guidelines.",
                modifier = modifier.weight(1f)
            )
            Quadrant(
                colour = Color(0xFFD0BCFF),
                title = "Image composable",
                description = "Creates a composable that lays out and draws a given Painter class object.",
                modifier = modifier.weight(1f)
            )
        }
        Row(modifier.weight(1f)) {
            Quadrant(
                colour = Color(0xFFB69DF8),
                title = "Row composable",
                description = "A layout composable that places its children in a horizontal sequence.",
                modifier = modifier.weight(1f)
            )
            Quadrant(
                colour = Color(0xFFF6EDFF),
                title = "Column composable",
                description = "A layout composable that places its children in a vertical sequence.",
                modifier = modifier.weight(1f)
            )
        }
    }

}

@Composable
fun Quadrant(modifier: Modifier = Modifier, colour: Color, title: String, description: String) {
    Column(
        modifier = modifier
            .background(color = colour)
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = title,
            fontWeight = FontWeight.Bold
        )
        Text(text = description, textAlign = TextAlign.Justify)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrantApp()
    }
}