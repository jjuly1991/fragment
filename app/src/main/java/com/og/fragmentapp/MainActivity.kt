package com.og.fragmentapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


private const val LAST_SELECTED_ITEM = "item"

class MainActivity : AppCompatActivity() {

    private lateinit var bottomMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomMenu = findViewById(R.id.bottom_navigation)

        bottomMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_1 -> {
                    val menuFragment = MenuFragment()
                    replaceFragment(menuFragment)
                }
                R.id.page_2 -> {
                    val aboutFragment = AboutFragment()
                    replaceFragment(aboutFragment)
                }

            }
            true
        }

        bottomMenu.selectedItemId = savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.bottom_navigation
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_SELECTED_ITEM, bottomMenu.selectedItemId)
        super.onSaveInstanceState(outState)
    }
}