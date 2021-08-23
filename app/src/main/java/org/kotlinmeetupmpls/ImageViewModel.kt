package org.kotlinmeetupmpls

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aandtech.kotlinmeetup.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ImageViewModel: ViewModel() {
    // This is how we commmunicate with the Composable A MutableState can only be used inside of
    // a composable (at least the observing part).
    val imageUpdate: MutableState<List<Int>> = mutableStateOf(listOf())

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

    // This is simulating a callback from Rest retrofit call
    fun fetchImageSet() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(10_000L)  // if a rest endpoint takes 10 seconds we're in trouble
            imageUpdate.value = images
        }
    }

}