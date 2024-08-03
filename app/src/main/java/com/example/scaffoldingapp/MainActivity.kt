package com.example.scaffoldingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scaffoldingapp.ui.theme.ScaffoldingAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScaffoldingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScaffoldCoffee(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldCoffee(modifier: Modifier = Modifier) {
    var sugar by remember { mutableIntStateOf(0) }
    var cream by remember { mutableIntStateOf(0) }
    var milk by remember { mutableIntStateOf(0) }


    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("CoffeeMaker App")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Assemble your coffee cup",
                )
            }
        },
        floatingActionButton = {
            Row {
                Card(
                    modifier = Modifier.padding(5.dp),
                    shape = ShapeDefaults.Large,
                    elevation = CardDefaults.elevatedCardElevation()) {
                    Text(text = "Sugar",
                        modifier = Modifier.padding(2.dp))
                    FloatingActionButton(onClick = { sugar++ }) {
                        Icon(Icons.Default.Add, contentDescription = "Add Sugar")
                    }
                }
                Card(
                    modifier = Modifier.padding(5.dp),
                    shape = ShapeDefaults.Large,
                    elevation = CardDefaults.elevatedCardElevation()) {
                    Text(text = "Cream",
                        modifier = Modifier.padding(2.dp))
                    FloatingActionButton(onClick = { cream++ }) {
                        Icon(Icons.Default.Add, contentDescription = "Add Cream")
                    }
                }
                Card(
                    modifier = Modifier.padding(5.dp),
                    shape = ShapeDefaults.Large,
                    elevation = CardDefaults.elevatedCardElevation()) {
                    Text(text = "Sugar",
                        modifier = Modifier.padding(2.dp))
                    FloatingActionButton(onClick = { milk++ }) {
                        Icon(Icons.Default.Add, contentDescription = "Add Milk")
                    }
                }

            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text =
                """
                   Welcome to the coffee maker app.
                   
                    Your cup will contain :
                    $sugar measures of sugar.
                    $cream measures of cream.
                    $milk measures of milk.
               """.trimIndent(),
            )
        }
    }
}
