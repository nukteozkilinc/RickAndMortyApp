package com.nukte.composefirst.presentation.detail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.nukte.composefirst.R
import com.nukte.composefirst.model.Characters
import com.nukte.composefirst.presentation.home.ItemImage
import com.nukte.composefirst.ui.theme.*
import java.lang.Math.random
import kotlin.random.Random

@Composable
fun DetailScreen(
    openUser : () -> Unit
    //navController: NavController,
    //backStackEntry: NavBackStackEntry)
)
{
    DetailScreen(
        viewModel = hiltViewModel(),
        openUser = openUser
    )
    /*Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Hello")}*/
   /* val charId = backStackEntry.arguments?.getInt("charId") ?: -1
    val viewModel: DetailViewModel = hiltViewModel()
    viewModel.getCharacterbyId(charId)
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Hello $charId")
    }*/
}

@Composable
internal fun DetailScreen(
    viewModel: DetailViewModel,
    openUser : () -> Unit

){
    /*Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Hello $showDetails")
    }*/
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PastelGreen),
       verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f),
            shape = RoundedCornerShape(
                bottomStart = 50.dp, bottomEnd = 50.dp
            ),
            backgroundColor = DarkPastelGreen
        ){
            Column {
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    modifier= Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.15f)
                        //.align(Alignment.Center)
                        .clip(
                            RoundedCornerShape(8.dp)
                        ),
                    painter = painterResource(
                        id = R.drawable.logo),
                    contentDescription = "logo")

                Spacer(modifier = Modifier.height(10.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ){
                        Image( //Geçici foto
                            modifier= Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.5f)
                                .align(Alignment.Center)
                                .clip(
                                    RoundedCornerShape(8.dp)
                                ),
                            painter = painterResource(
                                id = R.drawable.icon_5f563b54cb9c8_6182_w256),
                            contentDescription = "logo")
                    }
            }
    }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = viewModel.characterId.toString(),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .size(14.dp)
                    .clip(CircleShape)
                    .background(Color.Cyan)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "Status",
            )
        }
        Spacer(modifier = Modifier.size(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Karakter Species")
                Text(text = "Species")
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Karakter Gender")
                Text(text = "Gender")
            }
        }
        Spacer(modifier = Modifier.size(10.dp))
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
                ){
            Text(text = "Karakter Location")
            Text("Location")
        }
        Box(modifier = Modifier.fillMaxWidth()) {
            Surface(
                modifier = Modifier
                    .align(Alignment.TopStart) //?????????????
                    .padding(8.dp),
                shape = CircleShape
            ) {
                IconButton(
                    onClick = openUser,
                    modifier = Modifier.padding(4.dp)) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "navigate back"
                    )
                }
            }
        }

    }
}
