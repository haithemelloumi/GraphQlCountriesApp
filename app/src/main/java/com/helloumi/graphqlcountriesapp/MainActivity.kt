package com.helloumi.graphqlcountriesapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.helloumi.graphqlcountriesapp.ui.CountriesScreen
import com.helloumi.graphqlcountriesapp.ui.CountriesViewModel
import com.helloumi.graphqlcountriesapp.ui.theme.GraphQlCountriesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphQlCountriesAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val viewModel = hiltViewModel<CountriesViewModel>()
                    val state by viewModel.state.collectAsState()
                    CountriesScreen(
                        state = state,
                        onSelectCountry = viewModel::selectCountry,
                        onDismissCountryDialog = viewModel::dismissCountryDialog
                    )

                }
            }
        }
    }
}
