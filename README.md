# CSE3200 Lab05 MyBlipBlop App
A TikTok-inspired short video feed app built for Android using Jetpack Compose and Media3 ExoPlayer.

## Features
- **Vertical swipe feed** - swipe up/down between videos using `VerticalPager`
- **Auto-play** - videos play automatically when scrolled into view
- **Tap to show controls** - playback controls are hidden by default and appear on tap
- **Video overlay** - each video displays its title and description in a semi-transparent overlay at the bottom of the screen
- **Portrait lock** - app stay in portrait mode regardless of device orientation
 
## Video Sources
The videos are hardcoded into the app and sourced from:  
- [paytane](https://www.papytane.com/mp4/)
- [Nasa Image and Video Library](https://images.nasa.gov/)
- [Internet Archive](https://archive.org/)
- [Imgur](https://imgur.com/)
- [my-meme-folder](https://github.com/Dominicentek/my-meme-folder) (by Dominicentek)

## Getting Started
 
### Prerequisites
- Android Studio (latest stable)
- Android device or emulator running API 24+
- Internet connection (videos stream from URLs)  
  
### Running the App
1. Clone the repository
```bash
git clone https://github.com/daf21005/CSE3200_Lab05_MyBlipBlop.git
```
2. Open the project in Android Studio
3. Let Gradle sync complete
4. Run on an emulator or physical device
