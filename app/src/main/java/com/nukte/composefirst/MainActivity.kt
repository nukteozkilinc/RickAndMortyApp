package com.nukte.composefirst

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.nukte.composefirst.presentation.HomeScreen
import com.nukte.composefirst.ui.theme.RickAndMorty
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMorty {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background){
                    HomeScreen()
                }
            }
        }
    }
}

