package org.kotlinmeetupmpls

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val imageViewModel = ViewModelProvider(this).get(ImageViewModel::class.java)

        setContent {
            // Uncomment these this lines below for the example that shows what happens with a
            // Composable with no state.  Since the callback "onValueChange"
            // doesn't do anything, it does update the field with the text you are typing.
//            HelloContentBroken()

            // Uncomment this line to show how state is a Composable works.
//            HelloContent()

            // Uncomment these two lines below for the example that simulates a retorfit
            // response that arrives asynchroniously.
            val imageViewModel = ViewModelProvider(this).get(ImageViewModel::class.java)
            imageViewModel.fetchImageSet()
            ImageDisplayer(imageViewModel.imageUpdate)
        }
    }
}

// This is broken since Composoable don't hold any state
@Composable
fun HelloContentBroken() {
    Column(modifier = Modifier.padding(16.dp)) {
        // This is the EditTest equivalent
        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text("Name") }
        )
    }
}

/* This is based on the code shown in https://developer.android.com/jetpack/compose/state
 *
 *  Set breakpoints on these lines for the following 2 functions:
 *          // Note that this is called for the inital composition and for recompistion when
 *          Column(modifier = Modifier.padding(16.dp)) {
 *
 *          name.value = changedText
 *
 *          // this is called when you type a letter
 *          textChangedHandler(it)

 *
 */
@Composable
fun HelloContent() {
    var name = remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp)) {
        HelloTextContent(name.value) { changedText ->
            name.value = changedText
        }
    }
}

/**
 * This shows a simple exmaple of unidirectional data floe
 * https://developer.android.com/jetpack/compose/architecture?authuser=1#udf
 * This shows the data down (the name Sting) and event up (the text change handler)
 */
@Composable
fun HelloTextContent(
    name: String,
    textChangedHandler: (changedText: String) -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {

        // This is the equivalent to a TextView in XML View land
        if (name.isNotEmpty()) {
            Text(
                text = "Hello, ${name}!",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h5
            )
        }

        // This is the EditText equivalent
        OutlinedTextField(
            value = name,
            onValueChange = {
                textChangedHandler(it)
            },
            label = { Text("Name") }
        )
    }
}

// This example simulates the case where the data is obtained from a network call. These the inital
// conmposition occurs from the Activity's onCreate call and the recomposition occurs when the
//  imageViewModel.fetchImageSet() sets the value in its function fetchImageSet()
//     imageUpdate.value = images
//
// This causes a recomposition in function ImageDisplayer() starting from the line
//   val images = imageUpdate.value
//
// Set breakpoints on the lines:
//      LazyColumn() {  // only calls this during composition not recomposition
//
//      imageUpdate.value = images  // called when the simulated network call completes
//
//      itemsIndexed(images) { index, image -> // called for both composition and recomposition

@Composable
fun ImageDisplayer(imageUpdate: MutableState<List<Int>>) {
    LazyColumn() {
        val images = imageUpdate.value
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


