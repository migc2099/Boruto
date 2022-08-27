package com.migc.borutoapp.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.migc.borutoapp.R
import com.migc.borutoapp.ui.theme.StartColor

@Composable
fun RatingWidget(
    modifier: Modifier,
    rating: Double,
    scaleFactor: Float = 3f
) {

    val startPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(pathData = startPathString).toPath()
    }
    val startPathBounds = remember {
        starPath.getBounds()
    }

    FillerStar(
        starPath = starPath,
        starPathBounds = startPathBounds,
        scaleFactor = scaleFactor
    )

}

@Composable
fun FillerStar(
    starPath: Path,
    starPathBounds: Rect,
    scaleFactor: Float
) {
    Canvas(modifier = Modifier.size(24.dp)) {
        scale(scale = scaleFactor) {
            val canvasSize = size
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)

            translate(
                left = left,
                top = top
            ) {
                drawPath(
                    path = starPath,
                    color = StartColor
                )
            }
        }
    }
}

@Composable
fun HalfFilledStar(
    starPath: Path,
    starPathBounds: Rect,
    scaleFactor: Float
) {
    Canvas(modifier = Modifier.size(24.dp)) {
        scale(scale = scaleFactor) {
            val canvasSize = size
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)

            translate(
                left = left,
                top = top
            ) {
                drawPath(
                    path = starPath,
                    color = Color.LightGray.copy(alpha = 0.5f)
                )
                clipPath(path = starPath) {
                    drawRect(
                        color = StartColor,
                        size = Size(
                            width = starPathBounds.maxDimension / 1.7f,
                            height = starPathBounds.maxDimension * scaleFactor
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun EmptyStar(
    starPath: Path,
    starPathBounds: Rect,
    scaleFactor: Float
) {
    Canvas(modifier = Modifier.size(24.dp)) {
        scale(scale = scaleFactor) {
            val canvasSize = size
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)

            translate(
                left = left,
                top = top
            ) {
                drawPath(
                    path = starPath,
                    color = Color.LightGray.copy(0.5f)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun FillerStarPreview() {
    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(pathData = starPathString).toPath()
    }
    val starPathBounds = remember {
        starPath.getBounds()
    }
    FillerStar(starPath = starPath, starPathBounds = starPathBounds, scaleFactor = 3f)
}

@Composable
@Preview(showBackground = true)
fun HalfFilledStarPreview() {
    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(pathData = starPathString).toPath()
    }
    val starPathBounds = remember {
        starPath.getBounds()
    }
    HalfFilledStar(starPath = starPath, starPathBounds = starPathBounds, scaleFactor = 3f)
}

@Composable
@Preview(showBackground = true)
fun EmptyStarPreview() {
    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(pathData = starPathString).toPath()
    }
    val starPathBounds = remember {
        starPath.getBounds()
    }
    EmptyStar(starPath = starPath, starPathBounds = starPathBounds, scaleFactor = 3f)
}