package com.nailton.slotdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nailton.slotdemo.ui.theme.SlotDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SlotDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    SlotDemo(
                        textComposable = { topTextDemo() },
                        middleComposable = { buttonDemo() },
                        textComposable2 = { bottomTextDemo() }
                    )
                }
            }
        }
    }
}

/**
 * Criando Slot Api Composables que nos permitem chamar funcoes composable dentro
 * de funcoes composable passando como parametro a nossa slot com a sintaxe abaixo.
 * OBS: Podemos passar quantos slots quisermos
 */

@Composable
private fun SlotDemo(
    textComposable: @Composable () -> Unit,
    middleComposable: @Composable () -> Unit,
    textComposable2: @Composable () -> Unit) {
    Column(
        modifier = Modifier,
        Arrangement.Center,
        Alignment.CenterHorizontally
    ){
        textComposable()
        middleComposable()
        textComposable2()
    }
}

@Composable
private fun buttonDemo() {
    Button(onClick = { }, modifier = Modifier.padding(14.dp)) {
        Text(text = "Click Me")
    }
}

@Composable
private fun topTextDemo() {
    Text("Top Text")
}

@Composable
private fun bottomTextDemo() {
    Text("Bottom Text")
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SlotDemoTheme {
        SlotDemo(
            textComposable = { topTextDemo() },
            middleComposable = {  buttonDemo() },
            textComposable2 = { bottomTextDemo() }
        )
    }
}