package id.buaja.add_new_story.data.source

import android.content.Context
import android.graphics.Bitmap
import dagger.hilt.android.qualifiers.ApplicationContext
import id.buaja.add_new_story.data.source.routes.StoryService
import id.buaja.common.di.DefaultDispatcher
import id.buaja.common.di.IoDispatcher
import id.zelory.compressor.Compressor
import id.zelory.compressor.constraint.format
import id.zelory.compressor.constraint.quality
import id.zelory.compressor.constraint.resolution
import id.zelory.compressor.constraint.size
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 5/28/22.
 * Mobile Engineer - Android
 */

class RemoteDataSourceImpl @Inject constructor(
    private val storyService: StoryService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher,
    @ApplicationContext private val context: Context
) : RemoteDataSource {
    override fun addNewStory(description: String, photo: File) = flow {
        val filePhoto = Compressor.compress(
            context = context,
            imageFile = photo,
            coroutineContext = defaultDispatcher
        ) {
            resolution(1280, 720)
            quality(80)
            format(Bitmap.CompressFormat.JPEG)
            size(
                maxFileSize = 1_000_000
            )
        }

        val requestDescription = description.toRequestBody(
            contentType = "text/plain".toMediaTypeOrNull()
        )
        val requestPhoto = filePhoto.asRequestBody(
            contentType = "image/jpeg".toMediaTypeOrNull()
        )
        val imageMultipart: MultipartBody.Part = MultipartBody.Part.createFormData(
            "photo",
            filePhoto.name,
            requestPhoto
        )

        emit(
            storyService.addNewStory(
                description = requestDescription,
                photo = imageMultipart
            )
        )
    }.flowOn(ioDispatcher)
}