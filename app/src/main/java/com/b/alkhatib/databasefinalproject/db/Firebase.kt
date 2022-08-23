package com.b.alkhatib.databasefinalproject.db

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.b.alkhatib.databasefinalproject.EmployeeAdapter
import com.b.alkhatib.databasefinalproject.GetAllEmployee
import com.b.alkhatib.databasefinalproject.MainActivity
import com.b.alkhatib.databasefinalproject.R
import com.b.alkhatib.databasefinalproject.databinding.ActivityGetAllEmployeeBinding
import com.b.alkhatib.databasefinalproject.model.Employee
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.getField

class Firebase {


    companion object{
        lateinit var progressDialog: ProgressDialog


        fun addUserToDB(context: Context, db:FirebaseFirestore, employee:Employee){
             val id = employee.id
             val name = employee.name
             val salary = employee.salary
            val emb = hashMapOf("id" to id, "name" to name, "salary" to salary)
            db.collection("employee").document(id.toString())                                          //دلة تضيفلك الكوليكشن في حال مش موجود
                .set(emb)// دالة لاضافة دوكيومنت على الكوليكشن
                .addOnSuccessListener { documentReference ->
                    Log.e("hzm","Employee Add")
                    Toast.makeText(context,"Employee Added Successful",Toast.LENGTH_LONG).show()
                    val i = Intent(context, MainActivity::class.java)
                    context.startActivity(i)
                }
                .addOnFailureListener { exception ->
                    Log.e("hzm","Employee Added Failed")
                    Toast.makeText(context,"Employee Added Failed",Toast.LENGTH_LONG).show()
                    val i = Intent(context, MainActivity::class.java)
                    context.startActivity(i)
                }
        }

        fun showDialog(context:Context){
            progressDialog = ProgressDialog(context)
            progressDialog.setMessage("loading data")
            progressDialog.setCancelable(false)
            progressDialog.show()
        }

        fun dismissDialog(){
           // if(progressDialog.isShowing)
                progressDialog.dismiss()
        }

//********************************* **************************** ********************

       //  fun getAllEmployee(context: Context, db:FirebaseFirestore) : ArrayList<Employee>{


       // }

    }
}