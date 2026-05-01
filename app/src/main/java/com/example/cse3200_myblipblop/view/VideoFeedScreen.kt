package com.example.cse3200_myblipblop.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cse3200_myblipblop.viewmodel.VideoFeedViewModel

// this is where the whole swiping like TikTok feature comes in
@Composable
fun VideoFeedScreen() {
    val viewModel: VideoFeedViewModel = viewModel()
    // observe the state — recomposes when data changes
    val videos by viewModel.observeVideos.collectAsState()
    val currentIndex by viewModel.currentIndex.collectAsState()

    // using VerticalPager for the swiping feature
    // tracks which page is displayed
    val pagerState = rememberPagerState( pageCount = { videos.size } )

    // update the current index
    LaunchedEffect(pagerState.currentPage) {
        viewModel.onVideoChanged(pagerState.currentPage)
    }

    // TikTok swiping behavior
    VerticalPager(state = pagerState, modifier = Modifier.fillMaxSize()) { page ->
        VideoPlayerItem(
            videoUrl = videos[page].url,
            title = videos[page].title,
            description = videos[page].description,
            isPlaying = (page == pagerState.currentPage)
        )
    }
}