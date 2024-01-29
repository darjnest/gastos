package com.darjnest.gastos.presentation.view.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.darjnest.gastos.presentation.view.menu.MenuView
import com.darjnest.gastos.presentation.view.utils.button.FloatingActionButtonView
import com.darjnest.gastos.ui.theme.RedHome
import java.util.UUID

@Preview
@Composable
fun HomeViewPreview() {
    HomeView(navController = rememberNavController())
}

@Composable
fun HomeView(navController: NavController) {

    val id = UUID.randomUUID()

    Scaffold(
        topBar = { MenuView(navController) },
        floatingActionButton = { FloatingActionButtonView() },
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = RedHome,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "ULTIMOS GASTOS",
                        fontSize = 20.sp,
                        color = RedHome,
                        modifier = Modifier
                            .weight(1f)
                            .clickable {

                            }
                    )

                    Text(
                        text = "ENTRADA",
                        fontSize = 20.sp,
                        color = RedHome,
                        modifier = Modifier.clickable {


                        }
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        tint = RedHome,
                        modifier = Modifier.size(20.dp)
                    )
                }


            }
        }
    }
}