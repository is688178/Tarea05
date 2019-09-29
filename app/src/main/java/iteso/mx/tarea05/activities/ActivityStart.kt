package iteso.mx.tarea05.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.parse.ParseInstallation
import iteso.mx.tarea05.R
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class ActivityStart : AppCompatActivity(), View.OnClickListener {
    private lateinit var mLogin: Button
    private lateinit var mRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide() //hide the title bar
        setContentView(R.layout.activity_start)

        mLogin = find(R.id.activity_login_btn_login)
        mRegister = find(R.id.activity_login_btn_register)

        mLogin.setOnClickListener(this)
        mRegister.setOnClickListener(this)

        // Save the current Installation to Back4App
        ParseInstallation.getCurrentInstallation().saveInBackground()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.activity_login_btn_login -> {
                startActivity<ActivityLogin>()
            }
            R.id.activity_login_btn_register -> {
                startActivity<ActivityRegister>()
            }
        }
    }
}
