# Instagram Profile UI - Kotlin Multiplatform Compose

This project contains a pixel-perfect recreation of an Instagram profile screen using Kotlin Multiplatform Compose, based on a Figma design.

## Features

✅ **Complete Instagram Profile UI** including:
- iOS-style status bar with time, signal bars, WiFi, and battery indicators
- Navigation bar with back button, username with verified badge, notifications, and more menu
- Profile header with gradient story ring around avatar and user stats
- User information section with bio, hashtags, and links
- Follower preview with overlapping avatars
- Action buttons (Follow, Message, Subscribe, Contact, More options)
- Story highlights section with circular story previews
- Tab navigation (Grid view, Reels, Mentions)
- Photo grid with posts, reels indicators, and carousel indicators
- Promotional banner with shop call-to-action
- Bottom navigation bar with profile notification dot

## Components

The UI is built with the following main composable functions:

- `InstagramProfileScreen()` - Main screen container
- `StatusBar()` - iOS-style status bar
- `NavigationBar()` - Top navigation with username and controls
- `ProfileHeader()` - Profile avatar with story ring and stats
- `UserInfoSection()` - Username, bio, hashtags, and links
- `FollowerPreview()` - Overlapping follower avatars
- `ActionButtons()` - Follow and secondary action buttons
- `StoryHighlights()` - Circular story highlight items
- `TabNavigation()` - Grid/Reels/Mentions tabs
- `PhotoGrid()` - 3-column grid of posts with indicators
- `PromotionalBanner()` - Bottom promotional banner
- `BottomNavigation()` - Bottom nav bar

## Design Fidelity

This implementation closely matches the original Figma design with:

- **Accurate Colors**: Black background (#000), blue follow button (#1FA1FF), verified badge color
- **Proper Typography**: SF Pro fonts with correct sizes and weights
- **Responsive Layout**: Uses Compose's flexible layout system
- **Visual Indicators**: Reels play icons, carousel multi-item indicators
- **Interactive Elements**: Proper button styling and clickable areas
- **Spacing**: Accurate padding and margins matching the design

## How to Run

1. Open the project in Android Studio or IntelliJ IDEA
2. Make sure you have the Kotlin Multiplatform plugin installed
3. Sync the project with Gradle files
4. Run on Android device/emulator or build for other supported platforms

## Project Structure

```
composeApp/src/androidMain/kotlin/com/example/kmptemplete/
├── MainActivity.kt                    # Main Android activity
├── App.kt                            # App composable entry point
├── InstagramProfileScreen.kt         # Complete Instagram UI implementation
├── Platform.kt                       # Platform-specific code
└── Greeting.kt                       # Sample greeting class
```

## Technologies Used

- **Kotlin Multiplatform** - Cross-platform development
- **Jetpack Compose** - Modern Android UI toolkit
- **Material 3** - Design system components
- **Canvas API** - Custom drawing for icons and indicators

## Customization

To customize the UI for your own use:

1. Replace placeholder icons with actual images using `AsyncImage` or `Image` composables
2. Update user data (username, follower count, etc.) with real data
3. Add click handlers to buttons and navigation items
4. Implement actual photo loading for the grid
5. Connect to real Instagram API or your own backend

## Notes

- This is a static UI implementation - no actual Instagram API integration
- Uses Material Icons as placeholders for images
- Designed primarily for Android but can be adapted for other KMP targets
- Includes proper state management structure for future enhancements

---

Created based on Figma design specification for pixel-perfect Instagram profile recreation.
