package com.example.rental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.widget.Toast
import com.example.rental.cloud.Fire
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Fire.Static.initializeCloud()

        setBackButtonFunctionality()
        setMobileTextFieldLength()

        send_otp_image_view.setOnClickListener{
            if (mobile_edit_text.text.toString().length == 10) {
                send_otp_image_view.isEnabled = false
                sendOTP("+91" + mobile_edit_text.text.toString())
            } else {
                Snackbar.make(it, "Not a valid number!", 2000).show()
            }
        }

    }

    // Method to send the OTP to the number.
    private fun sendOTP(phoneNumber: String) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            phoneNumber, // Phone number to verify
            60, // Timeout duration
            TimeUnit.SECONDS, // Unit of timeout
            this, // Activity (for callback binding)
            setCallback()) // OnVerificationStateChangedCallbacks
    }

    // Making a callback for the Authentication Provider for the OTP functionality.
    private fun setCallback(): PhoneAuthProvider.OnVerificationStateChangedCallbacks {
        return object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                println("()()()() OTP SENT")
                startActivity(Intent(this@MainActivity, OTPActivity::class.java))
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                Toast.makeText(applicationContext, p0.message, Toast.LENGTH_LONG).show()
                send_otp_image_view.isEnabled = true
            }
        }
    }

    private fun setBackButtonFunctionality() {
        back_main_activity.setOnClickListener{
            finish()
        }
    }

    private fun setMobileTextFieldLength() {
        mobile_edit_text.filters = arrayOf(InputFilter.LengthFilter(10))
    }

}
