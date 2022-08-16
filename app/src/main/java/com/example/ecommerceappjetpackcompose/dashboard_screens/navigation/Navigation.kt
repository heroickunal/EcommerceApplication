package com.example.ecommerceappjetpackcompose.dashboard_screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecommerceappjetpackcompose.dashboard_screens.screens.AddToCartScreen
import com.example.ecommerceappjetpackcompose.dashboard_screens.screens.ProductDetailsScreen
import com.example.ecommerceappjetpackcompose.dashboard_screens.tab_screens.Dashboard

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(Screen.HomeScreen.route) {
            Dashboard()
        }
        composable(Screen.ProductDetailsScreen.route) {
            ProductDetailsScreen()
        }
        composable(Screen.AddToCartScreen.route) {
            AddToCartScreen()
        }
    }
}