package com.example.countdownappwithcompose

import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.countdownappwithcompose.ui.theme.CountDownAppWithComposeTheme


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountDownAppWithComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CountDown()
                }
            }
        }
    }
}

@Composable
fun CountDown() {

    var nums: Long by remember{ mutableStateOf(10)}
    var setView: String by remember{ mutableStateOf("Start CountDown")}

    val countNum = object: CountDownTimer(10000, 1000){
        override fun onTick(millisUntilFinished: Long) {
            nums = millisUntilFinished/1000
            setView = "$nums"
        }

        override fun onFinish() {
            setView = "Finished"
        }
    }

    /**Set Design*/
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center) {
        Text(text = "$setView", modifier = Modifier.padding(bottom = 8.dp),
        style = MaterialTheme.typography.h5)
        Button(onClick = { countNum.start() }) {
            Text(text = "Start CountDown")
            
        }

    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CountDownAppWithComposeTheme {
        CountDown()
    }
}