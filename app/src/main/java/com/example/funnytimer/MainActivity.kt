package com.example.funnytimer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.funnytimer.ui.theme.FunnyTimerTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            colorfullSquares()

        }
    }
}






@Composable
fun colorfullSquares(){
    var num=0
    var corScope = rememberCoroutineScope()
    repeat(100) {
        num++
    }
        repeat(num/10) {
            Column() {
                repeat(num % 10) {
                    Row() {
                        Canvas(modifier = Modifier.weight(0.1f).fillMaxHeight()) {
                            drawRect(color = Color.Gray)
                            corScope.launch {
                                delay(1000)
                            }
                        }
                    }
                }
            }
            }
        }












