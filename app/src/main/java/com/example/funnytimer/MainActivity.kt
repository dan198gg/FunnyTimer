package com.example.funnytimer

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funnytimer.ui.theme.FunnyTimerTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var corScope = rememberCoroutineScope()
            var corScope2 = rememberCoroutineScope()

            colorfullSquares(corScope,corScope2)

        }
    }
}








@Composable
fun colorfullSquares(cor1:CoroutineScope,cor2:CoroutineScope){

    var num by rememberSaveable {
        mutableIntStateOf(0)
    }
    repeat(100) {
            cor1.launch {
            num += 1
                delay(1000
                )
                }

        Log.i("NUM", num.toString())

    }

    Box(Modifier.fillMaxSize()) {
        Text(text = num.toString(), modifier = Modifier.align(Alignment.Center), fontSize = 240.sp)
    }

            Box(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(modifier = Modifier.weight(1f).fillMaxWidth()) {
                        repeat(num % 10) {

                            Canvas(
                                modifier = Modifier
                                    .size(50.dp)
                            ) {
                                drawRect(color = Color.Blue)
                            }
                        }
                    }
                    }
                    repeat(num / 10) {

                        Row(modifier = Modifier.size(50.dp).fillMaxWidth()) {
                                Canvas(
                                    modifier = Modifier
                                        .size(50.dp)
                                ) {
                                    drawRect(color = Color.Blue, size = this.size.div(1f))
                                }

                            }
                        }

                }
            }













