package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      LemonadeTheme {
        App()
      }
    }
  }
}

@Composable
fun App(modifier: Modifier = Modifier) {
  val currentStep = remember { mutableIntStateOf(1) }
  var count = 0;
  val randNum = (5..10).random()

  Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
    when (currentStep.intValue) {
      1 -> {
        Column(
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center,
          modifier = Modifier.fillMaxSize()
        ) {
          Text(text = stringResource(id = R.string.tap_lemon))
          Spacer(modifier = Modifier.height(32.dp))
          Image(
            painter = painterResource(id = R.drawable.lemon_tree),
            contentDescription = stringResource(
              id = R.string.lemon_tree_content_description
            ),
            modifier = Modifier
              .wrapContentSize()
              .clickable {
                currentStep.value = 2
              }
          )
        }
      }

      2 -> {
        Column(
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center,
          modifier = Modifier.fillMaxSize()
        ) {
          Text(text = stringResource(id = R.string.keep_tapping))
          Spacer(modifier = Modifier.height(32.dp))
          Image(
            painter = painterResource(id = R.drawable.lemon_squeeze),
            contentDescription = stringResource(
              id = R.string.lemon_content_description
            ),
            modifier = Modifier
              .wrapContentSize()
              .clickable {
                count++;
                if (count == randNum) {
                  currentStep.intValue = 3
                }
              }
          )
        }
      }

      3 -> {
        Column(
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center,
          modifier = Modifier.fillMaxSize()
        ) {
          Text(text = stringResource(id = R.string.tap_to_drink))
          Spacer(modifier = Modifier.height(32.dp))
          Image(
            painter = painterResource(id = R.drawable.lemon_drink),
            contentDescription = stringResource(
              id = R.string.glass_content_description
            ),
            modifier = Modifier
              .wrapContentSize()
              .clickable {
                currentStep.intValue = 4
              }
          )
        }
      }

      4 -> {
        Column(
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center,
          modifier = Modifier.fillMaxSize()
        ) {
          Text(text = stringResource(id = R.string.tap_empty))
          Spacer(modifier = Modifier.height(32.dp))
          Image(
            painter = painterResource(id = R.drawable.lemon_restart),
            contentDescription = stringResource(
              id = R.string.empty_glass_content_description
            ),
            modifier = Modifier
              .wrapContentSize()
              .clickable {
                currentStep.intValue = 1
              }
          )
        }
      }
    }

  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
  LemonadeTheme {
    App()
  }
}