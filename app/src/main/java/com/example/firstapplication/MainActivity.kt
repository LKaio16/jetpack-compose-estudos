package com.example.firstapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstapplication.ui.theme.FirstApplicationTheme

//import java.lang.reflect.Modifier


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstApplicationTheme {

                /*// Material Design // DEU CERTO :)
                CardMinimalExample()
                BottomAppBarExample()
*/

                /* // Box com modifiers de posicionamento
                 Box(modifier = Modifier.fillMaxSize()){
                     Text(text = "Oi!!", modifier = Modifier.align(Alignment.TopCenter))
                     Text(text = "Bem vindo :)", modifier = Modifier.align(Alignment.Center))
                     Text(text = "Xau", modifier = Modifier.align(Alignment.BottomCenter))
                 }*/

                /* // Box com Columns e Row junto com estilização
                 Box(modifier = Modifier
                     .fillMaxSize()
                     .padding(20.dp)) {

                     // Esta Column ocupa toda a tela
                     Column(
                         modifier = Modifier
                             .fillMaxSize()

                             .background(color = Color.Blue),
                         horizontalAlignment = Alignment.CenterHorizontally,
                         verticalArrangement = Arrangement.Center
                     ) {
                         Text(
                             text = "Oi",
                             fontSize = 60.sp,
                             fontStyle = FontStyle.Italic,
                             fontWeight = FontWeight.Black
                         )
                         Text(
                             text = "Xau",
                             modifier = Modifier
                                 .padding(top = 20.dp)
                                 .background(color = Color.Red)
                         )
                     }

                     // Row sobreposta no final da tela e no centro horizontal
                     Row(
                         modifier = Modifier
                             .align(Alignment.BottomCenter) // Alinha ao centro horizontal e na parte inferior da tela
                             .background(color = Color.Gray)
                             .fillMaxWidth(),
                         horizontalArrangement = Arrangement.Center,
                         verticalAlignment = Alignment.CenterVertically
                     ) {
                         Text(
                             text = "Oi",
                             fontSize = 60.sp,
                             fontStyle = FontStyle.Italic,
                             fontWeight = FontWeight.Black
                         )
                         Text(
                             text = "Xau",
                             modifier = Modifier
                                 .padding(start = 50.dp) // Espaçamento entre os textos
                                 .background(color = Color.Red)
                         )
                     }
                 }*/

                /*  // Testes Modifiers
                  Row(modifier = Modifier.fillMaxWidth()) {
                      Box(
                          modifier = Modifier
                              .background(color = Color.Red)
                              .height(100.dp)
                              .weight(1f)
                      ) {}

                      Spacer(modifier = Modifier.width(5.dp))

                      Box(
                          modifier = Modifier
                              .background(color = Color.Blue)
                              .height(100.dp)
                              .weight(1f)
                      ) {}
                  }
  */

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .background(color = Color.Red),
                    verticalArrangement = Arrangement.Center
                ) {
                    var textState by remember {
                        mutableStateOf("")
                    }

                    val nameListState = remember {
                        mutableStateListOf<String>()
                    }


                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.Green)
                    ) {
                        items(nameListState.size) {
                            Text(text = nameListState[it])
                        }
                    }

                    CaixaTextoStateless(textValue = textState, onValueChanged = {
                        textState = it
                    }, onAddClick = {
                        nameListState.add(textState)
                        textState = ""
                    })

                    Spacer(modifier = Modifier.height(5.dp))

                    CaixaTexto()
                }

            }


            /*   BoasVindas("Kaio")
               Button(onClick = { println("A") }, content = {
                   Text(text = "butao")
               })

                Icon(painter =  painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null ,tint = Color.Red)
               Image(painter = painterResource(id =  R.drawable.ic_launcher_background), contentDescription = null)

               TextField(value = "", onValueChange = {}, label = {
                    Text(text = "Nome")
               })

               FloatingActionButton(
                   onClick = {},
                   modifier = Modifier
                       .border(2.dp, Color.Blue, CircleShape)
                       .clip(CircleShape)
               ) {
                   Icon(
                       painter = painterResource(id = R.drawable.ic_launcher_foreground),
                       contentDescription = ""
                   )
               }*/

        }
    }
}

@Composable
fun CaixaTexto() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {

        var textState by remember { mutableStateOf("") }


        TextField(value = textState, onValueChange = {
            textState = it
        }, modifier = Modifier.fillMaxWidth())

    }
}

@Composable
fun CaixaTextoStateless(
    textValue: String,
    onValueChanged: (String) -> Unit,
    onAddClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {

        TextField(
            value = textValue,
            onValueChange = {
                onValueChanged(it)
            },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    Modifier.clickable { onAddClick() })
            }
        )

    }
}


@Composable
fun BoasVindas(name: String) {
    Text(
        text = "Bem vindo!", color = Color.Red, fontSize = 60.sp
    )
}

@Composable
fun CardMinimalExample() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = "Filled",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}


@Composable
fun BottomAppBarExample() {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(Icons.Filled.Check, contentDescription = "Localized description")
                    }
                    IconButton(onClick = { println("MATERIAL DESIGN") }) {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = "Localized description",
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Add,
                            contentDescription = "Localized description",
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.AccountCircle,
                            contentDescription = "Localized description",
                        )
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { /* do something */ },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.Add, "Localized description")
                    }
                }
            )
        },
    ) { innerPadding ->
        Text(
            modifier = Modifier.padding(innerPadding),
            text = "Example of a scaffold with a bottom app bar."
        )
    }
}

