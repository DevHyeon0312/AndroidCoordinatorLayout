package com.devhyeon.coordinatorlayout.FooterSample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devhyeon.coordinatorlayout.databinding.ActivityFooterBinding

class FooterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFooterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFooterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.header.toolbar)
        supportActionBar!!.title = "FooterActivity"
    }
}