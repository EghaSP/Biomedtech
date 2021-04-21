package com.eghasp.biomedtech

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_PHOTO = "extra_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)
        val tvDataReceiverImg:ImageView = findViewById(R.id.img_item_photo)
        Glide.with(this)
                .load(photo)
                .apply(RequestOptions().override(500,500))
                .into(tvDataReceiverImg)

        val tvDataReceiverName:TextView = findViewById(R.id.tv_item_name)
        val name = intent.getStringExtra(EXTRA_NAME)
        tvDataReceiverName.text = name

        val tvDataReceiverDetail:TextView = findViewById(R.id.tv_item_detail)
        val detail = intent.getStringExtra(EXTRA_DETAIL)
        tvDataReceiverDetail.text = detail

    }

}
