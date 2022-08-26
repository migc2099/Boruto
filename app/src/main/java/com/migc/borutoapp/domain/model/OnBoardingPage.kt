package com.migc.borutoapp.domain.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.resolveDefaults
import com.migc.borutoapp.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First : OnBoardingPage(
        image = R.drawable.greetings,
        title = "Greetings",
        description = "Are you a Boruto fan? Because if you are then we have great news for you!"
    )

    object Second : OnBoardingPage(
        image = R.drawable.explore,
        title = "Greetings",
        description = "Find your favorite heroes and learn some of the things that you didn't know about."
    )

    object Third : OnBoardingPage(
        image = R.drawable.power,
        title = "Greetings",
        description = "Check out your hero's power and see how much are they strong comparing to others."
    )
}
