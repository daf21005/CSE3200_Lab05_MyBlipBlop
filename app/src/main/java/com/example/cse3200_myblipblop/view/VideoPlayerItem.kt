package com.example.cse3200_myblipblop.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.common.MediaItem
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.ui.PlayerView
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.annotation.OptIn
import androidx.media3.common.util.UnstableApi
// import androidx.media3.ui.AspectRatioFrameLayout


// where exoplayer will live
@OptIn(UnstableApi::class)
@Composable
fun VideoPlayerItem(videoUrl: String, title: String, description: String, isPlaying: Boolean) {

    // initialize ExoPlayer
    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            // preparing the video (what to play -> prepare itself -> play as soon as possible)
            setMediaItem(MediaItem.fromUri(videoUrl))
            prepare()
            playWhenReady = false
            // this will allow the video to loop
            repeatMode = ExoPlayer.REPEAT_MODE_ONE
        }
    }

    // fixes the issue where some videos would start before the user get to them
    LaunchedEffect(isPlaying) {
        if (isPlaying){
            exoPlayer.play()
        } else{
            exoPlayer.pause()
            exoPlayer.seekTo(0)
        }
        // exoPlayer.playWhenReady = false
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // display the video to the screen (code from the Prof. repo) and should take up the full screen
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { PlayerView(it).apply {
                player = exoPlayer
                // player controls
                useController = true
                controllerAutoShow = false
                controllerShowTimeoutMs = 2000
                // either keep or drop
                // resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                // changes the background color (when not cropped)
                setBackgroundColor(android.graphics.Color.BLACK)
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
            },
            // force hide controls after each scroll
            update = { playerView -> playerView.hideController() }
        )

        // display the title and description on the video/screen
        Box(
            // a transparent block
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .background(Color.Black.copy(alpha = 0.55f))
                .padding(16.dp)
        ) {
            Column {
                // the title and description within the box
                Text(
                    text = title,
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    color = Color.White.copy(alpha = 0.85f),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }


    LaunchedEffect(videoUrl) {
        exoPlayer.setMediaItem(MediaItem.fromUri(videoUrl))
        exoPlayer.prepare()
    }

    // release exoplayer when finished
    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

}
