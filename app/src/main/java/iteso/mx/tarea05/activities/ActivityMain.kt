package iteso.mx.tarea05.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import iteso.mx.tarea05.R
import iteso.mx.tarea05.fragments.mainBottom.*

class ActivityMain : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* TODO Add BottomNavigationView with three options
        1.- List of recipes
        Use FragmentRecipes
        2.- Actual recipe
        Create FragmentRecipe
        Use MVP Pattern
        FragmentRecipe (View)
        Recipe (Model)
        PresenterRecipe (Presenter)
        Use ViewAnimator
            FIRST_VIEW
            Button with Refresh text
            SECOND_VIEW
            MaterialCard
            THIRD_VIEW
            Image with text
        3.- Profile
        Create FragmentProfile
         */
        val navigation = findViewById<BottomNavigationView>(R.id.activity_main_bnv_navigation)
        navigation.setOnNavigationItemSelectedListener(this)

        // default home fragment view
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.activity_main_fl_main_content,
                FragmentHome()
            )
            .commit()

        //default home selected in bottom menu
        navigation.menu.findItem(R.id.action_home).isChecked = true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_recipes -> supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.activity_main_fl_main_content,
                    FragmentRecipes()
                )
                .commit()
            R.id.action_home -> supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.activity_main_fl_main_content,
                    FragmentHome()
                )
                .commit()
            R.id.action_profile -> supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.activity_main_fl_main_content,
                    FragmentProfile()
                )
                .commit()
        }
        return true
    }
}
