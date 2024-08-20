package ru.relabs.storekeeper

sealed class Routes(val route: String) {
    object Login : Routes("Login")

}

