package com.darjnest.gastos.view.saldos.entrada

import android.preference.PreferenceActivity.Header
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darjnest.gastos.R
import com.darjnest.gastos.util.rememberScreenSize
import com.darjnest.gastos.view.util.header.HeaderView
import com.darjnest.gastos.view.util.text.InputTextView

@Preview
@Composable
fun EntradaViewPreview(){

    EntradaView()
}

@Composable
fun EntradaView(){

    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {

        val sizeDevice = rememberScreenSize()
        var marginTop = sizeDevice.width * 0.10f


        Column(
            modifier = Modifier.fillMaxSize()
        ){

            HeaderView(
                title = "ENTRADA",
                subTitle = "ENTRADA DE DINERO",
                tipe = "",
                imageResource = R.drawable.entrada,
                marginTop = marginTop
            )

            Spacer(modifier = Modifier.padding(top = marginTop))

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(2f)
                    .verticalScroll(rememberScrollState())
            ){
                InputTextView(
                    hint = "SALDO",
                    singleLine = true,
                    selectedValue = ,
                    onValueChange = )
            }

        }

    }


}