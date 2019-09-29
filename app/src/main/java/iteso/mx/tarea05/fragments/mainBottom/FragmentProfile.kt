package iteso.mx.tarea05.fragments.mainBottom

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.parse.ParseUser
import iteso.mx.tarea05.R
import iteso.mx.tarea05.activities.ActivityStart
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.startActivity

class FragmentProfile : Fragment() {
    private lateinit var mEmail: TextView
    private lateinit var mUserName: TextView
    private lateinit var mClose: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_profile, container, false)

        mEmail = view.find(R.id.fragment_profile_tv_email)
        mUserName = view.find(R.id.fragment_profile_tv_UserName)
        mClose = view.find(R.id.fragment_profile_tv_Close)

        setUserEmail()
        setUserName()

        mClose.setOnClickListener {
            ParseUser.logOutInBackground()
            startActivity<ActivityStart>()
        }

        return view
    }

    private fun setUserEmail() {
        if (ParseUser.getCurrentUser() != null) {
            try {
                mEmail.text = ParseUser.getCurrentUser().email
            } catch (exception: Exception) {
                Log.e("DEBUG User Email", exception.message.toString())
            }
        }
    }

    private fun setUserName() {
        if (ParseUser.getCurrentUser() != null) {
            try {
                mUserName.text = ParseUser.getCurrentUser().username
            } catch (exception: Exception) {
                Log.e("DEBUG User Name", exception.message.toString())
            }
        }
    }

}

