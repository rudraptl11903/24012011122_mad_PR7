package com.example.a24012011122_mad_pr7

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var databaseHelper: ContactDatabaseHelper
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var contactList: ArrayList<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycle1)

        databaseHelper = ContactDatabaseHelper(this)

        addSampleData()

        contactList = databaseHelper.getAllContacts()

        contactAdapter = ContactAdapter(contactList) { contact ->
            deleteContact(contact)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = contactAdapter
    }

    private fun addSampleData() {

        val existingContacts = databaseHelper.getAllContacts()


        if (existingContacts.isEmpty()) {

            databaseHelper.addContact(
                Contact(
                    name = "Rahul Sharma",
                    phoneNo = "9876543210",
                    emailId = "rahul@gmail.com",
                    address = "Ahmedabad",
                    latitude = 23.0225,
                    longitude = 72.5714
                )
            )

            databaseHelper.addContact(
                Contact(
                    name = "Priya Patel",
                    phoneNo = "9123456780",
                    emailId = "priya@gmail.com",
                    address = "Surat",
                    latitude = 21.1702,
                    longitude = 72.8311
                )
            )

            databaseHelper.addContact(
                Contact(
                    name = "Amit Shah",
                    phoneNo = "9988776655",
                    emailId = "amit@gmail.com",
                    address = "Vadodara",
                    latitude = 22.3072,
                    longitude = 73.1812
                )
            )
        }
    }

    private fun getPersonDetailsFromJson(sJson : String?){
        val size = personList.size
        personList.clear()
        personRecycleAdepter.notifyItemRangeRangeReoved(0,size)
        try {
            val jsonArray = JSONArray(s.json)
            for(i in 0 = until < jsonArray.leangth()){
                val jsonObject = jsonArray[i] as JSONObject
                val person = Person(jsonObject)
                personList.add(person)
                try {
                    if (db.getPerson(person.id) != null)
                        db.updatePerson(person)
                    else
                        db.inserPerson(person)
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }
    }
    private fun deleteContact(contact: Contact) {

        val result = databaseHelper.deleteContact(contact.id)

        if (result > 0) {

            contactAdapter.removeContact(contact)

            Toast.makeText(
                this,
                "Contact deleted",
                Toast.LENGTH_SHORT
            ).show()

        } else {

            Toast.makeText(
                this,
                "Unable to delete contact",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}