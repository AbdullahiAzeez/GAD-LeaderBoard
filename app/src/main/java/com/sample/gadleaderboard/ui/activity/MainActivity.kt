package com.sample.gadleaderboard.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.sample.gadleaderboard.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val navController = findNavController(R.id.nav_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

        submit.setOnClickListener {
            findNavController(R.id.nav_fragment).navigate(R.id.action_leaderBoardFragment_to_formSubmissionFragment)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_fragment)
        return NavigationUI.navigateUp(navController, null)
    }
}