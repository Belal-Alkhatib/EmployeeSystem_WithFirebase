package com.b.alkhatib.databasefinalproject

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b.alkhatib.databasefinalproject.databinding.EmployeeItemBinding
import com.b.alkhatib.databasefinalproject.model.Employee


class EmployeeAdapter(var data: ArrayList<Employee>): RecyclerView.Adapter<EmployeeAdapter.MyViewHolder>() {
    lateinit var context: Context

    class MyViewHolder(val cardViewBinding: EmployeeItemBinding): RecyclerView.ViewHolder(cardViewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context
        val binding : EmployeeItemBinding
                = EmployeeItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.cardViewBinding.apply {
           tvId.text = data[position].id.toString()
           tvName.text = data[position].name.toString()
           tvSalary.text = data[position].salary.toString()
        }


    }

    override fun getItemCount(): Int {
        return data.size
    }




}