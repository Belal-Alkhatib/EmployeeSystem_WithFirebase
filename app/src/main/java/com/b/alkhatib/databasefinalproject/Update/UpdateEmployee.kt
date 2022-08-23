package com.b.alkhatib.databasefinalproject.Update

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.b.alkhatib.databasefinalproject.Delete.DeleteOperations
import com.b.alkhatib.databasefinalproject.MainActivity
import com.b.alkhatib.databasefinalproject.R
import com.b.alkhatib.databasefinalproject.databinding.ActivityUpdateByIdBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore

class UpdateEmployee : AppCompatActivity() {
    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityUpdateByIdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = com.google.firebase.ktx.Firebase.firestore

        binding.btnUpdate.setOnClickListener {
            if(binding.etOldId.text.isNotEmpty() && binding.etNewId.text.isNotEmpty()
                && binding.etname.text.isNotEmpty() && binding.etSalary.text.isNotEmpty()
            ){
                val oldId = binding.etOldId.text.toString()
                val newId = binding.etNewId.text.toString()
                val name = binding.etname.text.toString()
                val salary = binding.etSalary.text.toString()
                updateuserById(oldId, newId, name, salary)
            }else{
                Toast.makeText(this, "Please Fill in The Required Fields", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun updateuserById(oldId:String, newId:String, name:String, salary:String){
        val emp = HashMap<String,Any>()
        emp["id"] = newId
        emp["name"] = name
        emp["salary"] = salary

        db.collection("employee").document(oldId)
            .update(emp)
            .addOnSuccessListener {
                Toast.makeText(this,"Employee Updated Successfully", Toast.LENGTH_LONG).show()
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            }
            .addOnFailureListener { exception ->
                Log.e("hzm", exception.message.toString())
            }
    }
}