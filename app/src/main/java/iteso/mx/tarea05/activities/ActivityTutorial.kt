package iteso.mx.tarea05.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import iteso.mx.tarea05.R
import iteso.mx.tarea05.fragments.tutorial.FragmentFirstTutorial

class ActivityTutorial : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.activity_tutorial_fl_content,
                FragmentFirstTutorial()
            )
            .commit()
    }

}
