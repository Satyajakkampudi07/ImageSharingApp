package com.example.mediasharingapp

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var imageViewer: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.btn)
        imageViewer = findViewById(R.id.image)

        btn.setOnClickListener {
            //open gallery and want ti select an image
            val imageViewIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(imageViewIntent, 102)
            //startActivityForResult , whenever we use ths -> we need to override the method called onActivityResult to get back the data
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 102 && resultCode == RESULT_OK) {
            imageViewer.setImageURI(data?.data)
        }
    }
}


