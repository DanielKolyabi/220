package ru.relabs.storekeeper.screen.Component

import androidx.compose.foundation.clickable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FioComponent(fio: MutableState<String>) {
    var editing by remember { mutableStateOf(false) }
    var editedValue by remember { mutableStateOf(fio.value) }

    if (editing) {
        TextField(value = editedValue, onValueChange = { editedValue = it })
        Button(onClick = {
            fio.value = editedValue
            sendFioToSirius(editedValue) // Отправка ФИО в Сириус
            editing = false
        }) {
            Text("OK")
        }
    } else {
        Text(text = fio.value, modifier = Modifier.clickable { editing = true })
    }
}

fun sendFioToSirius(fio: String) {
    // Логика отправки ФИО в Сириус
}