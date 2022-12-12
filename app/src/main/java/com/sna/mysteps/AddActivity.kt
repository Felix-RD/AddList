package com.sna.mysteps

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.sna.mysteps.databinding.ActivityAddBinding
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {


    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAddUser.setOnClickListener { addUser() }

    }

    private fun addUser(){
            val firstName = binding.edFirstName.text.toString()
            val lastName = binding.edLastName.text.toString()

        lifecycleScope.launch {
             val user = User(firstName = firstName, lastName = lastName)
             AppDatabase(this@AddActivity).getUserDao().addUser(user)
            finish()
        }
    }
}