package com.example.kmptemplete

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InstagramProfileScreen() {
    val scrollState = rememberScrollState()
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            // Status Bar
            StatusBar()
            
            // Navigation Bar
            NavigationBar()
            
            // Profile Header
            ProfileHeader()
            
            // User Info
            UserInfoSection()

            // Follower Preview
            FollowerPreview()

            // Action Buttons
            ActionButtons()
            
            // Story Highlights
            StoryHighlights()
            
            // Tab Navigation
            TabNavigation()
            
            // Photo Grid
            PhotoGrid()
            
            // Promotional Banner
            PromotionalBanner()
            
            // Bottom spacing for navigation
            Spacer(modifier = Modifier.height(80.dp))
        }
        
        // Bottom Navigation
        BottomNavigation(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
private fun StatusBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "9:41",
            color = Color.White,
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold
        )
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Signal bars
            SignalBars()
            // WiFi icon
            Icon(
                imageVector = Icons.Default.Wifi,
                contentDescription = "WiFi",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
            // Battery icon
            BatteryIcon()
        }
    }
}

@Composable
private fun SignalBars() {
    Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
        repeat(4) { index ->
            Box(
                modifier = Modifier
                    .width(3.dp)
                    .height((4 + index * 2).dp)
                    .background(Color.White, RoundedCornerShape(1.dp))
            )
        }
    }
}

@Composable
private fun BatteryIcon() {
    Canvas(modifier = Modifier.size(24.dp, 12.dp)) {
        val strokeWidth = 1.5.dp.toPx()
        val cornerRadius = 2.dp.toPx()
        
        // Battery outline
        drawRoundRect(
            color = Color.White,
            topLeft = Offset(strokeWidth / 2, strokeWidth / 2),
            size = androidx.compose.ui.geometry.Size(
                size.width - strokeWidth - 3.dp.toPx(),
                size.height - strokeWidth
            ),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(cornerRadius),
            style = androidx.compose.ui.graphics.drawscope.Stroke(strokeWidth)
        )
        
        // Battery fill (70%)
        drawRoundRect(
            color = Color.White,
            topLeft = Offset(2.dp.toPx(), 2.dp.toPx()),
            size = androidx.compose.ui.geometry.Size(
                (size.width - 8.dp.toPx()) * 0.7f,
                size.height - 4.dp.toPx()
            ),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(1.dp.toPx())
        )
        
        // Battery tip
        drawRoundRect(
            color = Color.White.copy(alpha = 0.4f),
            topLeft = Offset(size.width - 2.dp.toPx(), size.height * 0.3f),
            size = androidx.compose.ui.geometry.Size(1.5.dp.toPx(), size.height * 0.4f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(0.5.dp.toPx())
        )
    }
}

@Composable
private fun NavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "username",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Default.VerifiedUser,
                contentDescription = "Verified",
                tint = Color(0xFF1FA1FF),
                modifier = Modifier.size(16.dp)
            )
        }
        
        Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifications",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Icon(
                imageVector = Icons.Default.MoreHoriz,
                contentDescription = "More",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
private fun ProfileHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(60.dp)
    ) {
        // Profile Avatar with Story Ring
        Box(
            modifier = Modifier.size(90.dp)
        ) {
            // Story Ring Gradient
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCircle(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFC913B9),
                            Color(0xFFF9373F),
                            Color(0xFFFECD00)
                        )
                    ),
                    radius = size.minDimension / 2,
                    style = androidx.compose.ui.graphics.drawscope.Stroke(width = 3.dp.toPx())
                )
            }
            
            // Profile Image
            Box(
                modifier = Modifier
                    .size(76.dp)
                    .align(Alignment.Center)
                    .clip(CircleShape)
                    .background(Color.Gray)
            ) {
                // Placeholder for profile image
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile",
                    tint = Color.White,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )
            }
        }
        
        // Stats
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            StatItem("1,234", "Posts")
            StatItem("5,678", "Followers")
            StatItem("9,101", "Following")
        }
    }
}

@Composable
private fun StatItem(number: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        Text(
            text = number,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = label,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun UserInfoSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp),
        verticalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        Text(
            text = "Username",
            color = Color.White,
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal
        )
        
        Text(
            text = "Category/Genre text",
            color = Color.White.copy(alpha = 0.5f),
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )
        
        Row {
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ",
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 16.sp
            )
            Text(
                text = "#hashtag",
                color = Color(0xFF004C8B),
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 16.sp
            )
        }
        
        Text(
            text = "Link goes here",
            color = Color(0xFF004C8B),
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 16.sp
        )
    }
}

@Composable
private fun FollowerPreview() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Overlapping avatars
        Box(
            modifier = Modifier.width(54.dp)
        ) {
            // Third avatar (leftmost, back)
            Box(
                modifier = Modifier
                    .size(26.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, Color.Black, CircleShape)
                    .background(Color.Gray)
                    .offset(x = 0.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Follower",
                    tint = Color.White,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                )
            }

            // Second avatar (middle)
            Box(
                modifier = Modifier
                    .size(26.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, Color.Black, CircleShape)
                    .background(Color.Gray)
                    .offset(x = 14.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Follower",
                    tint = Color.White,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                )
            }

            // First avatar (rightmost, front)
            Box(
                modifier = Modifier
                    .size(26.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, Color.Black, CircleShape)
                    .background(Color.Gray)
                    .offset(x = 28.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Follower",
                    tint = Color.White,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                )
            }
        }

        Text(
            text = "Followed by username, username\nand 100 others",
            color = Color.White,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 16.sp,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun ActionButtons() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(9.dp)
    ) {
        // Follow Button
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1FA1FF)),
            shape = RoundedCornerShape(3.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        ) {
            Text(
                text = "Follow",
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }
        
        // Secondary Buttons Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            SecondaryButton("Message", modifier = Modifier.weight(1f))
            SecondaryButton("Subscribe", modifier = Modifier.weight(1f))
            SecondaryButton("Contact", modifier = Modifier.weight(1f))
            
            // More options button
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(
                        Color.White.copy(alpha = 0.2f),
                        RoundedCornerShape(3.dp)
                    )
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "More",
                    tint = Color.White,
                    modifier = Modifier.size(14.dp)
                )
            }
        }
    }
}

@Composable
private fun SecondaryButton(
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White.copy(alpha = 0.2f)
        ),
        shape = RoundedCornerShape(3.dp),
        modifier = modifier.height(30.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun StoryHighlights() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 9.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        repeat(5) { index ->
            StoryHighlightItem("Text here")
        }
    }
}

@Composable
private fun StoryHighlightItem(label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .border(1.dp, Color.Gray, CircleShape)
        ) {
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .align(Alignment.Center)
                    .clip(CircleShape)
                    .background(Color.Gray)
            ) {
                Icon(
                    imageVector = Icons.Default.Image,
                    contentDescription = "Story",
                    tint = Color.White,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )
            }
        }
        
        Text(
            text = label,
            color = Color.White,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun TabNavigation() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(top = 10.dp)
    ) {
        TabItem("Grid", true, modifier = Modifier.weight(1f))
        TabItem("Reels", false, modifier = Modifier.weight(1f))
        TabItem("Mentions", false, modifier = Modifier.weight(1f))
    }
}

@Composable
private fun TabItem(
    name: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 53.dp, vertical = 7.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = when (name) {
                "Grid" -> Icons.Default.GridView
                "Reels" -> Icons.Default.VideoLibrary
                else -> Icons.Default.AlternateEmail
            },
            contentDescription = name,
            tint = if (isSelected) Color.White else Color.Gray,
            modifier = Modifier.size(24.dp)
        )
        
        if (isSelected) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.White)
                    .padding(top = 8.dp)
            )
        }
    }
}

@Composable
private fun PhotoGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(1.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp),
        horizontalArrangement = Arrangement.spacedBy(1.dp),
        modifier = Modifier.height(400.dp)
    ) {
        items(15) { index ->
            PhotoGridItem(index)
        }
    }
}

@Composable
private fun PhotoGridItem(index: Int) {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .background(Color.Gray)
    ) {
        // Placeholder image
        Icon(
            imageVector = Icons.Default.Image,
            contentDescription = "Post",
            tint = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
        
        // Indicators for reels/carousel
        if (index % 3 == 1) {
            // Reels indicator
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Reel",
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .size(12.dp)
            )
        } else if (index % 4 == 2) {
            // Carousel indicator
            Icon(
                imageVector = Icons.Default.ViewCarousel,
                contentDescription = "Carousel",
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .size(12.dp)
            )
        }
    }
}

@Composable
private fun PromotionalBanner() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 8.dp)
            .background(
                Color(0xFFB8CCB5),
                RoundedCornerShape(8.dp)
            )
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Promo Image
        Box(
            modifier = Modifier
                .size(33.dp)
                .background(Color.Black, RoundedCornerShape(4.dp))
        ) {
            Icon(
                imageVector = Icons.Default.Pets,
                contentDescription = "Promo",
                tint = Color.White,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp)
            )
        }
        
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Text(
                text = "Shop Now",
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Go to www.websitehere.com",
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )
        }
        
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "Go",
            tint = Color.Black,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
private fun BottomNavigation(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Color.Black
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Icon(
                imageVector = Icons.Default.VideoLibrary,
                contentDescription = "Reels",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Icon(
                imageVector = Icons.Default.ShoppingBag,
                contentDescription = "Shop",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            
            // Profile avatar with notification dot
            Box {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        tint = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(4.dp)
                    )
                }
                
                // Notification dot
                Box(
                    modifier = Modifier
                        .size(4.dp)
                        .background(Color.Red, CircleShape)
                        .align(Alignment.TopEnd)
                )
            }
        }
    }
}

@Preview
@Composable
fun InstagramProfileScreenPreview() {
    InstagramProfileScreen()
}
