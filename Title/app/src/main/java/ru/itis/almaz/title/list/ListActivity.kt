package ru.itis.almaz.title.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_details.view.*
import kotlinx.android.synthetic.main.activity_list.*
import ru.itis.almaz.title.R
import ru.itis.almaz.title.details.DetailsActivity

class ListActivity : AppCompatActivity() {
    private val viewModel = ListViewModel()
    private lateinit var adapter: StickersAdapter
    private var animateDown = true
    private var animateUp = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        rv_stickers.layoutManager = LinearLayoutManager(this)
        addOnScrollListener()
        adapter = StickersAdapter { sticker, view ->
            val activityOptionsCompatActivity = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this,
                    Pair(view.iv_photo as View, "ivPhoto"), Pair(view.tv_name as View, "tvName")
            )
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("tvName", sticker.name)
            intent.putExtra("ivPhoto", sticker.photoUrl)
            startActivity(intent, activityOptionsCompatActivity.toBundle())
        }
        viewModel.getList()
        observeList()
    }

    private fun addOnScrollListener() {
        rv_stickers.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    animateDown = true
                    animateUp = true
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 && animateDown) {
                    tv_title.apply {
                        alpha = 0f
                        visibility = View.VISIBLE
                        animate()
                                .alpha(1f)
                                .setListener(null)
                                .duration =
                                resources.getInteger(android.R.integer.config_shortAnimTime)
                                        .toLong()

                    }
                    animateDown = false
                } else if (dy < 0 && animateUp) {
                    tv_title.apply {
                        alpha = 1f
                        animate()
                                .alpha(0f)
                                .setListener(null)
                                .duration =
                                resources.getInteger(android.R.integer.config_shortAnimTime)
                                        .toLong()
                    }
                    animateUp = false

                }
            }
        })
    }

    private fun observeList() {
        viewModel.stickersLiveData.observe(this, Observer {
            adapter.submitList(it)
            rv_stickers.adapter = adapter
        })
    }
}
