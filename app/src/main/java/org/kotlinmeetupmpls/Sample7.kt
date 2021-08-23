package org.kotlinmeetupmpls

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import androidx.constraintlayout.compose.ConstraintLayout
import com.aandtech.kotlinmeetup.R

/**
 * Note, The compose view will not show the ConstraintLayout (too complicater).  However, it you hit
 * the "Display Preview" it will create am app scaffolding and show it on your emulator/device.
 *
 * See https://developer.android.com/jetpack/compose/tooling#preview-deploy
 *
 * This shows the Constraint Layout based on the XML View version.  Note that instead of view ID's,
 * you create createRefs().  Think of these as the view IDs "Display Preview" button in the Compose
 * Preview, it will show the
 *
 *  val (
 *      titleText,
 *      secondaryText,
 *      icon
 * ) = createRefs()
 *
 * This part in each Cmoposable, should look familiar:
 *
 *  modifier = Modifier
 *     .constrainAs(titleText) {
 *        top.linkTo(icon.top, margin = 8.dp)
 *        start.linkTo(icon.end, margin = 16.dp)
 *     }
 */

@Preview
@Composable
fun Sample7() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(450.dp)
    ) {
        val (
            titleText,
            secondaryText,
            icon
        ) = createRefs()

        Image(
            painter = painterResource(R.drawable.wp6124196),
            contentDescription = "Don't do this for real, always localize",
            modifier = Modifier
                .height(64.dp)
                .width(64.dp)
                .clip(CircleShape)
                .constrainAs(icon) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                },
            contentScale = ContentScale.FillHeight
        )
        Text(
            text = "John Hancock",
            color = Color.Blue,
            fontSize = 18.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .constrainAs(titleText) {
                    top.linkTo(icon.top, margin = 8.dp)
                    start.linkTo(icon.end, margin = 16.dp)
                }
        )
        Text(
            text = "Hello Jetpack Compose",
            modifier = Modifier
                .constrainAs(secondaryText) {
                    bottom.linkTo(icon.bottom, margin = 8.dp)
                    start.linkTo(icon.end, margin = 16.dp)
                }

        )
    }
}
