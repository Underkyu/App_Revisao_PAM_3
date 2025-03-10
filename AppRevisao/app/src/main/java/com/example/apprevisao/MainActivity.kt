package com.example.apprevisao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apprevisao.ui.theme.AppRevisaoTheme
import com.example.apprevisao.ui.theme.Miku
import com.example.apprevisao.ui.theme.Teto

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppRevisaoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProdutoItem()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProdutoItem() {
    Column(
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Teto, Miku)
                    )
                )
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ado),
                contentDescription = "Imagem de perfil",
                modifier = Modifier
                    .offset(y = 60.dp)
                    .size(150.dp) // Aumenta o tamanho, mas continua circular
                    .aspectRatio(1f) // Garante que a largura e a altura sejam sempre iguais
                    .clip(CircleShape) // Recorta em forma de círculo
                    .align(Alignment.BottomCenter)
            )
        }
        Spacer(modifier = Modifier.height(85.dp))

        var nome by remember { mutableStateOf("") }
        var telefone by remember { mutableStateOf("") }
        var curso by remember { mutableStateOf("") }
        var serie by remember { mutableStateOf("") }

        OutlinedTextField(
            value = nome,
            label = { Text("Nome") },
            onValueChange = { nome = it },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
            value = telefone,
            label = { Text("Telefone") },
            onValueChange = { telefone = it },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
            value = curso,
            label = { Text("Curso") },
            onValueChange = { curso = it },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
            value = serie,
            label = { Text("Serie") },
            onValueChange = { serie = it },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(25.dp))
        Button(onClick = {},
            modifier = Modifier
                .height(50.dp)
                .width(150.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(containerColor = Teto)
        ) {
            Text("Enviar")
        }
    }


}