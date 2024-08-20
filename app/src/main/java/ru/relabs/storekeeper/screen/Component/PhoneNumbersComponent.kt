package ru.relabs.storekeeper.screen.Component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneNumbersComponent(phoneNumbers: MutableList<String>) {
    Column {
        phoneNumbers.forEachIndexed { index, phoneNumber ->
            var editedValue by remember { mutableStateOf(phoneNumber) }
            Row {
                TextField(value = editedValue, onValueChange = { editedValue = it })
                Button(onClick = {
                    phoneNumbers[index] = editedValue
                    sendPhoneNumberToSirius(editedV alue) // Отправка номера телефона в Сириус
                }) {
                    Text("OK")
                }
            }
        }

        if (phoneNumbers.size < 3) {
            Button(onClick = {
                phoneNumbers.add("")
            }) {
                Text("Добавить телефон")
            }
        }
    }
}

fun sendPhoneNumberToSirius(phoneNumber: String) {
    // Логика отправки номера телефона в Сириус
}