package org.kotlinmeetupmpls

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


/**
 * This is about as simple of a Composable as you can get.
 *
 * With the latest version of Android studio, you can use the Composable Preview.
 *
 * Requires Artic Cat version of Android Studio
 * Compose is all Kotlin, no XML!
 * Kotlin source files have the Compose Preview in Android Studio
 * The Composable Annotation is required
 * notice that this is a stand alone Kotlin view and nothing else is required to design and preview this composable
 * Composable functions are declared at the package level and not in a class, therefore they are uppercase and nouns not verbs.
 *
 *   See https://developer.android.com/jetpack/compose/tooling
 */
@Composable
fun Sample1() {
    Text("Hello Kotlin Mpls!")
}





























@Preview
@Composable
fun TitleFun() {
    Sample1a(title = "Hello Kotlin Mpls")
}

@Composable
fun Sample1a(title: String) {
    Text(title)
}




