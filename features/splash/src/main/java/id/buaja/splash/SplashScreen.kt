package id.buaja.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.delay

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

@Composable
fun SplashScreen(
    navigationToHome: () -> Unit
) {
    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(
        key1 = true,
        block = {
            scale.animateTo(
                targetValue = 0.7f,
                // Tween Animation
                animationSpec = tween(
                    durationMillis = 900,
                    easing = {
                        OvershootInterpolator(4f).getInterpolation(it)
                    })
            )

            // Customize the delay time
            delay(2000L)

            navigationToHome.invoke()
        }
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.dicoding_header_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .scale(scale.value)
        )
    }
}