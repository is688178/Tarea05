package iteso.mx.tarea05.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import iteso.mx.tarea05.R
import org.jetbrains.anko.find
import com.parse.*
import org.jetbrains.anko.startActivity

class ActivityRegister : AppCompatActivity(), View.OnClickListener {
    private lateinit var mRegister: Button
    private lateinit var mFullName: EditText
    private lateinit var mEmail: EditText
    private lateinit var mPassword: EditText

    companion object {
        const val FULL_NAME = "FULL_NAME"
        const val EMAIL = "EMAIL"
        const val PASSWORD = "PASSWORD"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mRegister = find(R.id.activity_register_btn_register)
        mFullName = find(R.id.activity_register_tiet_full_name)
        mEmail = find(R.id.activity_register_tiet_email)
        mPassword = find(R.id.activity_register_tiet_password)

        mRegister.setOnClickListener(this)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val fullName = savedInstanceState.getString(FULL_NAME)
        val email = savedInstanceState.getString(EMAIL)
        val password = savedInstanceState.getString(PASSWORD)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.activity_register_btn_register -> {
                //requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

                val strUser = mFullName.text.toString().trim()
                val strEmail = mEmail.text.toString().trim()
                val strPassword = mPassword.text.toString().trim()

                // Register User in Parse
//                val userObject = ParseObject("SimpleUser")
//                userObject.put("user", strUser)
//                userObject.put("email", strEmail)
//                userObject.put("password", strPassword)
//                userObject.saveInBackground()

                val parseUser = ParseUser()
                parseUser.apply {
                    setUsername(strUser)
                    setEmail(strEmail)
                    setPassword(strPassword)
                }

                parseUser.signUpInBackground { error ->
                    if (error == null) {
                        //Sign up successful
                        Log.d("PARSE", "Sign up successful user: $strUser")
                        startActivity<ActivityTutorial>()
                    } else {
                        //There was an error,
                        //networkState.postValue(NetworkState(Status.ERROR, error))
                        Log.e("DEBUG PARSE", "Failed to complete sign up process. Error message: ${error.message} Error code ${error.code}")
                        Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
                    }
                }


            }
        }
    }
}
