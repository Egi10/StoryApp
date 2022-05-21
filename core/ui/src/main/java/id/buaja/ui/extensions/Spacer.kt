package id.buaja.ui.extensions

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

@Composable
fun RowScope.Space(width: Dp) {
    Spacer(modifier = Modifier.width(width))
}

@Composable
fun ColumnScope.Space(height: Dp) {
    Spacer(modifier = Modifier.height(height))
}


@Composable
fun LazyItemScope.Space(size: Dp) {
    Spacer(modifier = Modifier.size(size))
}