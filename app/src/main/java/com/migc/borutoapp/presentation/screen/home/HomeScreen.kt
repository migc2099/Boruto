package com.migc.borutoapp.presentation.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.migc.borutoapp.presentation.common.ListContent
import com.migc.borutoapp.presentation.components.RatingWidget
import com.migc.borutoapp.ui.theme.LARGE_PADDING

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClick = {})
        },
        content = {
            ListContent(
                heroes = allHeroes,
                navHostController = navHostController
            )
        }
    )
}