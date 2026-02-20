package com.shraddha.aifiirmations

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shraddha.aifiirmations.ui.theme.DarkGray
import com.shraddha.aifiirmations.ui.theme.GlitchCyan
import com.shraddha.aifiirmations.ui.theme.NeonGreen
import com.shraddha.aifiirmations.ui.theme.VoidBlack
import com.shraddha.aifiirmations.ui.theme.Win95Gray

@Composable
fun AffirmationScreen(
    affirmation: Affirmation,
    onHomeClick: () -> Unit,
    onNextClick: () -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = VoidBlack // Deep black background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp), // More padding for a "framed" look
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // --- Top Bar ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Pixelated "Back" Button
                IconButton(onClick = onHomeClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = GlitchCyan,
                        modifier = Modifier.size(32.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "ID: ${affirmation.id}",
                    color = DarkGray,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // --- THE MONITOR (Image Container) ---
            // We use a Box to create the "Bezel" of the monitor
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f) // Keep it square
                    .background(DarkGray) // The monitor casing
                    .border(4.dp, Win95Gray, RectangleShape) // Outer bevel
                    .padding(16.dp) // The bezel thickness
                    .background(Color.Black) // The screen itself
            ) {
                Image(
                    painter = painterResource(id = affirmation.imageResourceId),
                    contentDescription = "Affirmation Image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // --- THE TERMINAL (Text Container) ---
            // A styled box for the text
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(2.dp, NeonGreen, RectangleShape)
                    .background(Color.Black.copy(alpha = 0.8f))
                    .padding(16.dp)
            ) {
                Text(
                    text = "root@user:~$ execute_affirmation",
                    color = DarkGray,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "> ${affirmation.text}",
                    color = NeonGreen,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                // Blinking cursor effect (static for now)
                Text(
                    text = "_",
                    color = NeonGreen,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // --- Bottom Button ---
            WideRetroButton(
                text = "AFFIRM ME AGAIN",
                onClick = onNextClick
            )
        }
    }
}

@Composable
fun WideRetroButton(
    text: String,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Win95Gray)
            .border(4.dp, Color.White, RectangleShape) // Top/Left highlight
            .border(4.dp, DarkGray, RectangleShape) // Bottom/Right shadow
            .clickable { onClick() }
    ) {
        Text(
            text = text,
            fontFamily = FontFamily.Monospace, // Or PixelFont
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

// --- Preview ---
@Preview
@Composable
fun AffirmationScreenPreview() {
    // Fake data for preview
    val sampleAffirmation = Affirmation(
        id = 1,
        text = "Stop the stress and let the algorithm guess.",
        imageResourceId = R.drawable.affirmation_1 // Ensure this image exists!
    )

    AffirmationScreen(
        affirmation = sampleAffirmation,
        onHomeClick = {},
        onNextClick = {}
    )
}