package com.newapp.sqldelightcrudapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.newapp.sqldelightcrudapp.ui.PersonListScreen
import com.newapp.sqldelightcrudapp.ui.theme.SQLDelightCRUDAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SQLDelightCRUDAppTheme {
              PersonListScreen()
            }
        }
    }
}