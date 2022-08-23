package com.b.alkhatib.databasefinalproject.Delete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.b.alkhatib.databasefinalproject.databinding.ActivityDeleteOperationsBinding

class DeleteOperations : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDeleteOperationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDeleteById.setOnClickListener {
            val i = Intent(this, DeleteById::class.java)
            startActivity(i)
        }
        binding.btnDeleteByName.setOnClickListener {
            val i = Intent(this, DeleteByName::class.java)
            startActivity(i)
        }
        binding.btnDeleteBySalary.setOnClickListener {
            val i = Intent(this, DeleteBySalary::class.java)
            startActivity(i)
        }
    }
}