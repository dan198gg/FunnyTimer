package com.example.funnytimer
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf











import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
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
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var corScope = rememberCoroutineScope()
            colorfullSquares(corScope)
        }
    }
}




@Composable
fun colorfullSquares(cor1:CoroutineScope) {
    var layout = LocalConfiguration.current
    var width = (layout.screenWidthDp / 10)
    var heigh = (layout.screenHeightDp / 10)
    var num by rememberSaveable {
        mutableIntStateOf(0)
    }
    var offsetSqw = 0
    var offsetSqh = 0
    var rcolor by remember {
        mutableStateOf<MutableList<Color>>(mutableListOf())
    }
    LaunchedEffect(key1 = "launch") {
        cor1.launch {

            repeat(100) {
                num += 1
                delay(1000)
            }

            Log.i("NUM", num.toString())

        }
    }
    Box(Modifier.fillMaxSize()) {
        Text(text = num.toString(), modifier = Modifier.align(Alignment.Center), fontSize = 200.sp)
        for (num1 in 0..num - 1) {
            rcolor.add(
                Color(
                    0xDD + ("${getRandomHex().toLong(16)}${
                        getRandomHex().toLong(16)
                    }${getRandomHex().toLong(16)}${getRandomHex().toLong(16)}").toLong(
                        16
                    )
                )
            )
            Box(
                modifier = Modifier
                    .size(width = width.dp, heigh.dp)
                    .offset(offsetSqw.dp, offsetSqh.dp)
                    .background(
                        rcolor[num1]
                    )
            )
            offsetSqw += width
            if (num1 % 10 == 9) {
                offsetSqh += heigh
                offsetSqw = 0
            }
        }
    }
}


fun getRandomHex() = Random.nextInt(255).toString(16).uppercase()















