package com.example.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun MainScreen(onNavigateToSearch: () -> Unit, onNavigateToProduct: (String) -> Unit) {
    var selectedItem by remember { mutableIntStateOf(0) }
    
    val items = listOf("Home", "Categories", "Cart", "Orders", "Profile")
    val selectedIcons = listOf(Icons.Filled.Home, Icons.AutoMirrored.Filled.List, Icons.Filled.ShoppingCart, Icons.Filled.ShoppingBag, Icons.Filled.Person)
    val unselectedIcons = listOf(Icons.Outlined.Home, Icons.AutoMirrored.Outlined.List, Icons.Outlined.ShoppingCart, Icons.Outlined.ShoppingBag, Icons.Outlined.Person)

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
                                contentDescription = item
                            )
                        },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index }
                    )
                }
            }
        }
    ) { innerPadding ->
        when (selectedItem) {
            0 -> HomeScreen(modifier = Modifier.padding(innerPadding), onNavigateToSearch = onNavigateToSearch, onNavigateToProduct = onNavigateToProduct)
            1 -> CategoryScreen(modifier = Modifier.padding(innerPadding))
            2 -> CartScreen(modifier = Modifier.padding(innerPadding))
            3 -> OrdersScreen(modifier = Modifier.padding(innerPadding))
            4 -> ProfileScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}
