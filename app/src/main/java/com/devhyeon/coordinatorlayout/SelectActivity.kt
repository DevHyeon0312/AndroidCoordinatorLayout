package com.devhyeon.coordinatorlayout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devhyeon.coordinatorlayout.BasicSample.BasicActivity
import com.devhyeon.coordinatorlayout.databinding.ActivitySelectBinding

class SelectActivity : AppCompatActivity() , SelectActivityInterface {
    private lateinit var binding: ActivitySelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonClickListener()
    }

    override fun buttonClickListener() {
        binding.btnBase.setOnClickListener {
            startActivity(
                Intent(this, BasicActivity::class.java)
            )
        }
    }

}
