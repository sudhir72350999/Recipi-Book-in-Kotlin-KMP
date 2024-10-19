package com.example.recipebookapp



data class Recipe(
    val name: String,
    val ingredients: List<String>,
    val instructions: String
)

object RecipeRepository {
    fun getRecipes(): List<Recipe> {
        return listOf(
            Recipe(
                name = "Pasta",
                ingredients = listOf("Pasta", "Tomato Sauce", "Cheese"),
                instructions = "1. Cook pasta. 2. Add sauce. 3. Sprinkle cheese."
            ),
            Recipe(
                name = "Pancakes",
                ingredients = listOf("Flour", "Eggs", "Milk", "Sugar", "Butter"),
                instructions = "1. Mix ingredients. 2. Cook on a skillet."
            ),
            Recipe(
                name = "Salad",
                ingredients = listOf("Lettuce", "Tomato", "Cucumber", "Olive Oil"),
                instructions = "1. Chop veggies. 2. Drizzle with olive oil."
            )
        )
    }
}
