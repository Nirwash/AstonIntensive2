package com.nirwashh.astonintensive2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import com.nirwashh.astonintensive2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnOpenWebsite.setOnClickListener { openWebsite() }
            btnOpenLocation.setOnClickListener { openLocation() }
            btnSendMessage.setOnClickListener { shareText() }
            btnOpenCamera.setOnClickListener { takePicture() }
        }

    }

    private fun shareText() {
        val text = binding.edMessage.text.toString()
        val mimeType = "text/plain"
        val shareCompat = ShareCompat.IntentBuilder(this@MainActivity)
            .setType(mimeType)
            .setChooserTitle(R.string.share_text_with)
            .setText(text)
            .startChooser()
    }

    private fun openWebsite() {
        val url = "http://${binding.edWebsite.text}"
        val webPage = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webPage)
        if (intent.resolveActivity(packageManager) != null)
            startActivity(intent)
        else
            Log.d("ImplicitIntents", "Can't handle this intent!")
    }

    private fun openLocation() {
        val location = binding.edLocation.text.toString()
        val addressUri = Uri.parse("geo:0,0?q=$location")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
    }

    private fun takePicture() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null)
            startActivity(intent)
        else
            Log.d("ImplicitIntents", "Can't handle this intent!")
    }
}