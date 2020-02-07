package com.example.rental

import android.app.Activity
import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Filter
import android.widget.TextView
import com.example.rental.R
import kotlinx.android.synthetic.main.activity_otp.*
import java.io.File
import javax.net.ssl.KeyManager

class OTPActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        setTextFilter()
    }

    private fun setTextFilter() {

        val lengthFilter = InputFilter.LengthFilter(1)

        one.filters = arrayOf(lengthFilter)
        two.filters = arrayOf(lengthFilter)
        three.filters = arrayOf(lengthFilter)
        four.filters = arrayOf(lengthFilter)
        five.filters = arrayOf(lengthFilter)
        six.filters = arrayOf(lengthFilter)

        one.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (count == 1) two.requestFocus()
                if (count == 0) hideKeyboard()
            }
        })

        two.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (count == 1) three.requestFocus()
                if (count == 0) one.requestFocus()
            }
        })

        three.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (count == 1) four.requestFocus()
                if (count == 0) two.requestFocus()
            }
        })

        four.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (count == 1) five.requestFocus()
                if (count == 0) three.requestFocus()
            }
        })

        five.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (count == 1) six.requestFocus()
                if (count == 0) four.requestFocus()
            }
        })

        six.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (count == 1) hideKeyboard()
                if (count == 0) five.requestFocus()
            }
        })

    }

    private fun hideKeyboard() {
        var imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = currentFocus
        if (view != null) {
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

}
