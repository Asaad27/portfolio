package ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp



var JetbrainsMono: FontFamily? = null

val Typography by lazy {
    Typography(
        titleLarge = TextStyle(
            fontFamily = JetbrainsMono,
            fontSize = 96.sp,
            fontWeight = FontWeight.Light,
            lineHeight = 117.sp,
            letterSpacing = (-1.5).sp,
            ),
        titleMedium = TextStyle(
            fontFamily = JetbrainsMono,
            fontSize = 60.sp,
            fontWeight = FontWeight.Light,
            lineHeight = 73.sp,
            letterSpacing = (-0.5).sp
        ),
        titleSmall = TextStyle(
            fontFamily = JetbrainsMono,
            fontSize = 48.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 59.sp
        ),
        headlineLarge = TextStyle(
            fontFamily = JetbrainsMono,
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 37.sp
        ),
        headlineMedium = TextStyle(
            fontFamily = JetbrainsMono,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 29.sp
        ),
        headlineSmall = TextStyle(
            fontFamily = JetbrainsMono,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 24.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = JetbrainsMono,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 24.sp,
            letterSpacing = 0.15.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = JetbrainsMono,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 28.sp,
            letterSpacing = 0.15.sp
        ),
        bodySmall = TextStyle(
            fontFamily = JetbrainsMono,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp
        ),
    )
}