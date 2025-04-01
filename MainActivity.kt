package com.example.studentinfo

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dbConnection: DBConnection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbConnection = DBConnection()

        val spinnerUserType = findViewById<Spinner>(R.id.spinnerUserType)
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // Populate Spinner with Admin/User options
        val userTypes = arrayOf("Admin", "User")
        spinnerUserType.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, userTypes)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val userType = spinnerUserType.selectedItem.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check login credentials
            val isSuccess = when (userType) {
                "Admin" -> dbConnection.loginAdmin(username, password)
                "User" -> dbConnection.loginUser(username, password)
                else -> false
            }

            if (isSuccess) {
                Toast.makeText(this, "$userType Login Successful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, DashboardActivity::class.java)
                intent.putExtra("isAdmin", userType == "Admin")  // Pass true if Admin, false if User
                startActivity(intent)
                finish()  // Prevent going back to login
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
