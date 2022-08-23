package com.b.alkhatib.databasefinalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.b.alkhatib.databasefinalproject.Delete.DeleteOperations
import com.b.alkhatib.databasefinalproject.Search.SearchOprerations
import com.b.alkhatib.databasefinalproject.Update.UpdateEmployee
import com.b.alkhatib.databasefinalproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddEmployee.setOnClickListener {
            val i = Intent(this, AddEmployee::class.java)
            startActivity(i)
        }

        binding.btnGetAllEmployee.setOnClickListener {
            val i = Intent(this, GetAllEmployee::class.java)
            startActivity(i)
        }
        binding.btnDeleteEmployee.setOnClickListener {
            val i = Intent(this, DeleteOperations::class.java)
            startActivity(i)
        }
        binding.btnUpdateEmployee.setOnClickListener {
            val i = Intent(this, DeleteOperations::class.java)
            startActivity(i)
        }
        binding.btnUpdateEmployee.setOnClickListener {
            val i = Intent(this, UpdateEmployee::class.java)
            startActivity(i)
        }
        binding.btnSearchEmployeeOperations.setOnClickListener {
            val i = Intent(this, SearchOprerations::class.java)
            startActivity(i)
        }
    }
}