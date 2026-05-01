package com.example.cse3200_myblipblop.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.cse3200_myblipblop.model.Video


class VideoFeedViewModel : ViewModel() {
    // total of 16 vid - sourced from paytane, NASA Image and Video Library, Internet Archive, Imgur, GitHub Repo
    private  val _videos = MutableStateFlow<List<Video>>(
        listOf(
            // my two test videos
            Video("Test Title", "Test Description", "https://www.papytane.com/mp4/accrobra.mp4"),
            Video("Moon ", "Look at this moon", "https://images-assets.nasa.gov/video/GSFC_20110617_LRO_m10794_Eclipse_Librating_Moon/GSFC_20110617_LRO_m10794_Eclipse_Librating_Moon~medium.mp4"),

            Video("Loss Burrito", "Is this loss?", "https://wstyler.ucsd.edu/talks/memes/loss/loss_burrito.mp4"),
            Video("D U C K", "Become D U C K", "https://wstyler.ucsd.edu/talks/memes/video/duck.mp4"),
            Video("Italian Brainrot TierList", "Which brainrot is the best?", "https://dn711407.ca.archive.org/0/items/tiktok-ZP86qb32C/tiktok_tjantv_7481648393283030294.mp4"),
            Video("Sad Kitty", "What do you guys think of my painting", "https://i.imgur.com/FrZQiL0.mp4"),
            Video("The Light", "such warm light", "https://i.imgur.com/oQSS85s.mp4"),
            Video("Brr Brr Patapim VS Tung Tung Tung Sahur ", "Who wins?", "https://dn711407.ca.archive.org/0/items/tiktok-ZP86bNFrM/tiktok_fishy.ai_7485383108724886806.mp4"),
            Video("When mom uses your government name", "My kid dog", "https://i.imgur.com/sJV4jMW.mp4"),
            Video("Squid Game Cookie", "What a hard game", "https://ia800101.us.archive.org/26/items/TikTok-7553079057286515998/ssstik.io_%40imkejae_1758839880878.mp4"),
            Video("Lava Chicken in my room", "Cooking in my room", "https://dn711406.ca.archive.org/0/items/lava-chicken-in-my-room-shorts-720-ytshorts.savetube.me/lava-chicken-in-my-room-shorts-720-ytshorts.savetube.me.mp4"),
            Video("Swimming Duck", "Look what I found during my walk", "https://www.papytane.com/mp4/cygne.mp4"),
            Video("3D Saul", "Classic lawyer brainrot", "https://raw.githubusercontent.com/Dominicentek/my-meme-folder/master/3ds-saul.mp4"),
            Video("Math Truths", "Alternative mathematical theories", "https://raw.githubusercontent.com/Dominicentek/my-meme-folder/master/2-plus-2-equals-6.mp4"),
            Video("The cube has been decimated by the power of friendship", "pet fish eating", "https://i.imgur.com/HWlVCuQ.mp4"),
            Video("Easter Dinner", "Here's a sweep across a few of the things I had at Easter dinner.", "https://i.imgur.com/U3Ni1cN.mp4")
            // Video("Title", "Description", "url")
        )
    )
    private val _currentIndex = MutableStateFlow(0)

    // read only - for UI
    val observeVideos: StateFlow<List<Video>> = _videos.asStateFlow()
    val currentIndex: StateFlow<Int> = _currentIndex.asStateFlow()

    // a way to update the current index
    fun onVideoChanged(newIndex: Int) {
        _currentIndex.value = newIndex
    }

    // was also planning to use buttons to update but too much work
}