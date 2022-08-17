package com.example.ecommerceappjetpackcompose.dashboard_screens

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ecommerceappjetpackcompose.R
import com.example.ecommerceappjetpackcompose.dashboard_screens.tab_screens.AddToCartScreen
import com.example.ecommerceappjetpackcompose.dashboard_screens.tab_screens.FavoriteScreen
import com.example.ecommerceappjetpackcompose.dashboard_screens.tab_screens.HomeScreen
import com.example.ecommerceappjetpackcompose.dashboard_screens.viewmodel.SharedViewModel
import com.example.ecommerceappjetpackcompose.ui.theme.orange

@Composable
fun Dashboard(navController: NavHostController, viewModel: SharedViewModel) {
    val sectionState = remember { mutableStateOf(DashboardSection.Home) }
    val navItems = DashboardSection.values().toList()


    Scaffold(
        bottomBar = {
            BottomBar(
                items = navItems,
                currentSection = sectionState.value,
                onSectionSelected = { sectionState.value = it },
            )
        }) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        Crossfade(
            modifier = modifier,
            targetState = sectionState.value
        )
        { section ->
            when (section) {
                DashboardSection.Home -> HomeScreen(navController,viewModel)
                DashboardSection.ShoppingCart -> AddToCartScreen(navController, viewModel)
                DashboardSection.CartDetails -> FavoriteScreen(navController, viewModel)
            }
        }
    }
}

@Composable
private fun BottomBar(
    items: List<DashboardSection>,
    currentSection: DashboardSection,
    onSectionSelected: (DashboardSection) -> Unit,
) {
    BottomNavigation(
        modifier = Modifier.height(50.dp),
        backgroundColor = MaterialTheme.colors.background,
        contentColor = contentColorFor(MaterialTheme.colors.background)
    ) {
        items.forEach { section ->

            val selected = section == currentSection

            val iconRes = if (selected) section.selectedIcon else section.icon

            BottomNavigationItem(
                icon = {

                    Icon(
                        painter = painterResource(id = iconRes),
                        modifier = Modifier.size(24.dp),
                        contentDescription = "Bottom nav icons"
                    )
                },
                selected = selected,
                unselectedContentColor = Color.Gray,
                selectedContentColor = orange,
                onClick = { onSectionSelected(section) },
                alwaysShowLabel = false
            )
        }
    }
}

private enum class DashboardSection(
    val icon: Int,
    val selectedIcon: Int,
) {
    Home(R.drawable.ic_baseline_home_24, R.drawable.ic_baseline_home_24),
    ShoppingCart(R.drawable.ic_baseline_shopping_cart_24, R.drawable.ic_baseline_shopping_cart_24),
    CartDetails(
        R.drawable.ic_baseline_favorite_border_24,
        R.drawable.ic_baseline_favorite_border_24
    ),
}