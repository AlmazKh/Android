package ru.itis.almaz.title.data

import ru.itis.almaz.title.R

object DataHelper {

    fun getStickersList(): MutableList<Sticker> {
        val list = mutableListOf<Sticker>()
        for (i in 1..10) {
            list.add(
                    Sticker("Yoda", R.raw.yoda)
            )
            list.add(
                    Sticker("Magic", R.raw.magic)
            )
            list.add(
                    Sticker("Testing", R.raw.testing)
            )
        }
        return list
    }
}
