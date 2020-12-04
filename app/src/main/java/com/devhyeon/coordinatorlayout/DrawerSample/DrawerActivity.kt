package com.devhyeon.coordinatorlayout.DrawerSample

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.devhyeon.coordinatorlayout.R
import com.devhyeon.coordinatorlayout.databinding.ActivityDrawerBinding

class DrawerActivity : AppCompatActivity() , DrawerView {
    private lateinit var binding: ActivityDrawerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setToolbar()
        setDrawer()
    }

    override fun setToolbar() {
        setSupportActionBar(binding.header.toolbar)
        supportActionBar!!.title = "DrawerActivity"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp)
    }

    override fun setDrawer() {
        binding.drawerLayout.addDrawerListener(
            ActionBarDrawerToggle(
                this,            //Activity
                binding.drawerLayout,   //DrawerLayout
                binding.header.toolbar, //Toolbar
                R.string.drawer_open,   //String(open)
                R.string.drawer_close   //String(close)
            )
        )
    }
}