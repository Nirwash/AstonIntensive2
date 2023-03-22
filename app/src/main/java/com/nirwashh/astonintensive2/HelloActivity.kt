package com.nirwashh.astonintensive2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nirwashh.astonintensive2.databinding.ActivityHelloBinding

class HelloActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHelloBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelloBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvCount.text = intent.getIntExtra(COUNT, 0).toString()
    }

    companion object {
        private const val COUNT = "count"
    }
}