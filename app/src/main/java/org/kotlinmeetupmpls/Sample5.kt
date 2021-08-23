package org.kotlinmeetupmpls

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aandtech.kotlinmeetup.R


/**
 * This shows numeerous text parsms. Consider using Composable Themes.  Super easy and improves the
 * experience for your users:
 *    https://developer.android.com/jetpack/compose/themes?authuser=1
 *    https://developer.android.com/codelabs/jetpack-compose-theming#0
 */
@Preview
@Composable
fun Sample5() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "John Hancock",
            color = Color.Blue,
            fontSize = 18.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold
        )
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
