package com.darjnest.gastos.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.darjnest.gastos.presentation.view.calendario.CalendarioView
import com.darjnest.gastos.presentation.view.details.detalles.DetailsView
import com.darjnest.gastos.presentation.view.home.HomeView
import com.darjnest.gastos.presentation.view.maps.MapsView
import com.darjnest.gastos.presentation.view.menu.MenuView
import com.darjnest.gastos.presentation.view.saldos.entrada.EntradaView
import com.darjnest.gastos.presentation.view.saldos.gastos.GastoView

@Composable
fun GastoNavigation(navController: NavController){

    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = GastoScreen.Home.name){
        composable(GastoScreen.Home.name){
            HomeView(navController = navController)
        }
        composable(GastoScreen.Ingreso.name +"?id={id}",
            arguments = listOf(navArgument("id"){defaultValue = ""})
        ){
            val id = it.arguments?.getString("id") ?: ""
            EntradaView(id = id,navController)
        }
        composable(GastoScreen.Salida.name +"?id={id}",
            arguments = listOf(navArgument("id"){defaultValue = ""})
        ){
            val id = it.arguments?.getString("id") ?: ""
            GastoView(id = id,navController)
        }
        composable(GastoScreen.Detalles.name){
            DetailsView(navController = navController)
        }
        composable(GastoScreen.Calendario.name){
            CalendarioView( navController = navController)
        }
        composable(GastoScreen.Maps.name){
            MapsView(navController = navController)
        }
        composable(GastoScreen.Menu.name){
            MenuView(navController = navController)
        }
       
        


    }
}