package com.example.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ui.theme.MyApplicationTheme

@Composable
fun CircleBazarApp() {
    MyApplicationTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = androidx.compose.ui.graphics.Color.White) {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main") {
                composable("main") {
                    MainScreen(onNavigateToSearch = { navController.navigate("search") }, onNavigateToProduct = { navController.navigate("product/$it") })
                }
                composable("search") {
                    SearchScreen(onNavigateBack = { navController.popBackStack() }, onNavigateToProduct = { navController.navigate("product/$it") })
                }
                composable("product/{productId}") { backStackEntry ->
                    val productId = backStackEntry.arguments?.getString("productId") ?: "1"
                    ProductDetailScreen(productId = productId, onNavigateBack = { navController.popBackStack() })
                }
            }
        }
    }
}
