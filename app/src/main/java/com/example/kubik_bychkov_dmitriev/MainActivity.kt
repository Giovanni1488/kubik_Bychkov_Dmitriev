package com.example.kubik_bychkov_dmitriev

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kubik_bychkov_dmitriev.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.resultTextView.text = getString(R.string.default_text)


        binding.rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val diceImages = listOf(
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6
        )

        val dotaPositions = listOf(
            R.string.position_safelane,
            R.string.position_midlane,
            R.string.position_offlane,
            R.string.position_softsupport,
            R.string.position_hardsupport,
            R.string.position_jungler
        )

        val randomNumber = (0..5).random()

        // Изменение картинки ЧЕРЕЗ BINDING
        binding.diceImageView.setImageResource(diceImages[randomNumber])

        // Изменение текста ЧЕРЕЗ BINDING
        binding.resultTextView.text = getString(dotaPositions[randomNumber])

        Toast.makeText(
            this,
            "Выпала позиция: ${randomNumber + 1}",
            Toast.LENGTH_SHORT
        ).show()
    }
}