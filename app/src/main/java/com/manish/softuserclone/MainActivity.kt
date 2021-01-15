package com.manish.softuserclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.manish.softuserclone.Fragments.AboutUsFragment
import com.manish.softuserclone.Fragments.AddStudentFragment
import com.manish.softuserclone.Fragments.HomeFragment
import com.manish.softuserclone.UserDataObject.StudentDataObject

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentcont: FrameLayout
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentcont = findViewById(R.id.fragmentcont)
        bottomNav = findViewById(R.id.bottomNav)
        StudentDataObject.loadStudent()


        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnNavigationItemSelectedListener(navListener)

        supportFragmentManager.beginTransaction().replace(R.id.fragmentcont, HomeFragment())
            .commit()

    }

    private val navListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.nav_home -> selectedFragment = HomeFragment()
                R.id.nav_add -> selectedFragment = AddStudentFragment()
                R.id.nav_user -> selectedFragment = AboutUsFragment()
            }
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragmentcont,
                    selectedFragment
                ).commit()
            }
            true
        }


}