package com.b.alkhatib.databasefinalproject.Search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.b.alkhatib.databasefinalproject.EmployeeAdapter
import com.b.alkhatib.databasefinalproject.databinding.ActivityGetAllEmployeeBinding
import com.b.alkhatib.databasefinalproject.databinding.ActivitySearchByIdBinding
import com.b.alkhatib.databasefinalproject.model.Employee
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore

class SearchById : AppCompatActivity() {
    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySearchByIdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = com.google.firebase.ktx.Firebase.firestore

        binding.btnSearch.setOnClickListener {
            if(binding.etSearchId.text.isNotEmpty()){
                val id = binding.etSearchId.text.toString()
                getAllIdByWhere(binding,id)
            }else{
                Toast.makeText(this, "Please Fill in The Required Fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

   private fun getAllIdByWhere(binding: ActivitySearchByIdBinding,id:String){
       //**********
       val employeeList = ArrayList<Employee>()

       db.collection("employee").whereEqualTo("id",id) // اكبر من او يساوي
           .get()
           .addOnSuccessListener { querySnapshot ->
               for( document in querySnapshot){
                   var id = document.get("id").toString()
                   var name = document.get("name").toString()
                   var salary = document.get("salary").toString()
                   var emb = Employee(id, name, salary)

                   employeeList.add(emb)
                   Toast.makeText(this, "Employee Id Search Downloaded", Toast.LENGTH_SHORT).show()

                   val employeeAdapter = EmployeeAdapter(employeeList)
                   binding.rvResultSearchId.adapter = employeeAdapter
                   binding.rvResultSearchId.layoutManager = LinearLayoutManager(this)
               }
           }
           .addOnFailureListener { exception ->
               Log.e("hzm", "getAllIdByWhere"+exception.message.toString())
           }
       //**********
    }
}