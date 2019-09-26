package iteso.mx.tarea05.fragments.mainBottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ViewAnimator
import androidx.fragment.app.Fragment
import iteso.mx.tarea05.R
import org.jetbrains.anko.find


class FragmentHome : Fragment(), HomeView {
    private lateinit var mSwitcher: ViewAnimator
    private lateinit var mPresenter: HomePresenter
    private lateinit var mButton: Button

    companion object {
        const val FIRST_VIEW = 0
        const val SECOND_VIEW = 1
        const val THIRD_VIEW = 2
        const val FOURTH_VIEW = 3
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_home, container, false)

        mSwitcher = view.find(R.id.fragment_main_switcher)
        mButton = view.find(R.id.fragment_main_home_btn_refresh)

        mPresenter = Presenter(this)

        mButton.setOnClickListener {
            mPresenter.fetchData()
        }

        return view
    }

    override fun showRefreshView() {
        mSwitcher.displayedChild = FIRST_VIEW
    }

    override fun showProgress() {
        mSwitcher.displayedChild = SECOND_VIEW
    }

    override fun showNoInfo() {
        mSwitcher.displayedChild = THIRD_VIEW
    }

    override fun showInfo() {
        mSwitcher.displayedChild = FOURTH_VIEW
    }


}