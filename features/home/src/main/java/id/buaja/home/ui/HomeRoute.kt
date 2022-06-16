package id.buaja.home.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import id.buaja.home.navigation.HOME_DESTINATION
import id.buaja.home.navigation.HomeDestination

/**
 * Created by Julsapargi Nursam on 16/06/22
 * Mobile Engineer - Android
 */

@Composable
fun HomeRoute(
    onSelectedNavigation: (String) -> Unit,
    selectedItem: String,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                onNavigateHomeDestination = {
                    onSelectedNavigation.invoke(it.route)
                },
                selectedItem = selectedItem
            )
        },
        content = content
    )
}

@Composable
fun BottomNavigationBar(
    onNavigateHomeDestination: (HomeDestination) -> Unit,
    selectedItem: String
) {

    BottomNavigation(
        content = {
            HOME_DESTINATION.forEach { destination ->
                val selected = selectedItem == destination.route

                BottomNavigationItem(
                    selected = selected,
                    onClick = {
                        onNavigateHomeDestination.invoke(destination)
                    },
                    icon = {
                        Icon(
                            imageVector = if (selected) {
                                destination.selectedIcon
                            } else {
                                destination.unselectedIcon
                            },
                            contentDescription = null
                        )
                    }
                )
            }
        }
    )
}