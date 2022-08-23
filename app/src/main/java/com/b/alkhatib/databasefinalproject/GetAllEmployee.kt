package com.b.alkhatib.databasefinalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.b.alkhatib.databasefinalproject.databinding.ActivityGetAllEmployeeBinding
import com.b.alkhatib.databasefinalproject.db.Firebase
import com.b.alkhatib.databasefinalproject.model.Employee
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore

class GetAllEmployee : AppCompatActivity() {
    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGetAllEmployeeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = com.google.firebase.ktx.Firebase.firestore
        //al firebase = Firebase
        val employeeList = ArrayList<Employee>()
        db.collection("employee")
            .get()
            .addOnSuccessListener { querySnapshot ->
                Toast.makeText(this,"Employee Data Download", Toast.LENGTH_LONG).show()

                for( document in querySnapshot){
                    var id = document.get("id").toString()
                    var name = document.get("name").toString()
                    var salary = document.get("salary").toString()
                    var emb = Employee(id, name, salary)

                    employeeList.add(emb)
                }
                Log.e("hzm", employeeList.toString())

                val employeeAdapter = EmployeeAdapter(employeeList)
                binding.rvEmployee.adapter = employeeAdapter
                binding.rvEmployee.layoutManager = LinearLayoutManager(this)
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this,"Get All Employee Failed", Toast.LENGTH_LONG).show()
            }







    }

}