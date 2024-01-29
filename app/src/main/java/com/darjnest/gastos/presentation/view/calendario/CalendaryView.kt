package com.darjnest.gastos.presentation.view.calendario

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun CalendarioViewPreview(){
    CalendarioView(navController = rememberNavController())
}

@Composable
fun CalendarioView(
    navController: NavController
){

}