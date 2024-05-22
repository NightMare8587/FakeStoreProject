package com.sonsumers.fakestoreproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sonsumers.fakestoreproject.data.StoreViewModel
import com.sonsumers.fakestoreproject.model.StoreModelsItem
import com.sonsumers.fakestoreproject.ui.screens.ProductsScreen
import com.sonsumers.fakestoreproject.ui.theme.FakeStoreProjectTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel: StoreViewModel by viewModels()
        setContent {
            FakeStoreProjectTheme {
                ProductsLayout(viewModel)
            }
        }
    }
}

@Composable
fun ProductsLayout(storeViewModel: StoreViewModel, modifier: Modifier = Modifier) {
    storeViewModel.fetchProducts()
    val scope = rememberCoroutineScope()
    var list by remember { mutableStateOf((emptyList<StoreModelsItem>())) }
    LaunchedEffect(scope) {
        storeViewModel.storeProducts.collectLatest {
            list = it
        }
    }

    Log.d("MainActivity", "ProductsLayout: $list")
    LazyColumn {
        itemsIndexed(list) { index, item ->
            ProductsScreen(item)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FakeStoreProjectTheme {
        Greeting("Android")
    }
}