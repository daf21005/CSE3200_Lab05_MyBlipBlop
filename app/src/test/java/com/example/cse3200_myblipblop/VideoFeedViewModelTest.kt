package com.example.cse3200_myblipblop

import com.example.cse3200_myblipblop.viewmodel.VideoFeedViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class VideoFeedViewModelTest {

    // the viewmodel we are testing
    private lateinit var viewModel: VideoFeedViewModel

    // runs before each test — gives us a fresh ViewModel every time
    @Before
    fun setup() {
        viewModel = VideoFeedViewModel()
    }

    // test 1 — index should start at 0
    @Test
    fun initialIndex_isZero() {
        assertEquals(0, viewModel.currentIndex.value)
    }

    // test 2 — video list should have the correct number of videos
    @Test
    fun videoList_hasCorrectSize() {
        assertEquals(16, viewModel.observeVideos.value.size) // change 6 to however many videos you have
    }

    // test 3 — onVideoChanged updates the index correctly
    @Test
    fun onVideoChanged_updatesIndex() {
        viewModel.onVideoChanged(3)
        assertEquals(3, viewModel.currentIndex.value)
    }

    // test 4 — index updates correctly multiple times
    @Test
    fun onVideoChanged_updatesIndexMultipleTimes() {
        viewModel.onVideoChanged(1)
        assertEquals(1, viewModel.currentIndex.value)
        viewModel.onVideoChanged(4)
        assertEquals(4, viewModel.currentIndex.value)
    }
}