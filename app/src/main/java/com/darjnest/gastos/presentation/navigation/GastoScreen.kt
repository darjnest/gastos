package com.darjnest.gastos.presentation.navigation

import java.lang.IllegalArgumentException

enum class GastoScreen {

    Home,
    Ingreso,
    Salida,
    Menu,
    Detalles,
    Calendario,
    Maps,
    Search;

    companion object{

        fun fromRoute(route:String?) : GastoScreen
        = when (route?.substringBefore("/")){
            Home.name -> Home
            Menu.name -> Menu
            Ingreso.name -> Ingreso
            Salida.name -> Salida
            Detalles.name -> Detalles
            Calendario.name -> Calendario
            Maps.name -> Maps
            Search.name -> Search
            null -> Home
            else -> throw IllegalArgumentException("Route $route is not recognize")
        }
    }
}