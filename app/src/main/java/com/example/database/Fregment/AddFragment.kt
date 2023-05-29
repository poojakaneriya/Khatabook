package com.example.database.Fregment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.database.Database
import com.example.database.Model
import com.example.database.R
import com.example.database.databinding.FragmentAddBinding

class AddFragment : Fragment() {


    lateinit var binding : FragmentAddBinding

    var isExpenses = 0
    lateinit var dbHelper : Database

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dbHelper = Database(context)
        binding = FragmentAddBinding.inflate(layoutInflater)

        binding.choiceIncome.setOnClickListener {
            isExpenses = 0
        }
        binding.choiceExpenses.setOnClickListener {
            isExpenses = 1
        }
        binding.submit.setOnClickListener {
            var amt = binding.income.text.toString().toInt()
            var category = binding.category.text.toString()
            var notes = binding.notes.text.toString()
            var extra = binding.extra.text.toString()

            var model = Model(1,amt,category,notes, isExpenses)
            dbHelper.addTrans(model)

            binding.income.setText("")
            binding.category.setText("")
            binding.notes.setText("")
            binding.extra.setText("")



        }
        return binding.root
    }
}

