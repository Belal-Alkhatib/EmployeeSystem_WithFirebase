package com.b.alkhatib.databasefinalproject.Delete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.b.alkhatib.databasefinalproject.databinding.ActivityDeleteByNameBinding
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore

class DeleteByName : AppCompatActivity() {
    lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDeleteByNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = com.google.firebase.ktx.Firebase.firestore

        binding.btnDelete.setOnClickListener {
            if(binding.etName.text.isNotEmpty() && binding.etId.text.isNotEmpty()){
                val id = binding.etId.text.toString()
                val name = binding.etName.text.toString()

                DeleteEmployeeName(id.toString(),name.toString())
            }else{
                Toast.makeText(this, "Please Fill in The Required Fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun DeleteEmployeeName(id:String, name:String){
            db.collection("employee").document(id)
                .update("name", FieldValue.delete())
                .addOnSuccessListener {
                    Toast.makeText(this,"Employee Name Deleted Successfully", Toast.LENGTH_LONG).show()
                    val i = Intent(this,DeleteOperations::class.java)
                    startActivity(i)
                }
                .addOnFailureListener { exception ->
                    Log.e("hzm", exception.message.toString())
                }


    }

    /*

    */
}