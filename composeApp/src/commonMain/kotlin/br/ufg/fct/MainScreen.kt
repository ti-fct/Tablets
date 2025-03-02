package br.ufg.fct

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.DrawerValue
import androidx.compose.material.ModalDrawer
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun AppTopBar(onMenuClick: () -> Unit) {
    TopAppBar(
        backgroundColor = Color(0xFF2196F3),
        contentColor = Color.White,
        title = {
            // Centraliza o título usando um Box que ocupa a largura total
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Painel Interativo FCT/UFG",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        }
    )
}

@Composable
fun DrawerItem(icon: String, label: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Text(text = icon, fontSize = 20.sp)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = label, fontSize = 16.sp)
    }
}

@Composable
fun AppDrawer(onItemSelected: (String) -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()  // O menu ocupará todo o espaço vertical disponível
            .background(Color(0xFFF0F0F0))
    ) {
        DrawerItem(icon = "🏠", label = "Página Inicial") { onItemSelected("home") }
        DrawerItem(icon = "🏛️", label = "Conheça o Campus") { onItemSelected("campus") }
        DrawerItem(icon = "🚌", label = "Linha de Ônibus") { onItemSelected("onibus") }
        DrawerItem(icon = "⏰", label = "Horário de Aulas") { onItemSelected("horario") }
        DrawerItem(icon = "👥", label = "Equipe FCT/UFG") { onItemSelected("equipe") }
        DrawerItem(icon = "🌱", label = "Ações de Extensão") { onItemSelected("extensao") }
    }
}

@Composable
fun MainScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalDrawer(
        drawerContent = {
            AppDrawer { selected ->
                // Tratar a seleção dos itens do menu conforme necessário.
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                AppTopBar(onMenuClick = {
                    coroutineScope.launch { drawerState.open() }
                })
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Placeholder para o feed de notícias
                Text(
                    text = "Feed de Notícias (a ser implementado)",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}
