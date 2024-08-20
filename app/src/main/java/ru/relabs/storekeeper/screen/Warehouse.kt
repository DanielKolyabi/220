package ru.relabs.storekeeper.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.clickable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter


@OptIn( ExperimentalMaterial3Api::class)
@Composable

fun WarehouseTile(
    warehouseName: String,
    receiverName: MutableState<String>,
    receiverPhoneNumbers: MutableList<MutableState<String>>,
    publications: List<String>,
    loadingTime: String,
    unloadingTime: String,
    onConfirmation: () -> Unit,
    onEditNameConfirmation: () -> Unit,
    onEditPhoneConfirmation: (Int) -> Unit,
    onAddPhone: () -> Unit,
    onEditPublication: () -> Unit,
    onNavigateToScreen2: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        Text(
            text = warehouseName,
            modifier = Modifier.clickable { expanded = !expanded }
        )
        if (expanded) {
            TextField(
                value = receiverName.value,
                onValueChange = { receiverName.value = it }
            )
            Button(onClick = onEditNameConfirmation) {
                Text("OK")
            }
            receiverPhoneNumbers.forEachIndexed { index, phoneNumber ->
                TextField(
                    value = phoneNumber.value,
                    onValueChange = { phoneNumber.value = it }
                )
                Button(onClick = { onEditPhoneConfirmation(index) }) {
                    Text("OK")
                }
            }
            if (receiverPhoneNumbers.size < 3) {
                Button(onClick = onAddPhone) {
                    Text("+ Add Phone")
                }
            }
            publications.forEach { publication ->
                Text(text = publication, modifier = Modifier.clickable { onEditPublication() })
            }
            Text(text = "Loading Time: $loadingTime")
            Text(text = "Unloading Time: $unloadingTime", modifier = Modifier.clickable { onNavigateToScreen2() })
        }
    }
}


