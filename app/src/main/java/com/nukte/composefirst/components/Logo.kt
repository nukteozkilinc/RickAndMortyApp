package com.nukte.composefirst.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nukte.composefirst.R

@Composable
fun Logo(
    modifier :Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            modifier= Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            painter = painterResource(
                id = R.drawable.logo),
            contentDescription = "logo")
    }
}