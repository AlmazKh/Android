package ru.itis.almaz.title.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_details.*
import ru.itis.almaz.title.R

class DetailsActivity : AppCompatActivity() {
    private val viewModel: DetailsViewModel =
            DetailsViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        viewModel.getArguments(intent)
        observeData()
    }

    private fun observeData() {
        viewModel.stickerLiveData.observe(this, Observer {
            Glide.with(this)
                    .load(it.photoUrl)
                    .into(iv_photo)
            tv_name.text = it.name
        })
    }
}
