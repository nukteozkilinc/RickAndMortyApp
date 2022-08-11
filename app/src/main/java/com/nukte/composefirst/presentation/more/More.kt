package com.nukte.composefirst.presentation.more

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nukte.composefirst.R
import com.nukte.composefirst.ui.theme.PastelGreen


@Composable
fun MoreScreen(
    openUser : () -> Unit,
)
{
    MoreScreen(
        viewModel = hiltViewModel(),
        openUser = openUser
    )
}

@Composable
internal fun MoreScreen(
    viewModel: MoreViewModel,
    openUser: () -> Unit
){
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PastelGreen),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            item{
                MoreScreenList(viewModel = viewModel)
            }
        }

        Box(modifier = Modifier.fillMaxWidth()) {
            Surface(
                modifier = Modifier
                    .align(Alignment.TopStart)
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

@Composable
fun MoreScreenList(viewModel: MoreViewModel){


        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                modifier= Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.10f)
                    .clip(
                        RoundedCornerShape(8.dp)
                    ),
                painter = painterResource(
                    id = R.drawable.logo),
                contentDescription = "logo")

            Spacer(modifier = Modifier.height(10.dp))
        }
        Spacer(modifier = Modifier.size(10.dp))
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ){
            Text(
                text = "Episodes",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.SemiBold)
            Text(viewModel.state.characterDetail?.episode.toString())
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "Origin",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.SemiBold)
            Text(text = viewModel.state.characterDetail?.origin?.name.toString())
            Text(text = viewModel.state.characterDetail?.origin?.url.toString())
        }
}
