package com.b.alkhatib.databasefinalproject.Delete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.b.alkhatib.databasefinalproject.databinding.ActivityDeleteByIdBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore

class DeleteById : AppCompatActivity() {
    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDeleteByIdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = com.google.firebase.ktx.Firebase.firestore

        binding.btnDelete.setOnClickListener {
            if(binding.etId.text.isNotEmpty()){
                val id = binding.etId.text.toString()
                DeleteUserById(id)
            }else{
                Toast.makeText(this, "Please Fill in The Required Fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun DeleteUserById(id:String){
        db.collection("employee").document(id)
            .delete()
            .addOnSuccessListener {
                Toast.makeText(this,"Employee Deleted Successfully", Toast.LENGTH_LONG).show()
                val i = Intent(this,DeleteOperations::class.java)
                startActivity(i)
            }
            .addOnFailureListener { exception ->
                Log.e("hzm", exception.message.toString())
            }
    }
}