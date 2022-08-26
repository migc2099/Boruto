package com.migc.borutoapp.presentation.screen.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            HomeTopBar(onSearchClick = {})
        }
    ) {

    }
}