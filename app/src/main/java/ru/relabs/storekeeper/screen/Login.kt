
package ru.relabs.storekeeper.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import ru.relabs.storekeeper.data.api.ApiService
import ru.relabs.storekeeper.data.api.LoginData
import ru.relabs.storekeeperapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthorizationScreen() {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    var rememberPassword by remember { mutableStateOf(true) }


    Column(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Row(
            Modifier
                .background(Blue)
                .fillMaxWidth()


        ) {
            Spacer(modifier = Modifier.height(20.dp)
            )
            Text(
                text = "Вход",
                color = White,
                fontSize= 6.em,

                )
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                modifier = Modifier.size(250.dp),
                contentDescription = "logo"
            )
        }

        TextField(
            value = login,
            onValueChange = { login = it },
            label = { Text("Логин") }
        )
        Spacer(modifier = Modifier.height(20.dp)
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Пароль") }
        )
        Spacer(modifier = Modifier.height(20.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {




            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = rememberPassword,
                    onCheckedChange = { rememberPassword = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colorScheme.primary,
                        uncheckedColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                )
                Text(
                    text = "Запомнить пароль",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp)
        )
        Button(onClick = {

        }) {
            Text("Войти")
        }
    }
}
