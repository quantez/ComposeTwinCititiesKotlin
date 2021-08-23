package org.kotlinmeetupmpls

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aandtech.kotlinmeetup.R

/**
* How do you allow a high level of customization without having 12, or even 20 parameters?
*     Composable functions has 3 categories of parameters (2 courtesy) of Kotlin:
*        - required parameters
*        - optional parameters with default values
*        - and this thing called Modifier that almost all composable functions have.
 *          It's like the builderpattern without the .builder() at the end.
 *          In the docs they call it Modifier chaining.
*/
@Preview
@Composable
fun Sample3() {
    Column {
        Text(text = "Hello Kotlin Mpls ")
        Text("Hello Jetpack Compose")
        Image(
            painter = painterResource(R.drawable.wp6124196),
                // content discription is required. Will accept null but please provide and localize
            contentDescription = "Don't do this for real, always localize",
            modifier = Modifier
                .height(120.dp),
            contentScale = ContentScale.FillHeight
        )
    }
}