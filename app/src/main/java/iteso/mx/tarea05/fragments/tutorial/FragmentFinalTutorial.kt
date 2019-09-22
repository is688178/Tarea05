package iteso.mx.tarea05.fragments.tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import iteso.mx.tarea05.R
import iteso.mx.tarea05.activities.ActivityMain
import org.jetbrains.anko.support.v4.startActivity

class FragmentFinalTutorial : Fragment() {
    private lateinit var mNextButton: Button
    private lateinit var mPrevButton: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tutorial_final, container, false)

        mNextButton = view.findViewById(R.id.fragment_tutorial3_btn_nxt)
        mNextButton.setOnClickListener {
            startActivity<ActivityMain>()
        }

        mPrevButton = view.findViewById(R.id.fragment_tutorial3_btn_pvs)
        mPrevButton.setOnClickListener {
            this.fragmentManager!!.beginTransaction()
                .replace(
                    R.id.activity_tutorial_fl_content,
                    FragmentSecondTutorial()
                )
                .commit()
        }

        return view
    }
}