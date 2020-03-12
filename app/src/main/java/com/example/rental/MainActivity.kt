package com.example.rental

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.widget.Toast
import com.example.rental.cloud.Fire
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit
import javax.xml.transform.Result

class MainActivity : AppCompatActivity() {

    private val RC_SIGN_IN = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this@MainActivity, FetchResultActivity::class.java))

        Fire.Static.initializeCloud()

        val providers = arrayListOf(
            AuthUI.IdpConfig.PhoneBuilder().build()
        )

        val ss = SpannableString("Packed your bags!\nWhy go find door to door when we are here to help you.\nJust see the apartment and decide for yourself.")
        ss.setSpan(RelativeSizeSpan(2f), 0,17,0)
        ss.setSpan(ForegroundColorSpan(Color.RED), 0, 16, 0)
        ss.setSpan(ForegroundColorSpan(Color.BLUE), 16, 17, 0)
        homepage_text_view.text = ss

        start_using_button.setOnClickListener{
            startActivityForResult(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .build(),
                RC_SIGN_IN)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)
            if (resultCode == Activity.RESULT_OK) {
                startActivity(Intent(this@MainActivity, UserInfoGatherActivity::class.java))
            } else {

            }
        }
    }

}
