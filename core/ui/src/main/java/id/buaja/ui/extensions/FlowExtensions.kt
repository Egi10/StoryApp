package id.buaja.ui.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Created by Julsapargi Nursam on 04/07/22
 * Mobile Engineer - Android StoryApp
 */

/**
 * [link]
 * https://proandroiddev.com/how-to-collect-flows-lifecycle-aware-in-jetpack-compose-babd53582d0b
 * https://manuelvivo.dev/coroutines-addrepeatingjob
 * https://medium.com/tech-takeaways/how-to-safely-collect-flows-lifecycle-aware-in-jetpack-compose-a-new-approach-ed20ead25be9
 */

@Composable
fun <T> rememberFlow(
    flow: Flow<T>,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
): Flow<T> {
    return remember(key1 = flow, key2 = lifecycleOwner) { flow.flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED) }
}

@Composable
fun <T : R, R> Flow<T>.collectAsStateLifecycleAware(
    initial: R,
    context: CoroutineContext = EmptyCoroutineContext
): State<R> {
    val lifecycleAwareFlow = rememberFlow(flow = this)
    return lifecycleAwareFlow.collectAsState(initial = initial, context = context)
}

@Suppress("StateFlowValueCalledInComposition")
@Composable
fun <T> StateFlow<T>.collectAsStateLifecycleAware(
    context: CoroutineContext = EmptyCoroutineContext
): State<T> = collectAsStateLifecycleAware(value, context)

@Composable
fun <T : Any> Flow<PagingData<T>>.collectAsLazyPagingItemsLifecycleAware(): LazyPagingItems<T> {
    val lifecycleAwareFlow = rememberFlow(flow = this)

    return lifecycleAwareFlow.collectAsLazyPagingItems()
}