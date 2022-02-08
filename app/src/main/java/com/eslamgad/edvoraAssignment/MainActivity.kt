package com.eslamgad.edvoraAssignment

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.children
import com.eslamgad.edvoraAssignment.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pencil.setOnClickListener {
            selectedBackground(it.id)
            Common.shape = shapes.hand
        }

        binding.line.setOnClickListener {
            selectedBackground(it.id)
            Common.shape = shapes.line
        }

        binding.rectangle.setOnClickListener {
            selectedBackground(it.id)
            Common.shape = shapes.rect
        }

        binding.circle.setOnClickListener {
            selectedBackground(it.id)
            Common.shape = shapes.circle
        }

        binding.color.setOnClickListener {
            selectedBackground(it.id)
            binding.colorPallet.visibility = View.VISIBLE
        }

        binding.red.setOnClickListener {
            binding.colorPallet.visibility = View.INVISIBLE
            DrawView.colorSelected = Color.RED
        }

        binding.green.setOnClickListener {
            binding.colorPallet.visibility = View.INVISIBLE
            DrawView.colorSelected = Color.GREEN
        }

        binding.blue.setOnClickListener {
            binding.colorPallet.visibility = View.INVISIBLE
            DrawView.colorSelected = Color.BLUE
        }

        binding.black.setOnClickListener {
            binding.colorPallet.visibility = View.INVISIBLE
            DrawView.colorSelected = Color.BLACK
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