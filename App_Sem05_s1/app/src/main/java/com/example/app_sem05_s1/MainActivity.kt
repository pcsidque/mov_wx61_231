package com.example.app_sem05_s1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var contacts = ArrayList<Contact>()

    //creamos el adapter
    var contactAdapter = ContactAdapter(contacts)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadContacts()
        initView()
    }

    private fun initView() {
        val rvContact = findViewById<RecyclerView>(R.id.rvContact)

        rvContact.adapter = contactAdapter
        rvContact.layoutManager = LinearLayoutManager(this)
    }

    private fun loadContacts() {
        contacts.add(Contact("Americo", "11223344"))
        contacts.add(Contact("Alan", "11255344"))
        contacts.add(Contact("Alex", "11226644"))
        contacts.add(Contact("Alma", "99223344"))
        contacts.add(Contact("Aaron", "77223344"))
        contacts.add(Contact("Axel", "11250044"))
        contacts.add(Contact("Alexandro", "16726644"))
        contacts.add(Contact("Alldo", "97823344"))
    }
}