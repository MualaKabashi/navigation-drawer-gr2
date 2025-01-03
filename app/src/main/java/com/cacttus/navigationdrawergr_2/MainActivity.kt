package com.cacttus.navigationdrawergr_2

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.cacttus.navigationdrawergr_2.databinding.ActivityMainBinding
import com.cacttus.navigationdrawergr_2.fragments.HomeFragment
import com.cacttus.navigationdrawergr_2.fragments.PostFragment
import com.cacttus.navigationdrawergr_2.fragments.ProfileFragment
import com.cacttus.navigationdrawergr_2.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var homeFragment: HomeFragment
    private lateinit var settingsFragment: SettingsFragment
    private lateinit var profileFragment: ProfileFragment
    private lateinit var postFragment: PostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initToggle()
        initializeFragments()
        showMenu()
        selectWhichFragmentToDisplay()
    }


    private fun initializeFragments() {
        homeFragment = HomeFragment()
        settingsFragment = SettingsFragment()
        profileFragment = ProfileFragment()
        postFragment = PostFragment()
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
        }.commit()
    }

    private fun initToggle() {
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun closeDrawerIfOpen() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawers()
        }
    }

    private fun showMenu() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun selectWhichFragmentToDisplay() {
        binding.navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.profile -> {
                    closeDrawerIfOpen()
                    setCurrentFragment(profileFragment)
                }

                R.id.settings -> {
                    closeDrawerIfOpen()
                    setCurrentFragment(settingsFragment)
                }

                R.id.home -> {
                    closeDrawerIfOpen()
                    setCurrentFragment(homeFragment)
                }

                R.id.post -> {
                    closeDrawerIfOpen()
                    setCurrentFragment(postFragment)
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) return true
        return super.onOptionsItemSelected(item)
    }
}













