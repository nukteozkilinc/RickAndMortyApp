package com.nukte.composefirst.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nukte.composefirst.R
import com.nukte.composefirst.navigation.AppNavigation
import com.nukte.composefirst.navigation.Screen
import com.nukte.composefirst.presentation.home.HomeScreen

@Composable
fun DrawerHeader (){
    Box(
        modifier= Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(
                id = R.drawable.logo),
            contentDescription = "logo")
    }
}

@Composable
fun DrawerBody(
    items : List<MenuItem>,
    modifier: Modifier = Modifier,
   // itemTextStyle: TextStyle ,
    onItemClick : (Screen) -> Unit
){
    LazyColumn(modifier){
        items(items){ item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item.screen)
                    }
                    .padding(16.dp)
            ){
               // Icon(imageVector)
                Text(text = item.title,
                modifier = Modifier.weight(1f)
                )
            }
        }
    }
}