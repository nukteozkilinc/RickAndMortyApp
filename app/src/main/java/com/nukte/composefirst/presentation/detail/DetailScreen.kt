package com.nukte.composefirst.presentation.detail


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.nukte.composefirst.R
import com.nukte.composefirst.ui.theme.*

@Composable
fun DetailScreen(
    openUser : () -> Unit,
    showMore:(charId:Int) -> Unit,
)
{
    DetailScreen(
        viewModel = hiltViewModel(),
        openUser = openUser,
        showMore = showMore
    )
}

@Composable
internal fun DetailScreen(
    viewModel: DetailViewModel,
    openUser : () -> Unit,
    showMore:(charId:Int) -> Unit,

){
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
                    ItemDetailImage(
                        image = viewModel.state.characterDetail?.image.toString(),
                        modifier = Modifier
                            .height(270.dp)
                            .fillMaxWidth(0.70f)
                            .align(Alignment.Center)
                            .clip(
                                RoundedCornerShape(8.dp)
                            )
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = viewModel.state.characterDetail?.name.toString(),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            val color = when (viewModel.state.characterDetail?.status.toString()) {
                "Alive" -> Color.Green
                "Dead" -> Color.Red
                else -> Color.Gray
            }
            Box(
                modifier = Modifier
                    .size(14.dp)
                    .clip(CircleShape)
                    .background(color)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = viewModel.state.characterDetail?.status.toString(),
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.size(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = viewModel.state.characterDetail?.species.toString(),
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.SemiBold)
                Text(text = "Species")
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = viewModel.state.characterDetail?.gender.toString(),
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.SemiBold
                    )
                Text(text = "Gender")
            }
        }
        Spacer(modifier = Modifier.size(10.dp))
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ){
            Text(
                text = viewModel.state.characterDetail?.location?.name.toString(),
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.SemiBold)
            Text("Location")
        }
            Box(modifier = Modifier.fillMaxWidth()) {
                Surface(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp),
                    shape = CircleShape
                ) {
                    IconButton(
                        onClick = { showMore(viewModel.state.characterDetail?.id?.toInt() ?: -1) },
                        modifier = Modifier.padding(4.dp)) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "navigate forward"
                        )
                    }
                }
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
@Composable
fun ItemDetailImage(image: String, modifier: Modifier) {
    Image(
        painter = rememberAsyncImagePainter(image),
        contentDescription = null,
        contentScale = ContentScale.Crop,// en/boy oranını koruyarak boyutu ayarlar
        modifier = modifier,
        alignment = Alignment.Center
    )
}