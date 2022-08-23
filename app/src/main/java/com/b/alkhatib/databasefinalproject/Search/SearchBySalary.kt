package com.b.alkhatib.databasefinalproject.Search

import android.R
import android.app.ProgressDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.b.alkhatib.databasefinalproject.EmployeeAdapter
import com.b.alkhatib.databasefinalproject.databinding.ActivitySearchByNameBinding
import com.b.alkhatib.databasefinalproject.databinding.ActivitySearchBySalaryBinding
import com.b.alkhatib.databasefinalproject.db.Firebase
import com.b.alkhatib.databasefinalproject.model.Employee
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore

class SearchBySalary : AppCompatActivity() {
    lateinit var db: FirebaseFirestore
    var fire = Firebase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySearchBySalaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = com.google.firebase.ktx.Firebase.firestore


        binding.btnSearch.setOnClickListener {

            if(binding.etSearchSalary.text.isNotEmpty()){
                val salary = binding.etSearchSalary.text.toString()
                var spennerChecked = binding.spinner.selectedItem

                when (spennerChecked){
                    "Greater Than" -> whereGreaterThan(binding,salary)
                    "Greater Than Or Equal" -> whereGreaterThanOrEqual(binding,salary)
                    "Less Than" -> whereLessThan(binding,salary)
                    "Less Than Or Equal" -> whereLessThanOrEqual(binding,salary)
                    "Equal" -> whereEqual(binding,salary)
                    "Not Equal" -> whereNotEqual(binding,salary)

                    else -> Toast.makeText(this, "Please Select a Operation", Toast.LENGTH_SHORT).show()
                }
                fire.showDialog(this)


            }else{
                Toast.makeText(this, "Please Fill Fields And Select a Operation", Toast.LENGTH_SHORT).show()
            }



        }
    }

    fun whereGreaterThan(binding: ActivitySearchBySalaryBinding, salary:String){
        //**********
        val employeeList = ArrayList<Employee>()

        db.collection("employee").whereGreaterThan("salary",salary) // اكبر من او يساوي
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
                    Log.e("hzm","Arrey :"+employeeList.toString())
                    Log.e("hzm","querySnapshot :"+querySnapshot.toString())
                    if(employeeList != null) {
                        fire.dismissDialog()

                    }else{
                        Toast.makeText(this, "Not Found -_-", Toast.LENGTH_SHORT).show()
                        fire.dismissDialog()

                    }

                }
            }
            .addOnFailureListener { exception ->
                Log.e("hzm", "getAllIdByWhere"+exception.message.toString())
            }
        //**********
    }
    fun whereGreaterThanOrEqual(binding: ActivitySearchBySalaryBinding, salary:String){
        //**********
        val employeeList = ArrayList<Employee>()

        db.collection("employee").whereGreaterThanOrEqualTo("salary",salary) // اكبر من او يساوي
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
                    if(querySnapshot != null) {
                        fire.dismissDialog()

                    }else{
                        Toast.makeText(this, "Not Found -_-", Toast.LENGTH_SHORT).show()
                        fire.dismissDialog()

                    }

                }
            }
            .addOnFailureListener { exception ->
                Log.e("hzm", "getAllIdByWhere"+exception.message.toString())
            }
        //**********
    }
    fun whereLessThan(binding: ActivitySearchBySalaryBinding, salary:String){
        val employeeList = ArrayList<Employee>()

        db.collection("employee").whereLessThan("salary",salary) // اكبر من او يساوي
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
                    if(querySnapshot != null) {
                        fire.dismissDialog()
                    }else{
                        Toast.makeText(this, "Not Found -_-", Toast.LENGTH_SHORT).show()
                        fire.dismissDialog()

                    }

                }
            }
            .addOnFailureListener { exception ->
                Log.e("hzm", "getAllIdByWhere"+exception.message.toString())
            }
    }
    fun whereLessThanOrEqual(binding: ActivitySearchBySalaryBinding, salary:String){
        val employeeList = ArrayList<Employee>()

        db.collection("employee").whereLessThanOrEqualTo("salary",salary) // اكبر من او يساوي
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
                    if(querySnapshot != null) {
                        fire.dismissDialog()
                    }else{
                        Toast.makeText(this, "Not Found -_-", Toast.LENGTH_SHORT).show()
                        fire.dismissDialog()

                    }

                }
            }
            .addOnFailureListener { exception ->
                Log.e("hzm", "getAllIdByWhere"+exception.message.toString())
            }
    }
    fun whereEqual(binding: ActivitySearchBySalaryBinding, salary:String){
        val employeeList = ArrayList<Employee>()

        db.collection("employee").whereEqualTo("salary",salary) // اكبر من او يساوي
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
                    if(querySnapshot != null) {
                        fire.dismissDialog()
                    }else{
                        Toast.makeText(this, "Not Found -_-", Toast.LENGTH_SHORT).show()
                        fire.dismissDialog()

                    }

                }
            }
            .addOnFailureListener { exception ->
                Log.e("hzm", "getAllIdByWhere"+exception.message.toString())
            }
    }
    fun whereNotEqual(binding: ActivitySearchBySalaryBinding, salary:String){
        val employeeList = ArrayList<Employee>()

        db.collection("employee").whereNotEqualTo("salary",salary) // اكبر من او يساوي
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
                    if(querySnapshot != null) {
                        fire.dismissDialog()
                    }else{
                        Toast.makeText(this, "Not Found -_-", Toast.LENGTH_SHORT).show()
                        fire.dismissDialog()

                    }

                }
            }
            .addOnFailureListener { exception ->
                Log.e("hzm", "getAllIdByWhere"+exception.message.toString())
            }
    }



}