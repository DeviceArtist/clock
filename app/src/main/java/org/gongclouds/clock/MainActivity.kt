package org.gongclouds.clock

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import org.gongclouds.clock.ui.theme.ClockTheme
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            ClockTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

val font = FontFamily(Font(R.font.digital7, FontWeight.Normal))

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    val imageBitmapList = ArrayList<ImageBitmap>()
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy1))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy2))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy3))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy4))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy5))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy6))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy7))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy8))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy9))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy10))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy11))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy12))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy13))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy14))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy15))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy16))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy17))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy18))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy19))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy20))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy21))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy22))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy23))
    imageBitmapList.add(ImageBitmap.imageResource(id = R.drawable.boy24))

    var index by remember { mutableIntStateOf(0) }
    var step by remember { mutableIntStateOf(0) }
    var y by remember { mutableFloatStateOf(-1f*screenHeight) }
    var delayforY by remember { mutableIntStateOf(0) }
    var h by remember { mutableStateOf("") }
    var m by remember { mutableStateOf("") }

//    val textMeasurer = rememberTextMeasurer()

    fun getCurrentTime(): Triple<Int, Int, Int> {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY) // 24小时制
        val minute = calendar.get(Calendar.MINUTE)
        val second = calendar.get(Calendar.SECOND)
        return Triple(hour, minute, second)
    }

    LaunchedEffect(key1 = Unit) {
        while (true){
            step++
            if(step % 2==0){

                delayforY++

                if(delayforY>200 && y<0f){
                    y+=20
                }

                if(delayforY>210){
                    y+=20
                }

                if(y>=screenHeight.toFloat()){
                    y=-4f*screenHeight
                    delayforY=0
                }
            }

            if(step % 4 ==0){
                index++
            }

            if(step>=10000){
                step=0
            }

            if(index==24){
                index=0
                val (hour, minute, third) = getCurrentTime()
                h = if(hour<10) "0${hour}" else "$hour"
                m = if(minute<10) "0${minute}" else "$minute"
            }

            delay(10)
        }
    }




    Column (
        modifier = Modifier.fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row (
            modifier = Modifier.fillMaxWidth().height(40.dp).padding(10.dp,0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            TabRow(
                modifier = Modifier.fillMaxWidth().height(20.dp),
                selectedTabIndex = 0,
                contentColor = Color(0xff8df776),
                containerColor = Color.Black
            ) {
                Tab(
                    modifier = Modifier.fillMaxWidth(),
                    text = { Text("Stat", fontFamily = font) },
                    selected = true,
                    onClick = {  },
                )
                Tab(
                    modifier = Modifier.fillMaxWidth(),
                    text = { Text("Termux", fontFamily = font) },
                    selected = false,
                    onClick = {  },
                )
                Tab(
                    modifier = Modifier.fillMaxWidth(),
                    text = { Text("APP", fontFamily = font) },
                    selected = false,
                    onClick = {  },
                )
            }
        }
        Row (
            modifier = Modifier.fillMaxWidth().padding(10.dp,0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "$h:$m",
                modifier = Modifier,
                color = Color(0xff8df776),
                fontSize = (screenHeight/2).sp,
                fontFamily = font
            )
            Canvas(
                modifier = Modifier.size((screenHeight/1.8).dp,(screenHeight/2.5).dp),
                onDraw = {
                    val width = size.width.toInt()
                    val height = size.height.toInt()
                    drawImage(
                        imageBitmapList[index],
                        dstSize = IntSize(width, height), // Resizes the image
                        dstOffset = IntOffset(0,0)
                    )
                }
            )
        }
        Row (
            modifier = Modifier.fillMaxWidth().height(40.dp).padding(10.dp,0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "HP 365/365",
                color = Color(0xff8df776),
                fontFamily = font,
                fontSize = 20.sp
            )
            Text(
                text = "LEVEL 88",
                color = Color(0xff8df776),
                fontFamily = font,
                fontSize = 20.sp
            )
            Text(
                text = "AP 130/150",
                color = Color(0xff8df776),
                fontFamily = font,
                fontSize = 20.sp
            )
        }
    }

//    Box(Modifier.fillMaxSize().graphicsLayer(alpha =0.2f)){
//        Canvas(Modifier.fillMaxSize(),
//            onDraw = {
//                val brush = Brush.verticalGradient(
//                    colors = listOf(Color(0xff000000),Color(0xff7ff12a),Color(0xff000000))
//                )
////                drawRect(brush, Offset(0f,y), Size(screenWidth.toFloat(),screenHeight*2.toFloat()))
//                drawRect(Color(0xff8df776), Offset(0f,y), Size(screenWidth.toFloat(),screenHeight*2.toFloat()))
//            })
//    }

}