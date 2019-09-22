package iteso.mx.tarea05.fragments.tutorial

import android.view.View

interface FragmentState : View.OnClickListener {
    fun previousClickedOn(currentState: Int)

    fun nextClickedOn(currentState: Int)
}