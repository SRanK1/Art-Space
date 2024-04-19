package com.example.artspace


import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentScreen by remember { mutableStateOf(1) }

    when (currentScreen) {
        1 -> Pantalla1 { currentScreen = 2 }
        2 -> Pantalla2(
            onPreviousClick = { currentScreen = 1 },
            onNextClick = { currentScreen = 3 }
        )
        3 -> Pantalla3 { currentScreen = 2 }
    }
}

@Composable
fun Pantalla1(onNextClick: () -> Unit) {
    // Contenido de la primera pantalla (Messi campeón del mundo en Qatar)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Sección de muro con la obra de arte
        Image(
            painter = painterResource(id = R.drawable.obra_de_arte), // Reemplaza con tu imagen
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
                .border(2.dp, Color.Gray),
            contentScale = ContentScale.Crop
        )

        // Sección de información sobre la obra de arte con borde
        Column(
            modifier = Modifier
                .padding(16.dp)
                .border(2.dp, Color.Gray)
        ) {
            Text(
                text = "Messi campeón del mundo en Qatar",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 20.sp
            )
            Text(
                text = "Messi (2021)",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 16.sp
            )
        }

        // Sección de controles
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onNextClick,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Siguiente")
            }
        }
    }
}

@Composable
fun Pantalla2(onPreviousClick: () -> Unit, onNextClick: () -> Unit) {
    // Contenido de la segunda pantalla (Argentina campeona del mundo)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Sección de muro con la imagen "seleccion_campeona"
        Image(
            painter = painterResource(id = R.drawable.seleccion_campeona), // Reemplaza con tu imagen
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .border(2.dp, Color.Gray),
            contentScale = ContentScale.Crop
        )

        // Sección de información sobre la obra de arte con borde
        Column(
            modifier = Modifier
                .padding(16.dp)
                .border(2.dp, Color.Gray)
        ) {
            Text(
                text = "Argentina campeona del mundo Qatar 2022",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 20.sp
            )
            Text(
                text = "Mariano Closs (2022)",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 16.sp
            )
        }

        // Sección de controles
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onPreviousClick,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Anterior")
            }
            Button(
                onClick = onNextClick,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Siguiente")
            }
        }
    }
}

@Composable
fun Pantalla3(onPreviousClick: () -> Unit) {
    // Contenido de la tercera pantalla (¿Cuándo se retirará Messi?)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Sección de muro con la imagen de Messi
        Image(
            painter = painterResource(id = R.drawable.messi_retiro), // Reemplaza con tu imagen de Messi
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .border(2.dp, Color.Gray),
            contentScale = ContentScale.Crop
        )

        // Sección de información sobre la obra de arte con borde
        Column(
            modifier = Modifier
                .padding(16.dp)
                .border(2.dp, Color.Gray)
        ) {
            Text(
                text = "¿Cuándo se retirará Messi?",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 20.sp
            )
            Text(
                text = "Kevin Alfaro (2024)",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 16.sp
            )
        }

        // Sección de controles
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onPreviousClick,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Anterior")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}