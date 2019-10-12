package ru.itis.almaz.customview

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        graph.setData(listOf(1f, 3f, 6f, 2f))
    }
}
