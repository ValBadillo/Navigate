package com.example.navigate.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.navigate.components.MainButton
import com.example.navigate.components.MainIconButton
import com.example.navigate.components.Space
import com.example.navigate.components.TitleBar
import com.example.navigate.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewView(navController: NavController, id: Int) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "New View") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Magenta
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) { paddingValues ->
        ContentNewView(navController, id, paddingValues)
    }
}


@Composable
fun ContentNewView(navController: NavController, id: Int, paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "New View")
        Space()
        TitleView(name = "ID: $id")
        Space()
        MainButton(name = "Go to Home", backColor = Color.Blue, color = Color.White) {
            navController.navigate("Home")
        }
    }
}
