package ru.itis.almaz.title.details

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import ru.itis.almaz.title.data.Sticker

class DetailsViewModel {
    val stickerLiveData = MutableLiveData<Sticker>()

    fun getArguments(intent: Intent) {
        val sticker = Sticker(
            intent.getStringExtra("tvName"),
            intent.getIntExtra("ivPhoto", 0)
        )
        stickerLiveData.value = sticker
    }
}
