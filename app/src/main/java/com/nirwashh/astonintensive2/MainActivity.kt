package com.nirwashh.astonintensive2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nirwashh.astonintensive2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(COUNT)
            binding.tvCount.text = savedInstanceState.getInt(COUNT).toString()
        }


        with(binding) {
            btnCount.setOnClickListener {
                countUp()
                tvCount.text = count.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNT, count)
    }


    private fun countUp() {
        count++
    }

    companion object {
        private const val COUNT = "count"
    }
}