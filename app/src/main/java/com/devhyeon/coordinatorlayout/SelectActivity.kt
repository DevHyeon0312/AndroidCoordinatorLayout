package com.devhyeon.coordinatorlayout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devhyeon.coordinatorlayout.BasicSample.BasicActivity
import com.devhyeon.coordinatorlayout.DrawerSample.DrawerActivity
import com.devhyeon.coordinatorlayout.FooterSample.FooterActivity
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
                Intent(it.context, BasicActivity::class.java)
            )
        }
        binding.btnFooter.setOnClickListener {
            startActivity(
                Intent(it.context, FooterActivity::class.java)
            )
        }
        binding.btnDrawer.setOnClickListener {
            startActivity(
                Intent(it.context, DrawerActivity::class.java)
            )
        }
    }

}
