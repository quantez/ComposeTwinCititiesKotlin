package org.kotlinmeetupmpls

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

/**
 * This adds the Column Composable, think vertical linear Layout.
 */
@Preview
@Composable
fun Sample2() {
    Column {
        Text("Hello Kotlin Mpls")
        Text("Hello Jetpack Compose")
    }
}
