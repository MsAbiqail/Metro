package com.abby.metro.ui.theme.screens.dashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(
    navController: NavHostController
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val currentRoute = navController.currentDestination?.route

    ModalDrawer(
//        drawerState = drawerState,
        drawerContent = {
            DrawerContent(navController = navController, closeDrawer = { scope.launch { drawerState.close() } })
        },
        content = {
            Column {
                TopAppBar(
                    title = { Text(text = "Navigation Drawer Sample") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                if (drawerState.isClosed) drawerState.open() else drawerState.close()
                            }
                        }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    }
                )
                NavHost(navController = navController, startDestination = "screen1") {
                    composable("screen1") { ScreenContent("Screen 1") }
                    composable("screen2") { ScreenContent("Screen 2") }
                    composable("screen3") { ScreenContent("Screen 3") }
                }
            }
        }
    )
}

@Composable
fun DrawerContent(
    navController: NavHostController,
    closeDrawer: () -> Unit
) {
    Column(modifier = Modifier.padding(start = 16.dp, top = 48.dp)) {
        DrawerItem("Screen 1", Icons.Filled.Home) {
            navController.navigate("screen1") { popUpTo(navController.graph.startDestinationId) { inclusive = true } }
            closeDrawer()
        }
        DrawerItem("Screen 2", Icons.Filled.Search) {
            navController.navigate("screen2") { popUpTo(navController.graph.startDestinationId) { inclusive = true } }
            closeDrawer()
        }
        DrawerItem("Screen 3", Icons.Filled.Person) {
            navController.navigate("screen3") { popUpTo(navController.graph.startDestinationId) { inclusive = true } }
            closeDrawer()
        }
    }
}

@Composable
fun DrawerItem(
    label: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick)
    ) {
        Icon(icon, contentDescription = null)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = label)
    }
}

@Composable
fun ScreenContent(title: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineSmall)
    }
}

@Preview
@Composable
fun PreviewNavigationDrawer() {
    Surface {
        val navController = rememberNavController()
        NavigationDrawer(navController)
    }
}
