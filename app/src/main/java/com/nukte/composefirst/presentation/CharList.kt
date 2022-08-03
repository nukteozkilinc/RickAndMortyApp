package com.nukte.composefirst.presentation

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nukte.composefirst.model.Characters

interface CharList {

    companion object{
        @Composable
        fun Content(character : Characters) {
            //Item(character)
        }
    }
}

/*
@Composable
fun ItemImage(image : Characters, modifier : Modifier){
    Image(
        painter = painterResource(id = image.image),
        contentDescription = null,
        contentScale = ContentScale.Crop,// en/boy oranını koruyarak boyutu ayarlar
        modifier = modifier
    )
}

*/
/*
@Composable
fun Item(character : Characters){
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        androidx.constraintlayout.compose.ConstraintLayout {
            val (image, column) = createRefs()

            /*ItemImage(image = character, modifier = Modifier
                .padding(top = 8.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    centerHorizontallyTo(parent)
                }
                .size(48.dp)
            )*/
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(column) {
                        top.linkTo(image.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = androidx.constraintlayout.compose.Dimension.fillToConstraints
                    }
                    .animateContentSize()
            ) {
                /* if(isExpanded){*/
                Text(text = character.name, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
               /* Text(
                    text = movie.description,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(end = 16.dp),
                    maxLines = 6
                )*/
                /*}else{
                    Text(text = movie.title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = movie.description, maxLines = 2)
                }*/
            }
        }
    }


}*/




