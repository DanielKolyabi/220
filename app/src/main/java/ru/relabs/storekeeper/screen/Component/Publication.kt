package ru.relabs.storekeeper.screen.Component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


data class Publication(val name: String, val day: String, val route: String)

@Composable
fun PublicationsListComponent(publications: List<Publication>) {
    Column {
        publications.groupBy { it.route }.forEach { (route, pubs) ->
            Text(text = "Route: $route", style = MaterialTheme.typography.headlineSmall)
            pubs.forEach { pub ->
                Text(text = "${pub.name} (${pub.day})")
            }
        }
    }
}