package com.shraddha.aifiirmations

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shraddha.aifiirmations.ui.theme.DarkGray
import com.shraddha.aifiirmations.ui.theme.GlitchCyan
import com.shraddha.aifiirmations.ui.theme.HotPink
import com.shraddha.aifiirmations.ui.theme.NeonGreen
import com.shraddha.aifiirmations.ui.theme.VoidBlack
import com.shraddha.aifiirmations.ui.theme.Win95Gray

// Define your pixel font family here (ensure you have the font file in res/font)
// If you don't have the font yet, it will fallback to Monospace.
val PixelFont = FontFamily.Monospace

@Composable
fun HomeScreen(
    onAffirmMeClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = VoidBlack // From your Color.kt
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            // --- The Logo ---
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = NeonGreen)) {
                        append("AI")
                    }
                    withStyle(style = SpanStyle(color = HotPink)) {
                        append("ffirmations")
                    }
                },
                fontFamily = PixelFont, // Uses your custom font
                fontSize = 40.sp,
                lineHeight = 40.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Subtitle
            Text(
                text = "v1.0 // SYSTEM_READY",
                color = GlitchCyan,
                fontFamily = FontFamily.Monospace,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(80.dp))

            // --- The Button ---
            RetroButton(
                text = "AFFIRM ME",
                onClick = onAffirmMeClick
            )
        }
    }
}

@Composable
fun RetroButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Windows 95 Style Button
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .width(200.dp)
            .height(60.dp)
            .background(Win95Gray)
            .border(
                width = 4.dp,
                color = Color.White, // Top/Left light bevel
                shape = RectangleShape
            )
            .border(
                width = 4.dp,
                color = DarkGray, // Bottom/Right shadow
                shape = RectangleShape
            )
            .clickable { onClick() }
    ) {
        Text(
            text = text,
            fontFamily = PixelFont,
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(onAffirmMeClick = {})
}
