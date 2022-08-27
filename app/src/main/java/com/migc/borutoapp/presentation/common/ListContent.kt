package com.migc.borutoapp.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.migc.borutoapp.R
import com.migc.borutoapp.domain.model.Hero
import com.migc.borutoapp.navigation.Screen
import com.migc.borutoapp.presentation.components.RatingWidget
import com.migc.borutoapp.ui.theme.*
import com.migc.borutoapp.utils.Constants.BASE_URL

@Composable
fun ListContent(
    heroes: LazyPagingItems<Hero>,
    navHostController: NavHostController
) {

}

@Composable
fun HeroItem(
    hero: Hero,
    navHostController: NavHostController
) {
    val painter = rememberAsyncImagePainter("$BASE_URL${hero.image}")

    Box(
        modifier = Modifier
            .height(HERO_ITEM_HEIGHT)
            .clickable {
                navHostController.navigate(Screen.Details.passHeroId(heroId = hero.id))
            },
        contentAlignment = Alignment.BottomStart
    ) {
        Surface(shape = Shapes.large) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("")
                    .placeholder(R.drawable.ic_placeholder)
                    .error(R.drawable.ic_placeholder)
                    .build(),
                contentDescription = stringResource(R.string.heor_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Surface(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            color = Color.Black.copy(alpha = ContentAlpha.medium),
            shape = RoundedCornerShape(bottomStart = LARGE_PADDING, bottomEnd = LARGE_PADDING)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = MEDIUM_PADDING)
            ) {
                Text(
                    text = hero.name,
                    color = MaterialTheme.colors.topAppBarContentColor,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = hero.about,
                    color = Color.White.copy(alpha = ContentAlpha.medium),
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier.padding(top = SMALL_PADDING),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RatingWidget(modifier = Modifier.padding(end = SMALL_PADDING), rating = hero.rating)
                    Text(
                        text = "(${hero.rating}",
                        textAlign = TextAlign.Center,
                        color = Color.White.copy(alpha = ContentAlpha.medium)
                    )
                }
            }
        }
    }
}


@Composable
@Preview
fun HeroItemPreview() {
    HeroItem(
        hero = Hero(
            id = 1,
            name = "Sasuke",
            image = "",
            about = "Random about",
            rating = 4.5,
            power = 100,
            month = "",
            day = "",
            family = emptyList(),
            abilities = emptyList(),
            natureTypes = emptyList()
        ),
        navHostController = rememberNavController()
    )
}