package com.dm.sample.navigation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.dm.sample.navigation.view.BadgeView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigation()
        setupBadge()
    }

    override fun onResume() {
        super.onResume()
        navController?.addOnDestinationChangedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings, menu)
        return true
    }

    override fun onPause() {
        super.onPause()
        navController?.removeOnDestinationChangedListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return navController?.let {
            item.onNavDestinationSelected(it)
        } ?: false || super.onOptionsItemSelected(item)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        val isMainScreen = when (destination.id) {
            R.id.homeFragment, R.id.dashboardFragment, R.id.notificationListFragment -> true
            else -> false
        }
        bottomNavigation.visibility = if (isMainScreen) VISIBLE else GONE
    }

    private fun setupNavigation() {
        navController = findNavController(R.id.hostFragment).also {
            NavigationUI.setupActionBarWithNavController(this, it)
            bottomNavigation.setupWithNavController(it)
        }
    }

    private fun setupBadge() {
        val menuView = bottomNavigation.getChildAt(0) as? BottomNavigationMenuView
        val itemView = menuView?.getChildAt(2) as? BottomNavigationItemView
        itemView?.let {
            val badgeView = BadgeView(this)
            badgeView.setBadgeNumber(2)
            itemView.addView(badgeView)
        }
    }

    override fun onSupportNavigateUp() = navController?.navigateUp() ?: false
}
