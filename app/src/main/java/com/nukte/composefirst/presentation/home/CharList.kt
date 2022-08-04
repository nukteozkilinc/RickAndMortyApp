package com.nukte.composefirst.presentation.home

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.nukte.composefirst.model.Characters
import com.nukte.composefirst.navigation.NavRoutes


@Composable
fun Content(character: List<Characters>, navController: NavController) {
    //Item(character)
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 300.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ){
        items(character){
                    ItemCard(character = it,navController)
        }
    }
}


@Composable
fun ItemImage(image : Characters, modifier : Modifier){
    Image(
        painter = rememberAsyncImagePainter(image.image),
        contentDescription = null,
        contentScale = ContentScale.Crop,// en/boy oranını koruyarak boyutu ayarlar
        modifier = modifier,
        alignment = Alignment.Center
    )
}


@Composable
fun ItemCard(
    character : Characters,
    navController: NavController,
    alignment: Alignment.Horizontal=Alignment.Start
    ){
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable{navController.navigate(NavRoutes.Detail.route)}
        ,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        val color = when (character.status){
            "Alive" -> Color.Green
            "Dead" -> Color.Red
             else -> Color.Gray
         }

            Row {
                ItemImage(image = character, modifier = Modifier
                    .size(150.dp)
                    .fillMaxWidth(0.35f)

                )

                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .animateContentSize()
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    horizontalAlignment = alignment
                ) {
                    character.name?.let { Text(text = it, fontWeight = FontWeight.SemiBold, fontSize = 16.sp, overflow = TextOverflow.Ellipsis) }
                    Spacer(modifier = Modifier.height(8.dp))
                    character.origin?.name?.let { Text(text = it) }
                    Spacer(modifier = Modifier.height(8.dp))
                    character.species?.let { Text(text = it) }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Box(modifier = Modifier
                            .size(10.dp)
                            .background(color = color, shape = CircleShape)
                        )
                        character.status?.let { Text(text = it) }
                    }
                }
            }
    }
}



