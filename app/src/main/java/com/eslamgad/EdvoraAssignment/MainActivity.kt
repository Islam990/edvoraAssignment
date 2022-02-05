package com.eslamgad.EdvoraAssignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.children
import com.eslamgad.EdvoraAssignment.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pencil.setOnClickListener {
            selectedBackground(binding.pencil.id)
        }

        binding.line.setOnClickListener {
            selectedBackground(binding.line.id)
        }

        binding.rectangle.setOnClickListener {
            selectedBackground(binding.rectangle.id)
        }

        binding.circle.setOnClickListener {
            selectedBackground(binding.circle.id)
        }

        binding.color.setOnClickListener {
            selectedBackground(binding.color.id)
        }

    }

    private fun selectedBackground(id: Int) {
        for (view in binding.topNavigation.children) {
            if (view.id == id) {
                view.setBackgroundColor(getColor(R.color.white))
            } else {
                view.setBackgroundColor(getColor(R.color.LightGray))
            }
        }
    }

}