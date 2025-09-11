package com.example.lemonade

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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp(
                    modifier = Modifier
                )
            }
        }
    }
}

data class ResGroup(
    val imageRes: Int,
    val contentDescRes: Int,
    val textRes: Int
)

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableIntStateOf(1) }
    var requiredSqueezes by remember { mutableIntStateOf((2..4).random()) }
    val resGroup = when (currentStep) {
        1 -> ResGroup(
            R.drawable.lemon_tree,
            R.string.lemon_tree_content_description,
            R.string.tap_to_select
        )
        2 -> ResGroup(
            R.drawable.lemon_squeeze,
            R.string.lemon_content_description,
            R.string.tap_to_squeeze
        )
        3 -> ResGroup(
            R.drawable.lemon_drink,
            R.string.glass_of_lemonade_content_description,
            R.string.tap_to_drink
        )
        else -> ResGroup(
            R.drawable.lemon_restart,
            R.string.empty_glass_content_description,
            R.string.tap_to_restart
        )
    }

    fun updateStep() {
        if (currentStep == 2) {
            if (--requiredSqueezes > 0) {
                // Continue squeezing
                return
            } else {
                // Finished squeezing, move to next step
                requiredSqueezes = (2..4).random()
            }
        }
        currentStep++
        if (currentStep > 4) {
            currentStep = 1
        }
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color(0xfff9e44c))
            .padding(top = 40.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.app_name),
            modifier = modifier,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
        )
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            shape = RoundedCornerShape(40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xffc3ecd2)),
            onClick = { updateStep() }) {
            Image(
                painter = painterResource(resGroup.imageRes),
                contentDescription = stringResource(resGroup.contentDescRes),
                modifier = Modifier
                    .wrapContentSize()
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Text(
            text = stringResource(resGroup.textRes),
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}