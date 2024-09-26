package com.example.firstapplication

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstapplication.ui.theme.FirstApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//           Button(onClick = { println("A") }, content = {
//               Text(text = "butao")
//           })

//            Icon(painter =  painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null ,tint = Color.Red)
//            Image(painter = painterResource(id =  R.drawable.ic_launcher_background), contentDescription = null)


//            TextField(value = "", onValueChange = {}, label = {
//                 Text(text = "Nome")
//            })

            FloatingActionButton(onClick = {}, modifier =  Modifier.border(2.dp,Color.Blue, CircleShape).clip(CircleShape)) {
                Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "")
            }

        }
    }
}


@Composable
fun BoasVindas(name: String){
    Text(
        text = "Bem vindo!", color = Color.Red, fontSize = 60.sp
    )
}

