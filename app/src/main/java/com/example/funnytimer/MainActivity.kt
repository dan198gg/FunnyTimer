package com.example.funnytimer

import android.annotation.SuppressLint
import android.os.Bundle
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







@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun colorfullSquares(){
    var num by rememberSaveable {
        mutableIntStateOf(0)
    }
    var x by rememberSaveable{
        mutableStateOf(0)
    }
    var corScope = rememberCoroutineScope()
    corScope.launch {
    repeat(100) {
        delay(1000)
        num+=1
    }
    }

    Box(Modifier.fillMaxSize()) {
        Text(text = num.toString(), modifier = Modifier.align(Alignment.Center), fontSize = 240.sp)
    }

            Box(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier.size(100.dp).fillMaxWidth()){
                    repeat(if (num<10) num else num/10) {
                    Row(modifier = Modifier.weight(0.1f)) {
                    repeat(num % 10) {

                            Canvas(
                                modifier = Modifier
                                    .weight(0.1f)
                                    .fillMaxHeight()
                                    .offset(x.dp,0.dp)
                            ) {
                                drawRect(color = Color.Blue)
                                corScope.launch {
                                    delay(1000)
                                    x+=50
                                }
                            }
                        }
                    }
                }
            }
            }
        }












