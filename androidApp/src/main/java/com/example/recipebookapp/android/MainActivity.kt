package com.example.recipebookapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recipebookapp.Greeting
import com.example.recipebookapp.Recipe
import com.example.recipebookapp.RecipeRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    GreetingView(Greeting().greet())
                }

                RecipeListScreen()
            }
        }
    }
}


@Composable
fun RecipeListScreen() {
    val recipes = RecipeRepository.getRecipes()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(recipes) { recipe ->
            RecipeItem(recipe)
        }
    }
}

@Composable
fun RecipeItem(recipe: Recipe) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(text = recipe.name, style = MaterialTheme.typography.headlineSmall)
        Text(text = "Ingredients:", style = MaterialTheme.typography.bodyMedium)
        for (ingredient in recipe.ingredients) {
            Text(text = "- $ingredient", style = MaterialTheme.typography.bodySmall)
        }
        Text(text = "Instructions: ${recipe.instructions}", style = MaterialTheme.typography.bodyMedium)
    }
}



@Composable
fun GreetingView(message: String, textColor: Color) {
    Text(text = message, color = textColor)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        darkColorScheme(primaryContainer = Color.Red) // Example theme application

        Column {
            // Set text color to White for the first greeting
            GreetingView("Hello, Android! How are you?", textColor = Color.White)

            // Set text color to Yellow for the second greeting
            GreetingView("Hello, Android!" +
                    " How are you? \n Ok", textColor = Color.Yellow)
        }
    }
}
