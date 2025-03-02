package br.ufg.fct

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.compose.ui.window.WindowPlacement

fun main() = application {
    val windowState = rememberWindowState(
        placement = WindowPlacement.Fullscreen // Define a janela em fullscreen
    )
    Window(
        onCloseRequest = ::exitApplication,
        title = "Painel Interativo FCT/UFG",
        state = windowState,
        undecorated = true // Remove a barra de título e bordas
    ) {
        MaterialTheme {
            MainScreen()
        }
    }
}
