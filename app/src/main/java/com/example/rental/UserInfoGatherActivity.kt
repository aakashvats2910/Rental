package com.example.rental

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.SpinnerAdapter
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_user_info_gather.*

class UserInfoGatherActivity : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 1

    private var isMale: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info_gather)

        male.setOnClickListener{
            male.setBackgroundResource(R.drawable.selected_background)
            male.setTextColor(Color.parseColor("#ffffff"))
            female.setBackgroundResource(R.drawable.non_selected_button)
            female.setTextColor(Color.parseColor("#00B0FF"))
            isMale = true
        }

        female.setOnClickListener{
            female.setBackgroundResource(R.drawable.selected_background)
            female.setTextColor(Color.parseColor("#ffffff"))
            male.setBackgroundResource(R.drawable.non_selected_button)
            male.setTextColor(Color.parseColor("#00B0FF"))
            isMale = false
        }

        next_page_button.setOnClickListener{
            if (isMale != null && first_name.text.toString().trim().isNotEmpty() && last_name.text.toString().trim().isNotEmpty()) {
//                startActivity(Intent(this@UserInfoGatherActivity, FetchListActivity::class.java))
            }
        }

    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            photo_view.setImageBitmap(imageBitmap)
        }
    }

    private fun isCameraPermissionGranted(): Boolean {
        return (ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)
    }

}
