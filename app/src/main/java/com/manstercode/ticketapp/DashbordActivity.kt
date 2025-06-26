package com.manstercode.ticketapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.manstercode.ticketapp.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup view binding
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the user's first name from SharedPreferences
        val sharedPref = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
        val firstName = sharedPref.getString("first_name", "User")

        // Show greeting on the dashboard
        binding.tvGreeting.text = "Hello, $firstName"

        // List of features on the dashboard
        val features = listOf(
            Feature("REPORT CRIME", R.drawable.ic_report, ReportCrimeActivity::class.java),
            Feature("EPS TICKETS", R.drawable.ic_ticket, EpsTicketsActivity::class.java),
            Feature("LOST AND FOUND", R.drawable.ic_ticket, LostFoundActivity::class.java),
            Feature("MISSING PERSONS", R.drawable.ic_ticket, MissingPersonsActivity::class.java),
            Feature("SEARCH STATION", R.drawable.ic_ticket, SearchStationActivity::class.java),
            Feature("NEAR BY STATIONS", R.drawable.ic_report, NearbyStationsActivity::class.java)
        )

        // Initialize RecyclerView with GridLayout
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = FeatureAdapter(features) { feature ->
            val intent = Intent(this, feature.activityClass)
            startActivity(intent)
        }
    }

}