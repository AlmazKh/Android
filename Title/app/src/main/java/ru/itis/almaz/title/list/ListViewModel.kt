package ru.itis.almaz.title.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.itis.almaz.title.data.DataHelper
import ru.itis.almaz.title.data.Sticker

class ListViewModel : ViewModel() {
    val stickersLiveData = MutableLiveData<MutableList<Sticker>>()

    fun getList() {
        stickersLiveData.value = DataHelper.getStickersList()
    }
}
