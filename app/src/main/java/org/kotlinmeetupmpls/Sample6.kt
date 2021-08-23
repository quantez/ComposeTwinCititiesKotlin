package org.kotlinmeetupmpls

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

/**
 * This retrivies an image "over the wire": URL.  This uses coil.  Glide version (accompanist)
 * available.
 */

@Preview
@Composable
fun Sample6() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "John Hancock",
            color = Color.Yellow,
            fontSize = 18.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Hello Jetpack Compose",
            color = Color.Green
        )
        Image(
            painter = rememberImagePainter(
                data = "https://picsum.photos/id/237/300/300",
            ),
            contentDescription ="Don't do this for real, always localize",
            modifier = Modifier
                .height(120.dp)
                .width(120.dp),
            contentScale = ContentScale.FillHeight
        )
    }
}
