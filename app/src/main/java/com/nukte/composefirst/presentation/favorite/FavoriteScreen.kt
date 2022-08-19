package com.nukte.composefirst.presentation.favorite

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nukte.composefirst.model.Characters
import com.nukte.composefirst.presentation.home.ItemImage
import com.nukte.composefirst.ui.theme.PastelGreen


@ExperimentalFoundationApi
@Composable
fun FavoriteScreen(
    showDetail:(charId:Int) -> Unit,
) {

    FavoriteScreen(
        showDetail = showDetail,
        viewModel = hiltViewModel())

}

@Composable
internal fun FavoriteScreen(
    showDetail:(charId:Int) -> Unit,
    viewModel : FavoriteViewModel,
){
    val viewState by viewModel.characterListFlow.collectAsState()

    Title(viewState.characterList,viewModel,showDetail)

}


@Composable
fun Title(characters : List<Characters>,viewModel: FavoriteViewModel,showDetail:(charId:Int) -> Unit,){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 300.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(characters) {
            Item(character = it,showDetail,viewModel)
        }
    }
}


@Composable
fun Item(
    character: Characters,
    // openUser: () -> Unit,
    showDetail:(charId:Int) -> Unit,
    favoriteViewModel: FavoriteViewModel,
    alignment: Alignment.Horizontal = Alignment.Start,

    ) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            .clickable { character.id?.let { showDetail(it) } }
    ) {
        val color = when (character.status) {
            "Alive" -> Color.Green
            "Dead" -> Color.Red
            else -> Color.Gray
        }
        Row {
            character.image?.let {
                ItemImage(image = it, modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(0.40f)
                )
            }
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .animateContentSize()
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = alignment
            ) {
                character.name?.let {
                    Text(text = it,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        overflow = TextOverflow.Ellipsis)
                }
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
                    Spacer(modifier = Modifier.width(100.dp))

                }
                Spacer(modifier = Modifier.width(100.dp))
                Button(
                    modifier = Modifier.padding(5.dp)
                        .background(PastelGreen),
                    onClick = {favoriteViewModel.deleteChar(character)}
                ){
                    Text(text = "Sil")
                }
            }
        }
    }
}