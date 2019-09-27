package iteso.mx.tarea05.fragments.mainBottom


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import iteso.mx.tarea05.R
import iteso.mx.tarea05.adapters.AdapterRecipe
import org.jetbrains.anko.find

class FragmentRecipes : Fragment() {
    private lateinit var mAdapter: AdapterRecipe
    //private lateinit var mRecycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_recipes, container, false)
        /* TODO fetch data from parse and replace it inside AdapterRecipe*/
        mAdapter = AdapterRecipe(arrayListOf())

//        mRecycler = view.find(R.id.fragment_recipes_rv_recipes)
//        mRecycler.adapter = mAdapter
//        mRecycler.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        return view
    }
}
