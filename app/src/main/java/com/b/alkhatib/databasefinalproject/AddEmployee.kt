package com.b.alkhatib.databasefinalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.b.alkhatib.databasefinalproject.databinding.ActivityAddEmployeeBinding
import com.b.alkhatib.databasefinalproject.db.Firebase
import com.b.alkhatib.databasefinalproject.model.Employee
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore

class AddEmployee : AppCompatActivity() {
    lateinit var db: FirebaseFirestore // 1. تعريف الداتا بيز

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAddEmployeeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = com.google.firebase.ktx.Firebase.firestore
        val firebase = Firebase

        binding.btnAdd.setOnClickListener {
            if(binding.etId.text.isNotEmpty() && binding.etId.text.isNotEmpty() &&
                binding.etSalary.text.isNotEmpty()){

                val id = binding.etId.text.toString()
                val name = binding.etname.text.toString()
                val salary = binding.etSalary.text.toString()
                val emb = Employee(id,name,salary)

                firebase.addUserToDB(this,db, emb)
            }else{
                Toast.makeText(this, "Please Fill in The Required Fields", Toast.LENGTH_SHORT).show()
            }
        }

    }
}