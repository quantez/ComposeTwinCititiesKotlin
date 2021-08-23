package org.kotlinmeetupmpls

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aandtech.kotlinmeetup.R

/**
 * This shows an image clipped to a circle.
 */
@Preview
@Composable
fun Sample4() {
    Column {
        Text("Hello Kotlin Mpls ")
        Text("Hello Jetpack Compose")
        Image(
            painter = painterResource(R.drawable.wp6124196),
            contentDescription = "Don't do this for real, always localize",
            modifier = Modifier
                .height(120.dp)
                .width(120.dp)
                .clip(CircleShape),
            contentScale = ContentScale.FillHeight
        )
    }
}
