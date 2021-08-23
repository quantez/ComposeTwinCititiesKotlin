package org.kotlinmeetupmpls

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aandtech.kotlinmeetup.R

/**
 * This is the equalivent of the Recyvler View from XML Views but no Adaptor or Holder Pattern
 * requireed.
 *
 * Again use the "Display Preview", the "Compose Preview" just shows the first 3 items in the
 * LazyColumn.
 *
 * See https://developer.android.com/jetpack/compose/tooling#preview-deploy
 *
 * See https://developer.android.com/jetpack/compose/lists
 */
@Preview
@Composable
fun Sample8() {
    val images = listOf(
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
        R.drawable.image10,
        R.drawable.image11,
        R.drawable.image12,
        R.drawable.image1,
        R.drawable.image2,
    )

    LazyColumn {
        itemsIndexed(images) { index, image ->
            Image(
                painter = painterResource(image),
                contentDescription = "Don't do this for real, always localize",
                modifier = Modifier
                    .height(300.dp)
                    .width(400.dp),
            )
        }
    }
}
