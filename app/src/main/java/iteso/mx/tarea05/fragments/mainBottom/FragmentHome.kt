package iteso.mx.tarea05.fragments.mainBottom

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import iteso.mx.tarea05.R

class FragmentHome : Fragment(), MVPContract.View {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_home, container, false)
        val title = view.findViewById<TextView>(R.id.fragment_home_tv_title)
        title.setOnClickListener {
            Log.d("FragmentHome", "Clicked on Home Title")
        }
        return view
    }
}