package com.example.cruisemastersmad.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cruisemastersmad.databinding.ActivityLoginBinding
import com.example.cruisemastersmad.ui.activities.HomeActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
    }

    private fun setupViews() {
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                loginUser(email, password)
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun loginUser(email: String, password: String) {
        binding.progressBar.visibility = android.view.View.VISIBLE
        binding.btnLogin.isEnabled = false

        // Simulate API call
        android.os.Handler().postDelayed({
            // For demo - accept any email/password
            val sharedPref = getSharedPreferences("user_prefs", MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("user_email", email)
                putString("user_name", email.substringBefore("@"))
                putBoolean("is_logged_in", true)
                apply()
            }

            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, HomeActivity::class.java))
            finish()

            binding.progressBar.visibility = android.view.View.GONE
            binding.btnLogin.isEnabled = true
        }, 1500)
    }
}