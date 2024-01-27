package com.darjnest.gastos.view.menu

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darjnest.gastos.view.util.logo.LogoView
import com.darjnest.gastos.view.util.text.TextView

@Preview
@Composable
fun MenuViewPreview(){
    MenuView()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuView(){

    CenterAlignedTopAppBar(
        title = {
            Row(modifier = Modifier.fillMaxWidth()) {
                LogoView()
                Spacer(modifier = Modifier.size(24.dp))
                TextView()
            }
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Salir")

            }
        }
    )
}

