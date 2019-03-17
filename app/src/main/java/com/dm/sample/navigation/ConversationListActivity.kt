package com.dm.sample.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class ConversationListActivity : AppCompatActivity() {

    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation_list)
        setupNavigation()
    }

    private fun setupNavigation() {
        navController = findNavController(R.id.conversationHostFragment).also {
            bottomNavigation.setupWithNavController(it)
        }
    }
}
