package com.b.alkhatib.databasefinalproject.Search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.b.alkhatib.databasefinalproject.GetAllEmployee
import com.b.alkhatib.databasefinalproject.databinding.ActivitySearchOprerationsBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore

class SearchOprerations : AppCompatActivity() {
    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySearchOprerationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = com.google.firebase.ktx.Firebase.firestore

        binding.btnSearchById.setOnClickListener {
            val i = Intent(this, SearchById::class.java)
            startActivity(i)
        }
        binding.btnSearchByName.setOnClickListener {
            val i = Intent(this, SearchByName::class.java)
            startActivity(i)
        }
        binding.btnSearchBySalary.setOnClickListener {
            val i = Intent(this, SearchBySalary::class.java)
            startActivity(i)
        }

    }
}