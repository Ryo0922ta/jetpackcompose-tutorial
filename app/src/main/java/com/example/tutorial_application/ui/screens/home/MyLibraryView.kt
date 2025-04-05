package com.example.tutorial_application.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// メニューのデータクラス
data class BottomNavItem(
    val title: String,
    val icon: ImageVector? = null
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyLibraryView(
    modifier: Modifier = Modifier
) {
    // 現在選択されているナビゲーションアイテムのインデックスを管理
    var selectedItem by remember { mutableStateOf(2) }

    // ナビゲーションアイテムのリスト
    val items = listOf(
        BottomNavItem("投稿", Icons.Filled.Create),
        BottomNavItem("検索", Icons.Filled.Search),
        BottomNavItem("ライブラリ"),
        BottomNavItem("マイページ", Icons.Filled.AccountCircle)
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "My ライブラリ",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold
                    )
                },
                actions = {
                    IconButton(onClick = { /* TODO: 新しいアイテム追加処理 */ }) {
                        Icon(Icons.Filled.Add, contentDescription = "追加")
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(
                items = items,
                selectedItem = selectedItem,
                onItemSelected = { index -> selectedItem = index }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp)
        ) {
            // ライブラリカードのサンプル
            LibraryCard(title = "旅行本")
            LibraryCard(title = "料理本")
            LibraryCard(title = "歴史本")
        }
    }
}

@Composable
fun BottomNavigationBar(
    selectedItem: Int,
    onItemSelected: (Int) -> Unit,
    items: List<BottomNavItem> // BottomNavItemのリスト
) {
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    // アイコンがある場合に表示、無い場合にはデフォルトアイコンを表示する
                    Icon(
                        item.icon ?: Icons.Filled.Create, // アイコンがない場合にデフォルトのフォルダーアイコン
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = selectedItem == index, // 現在選択されているアイテムを判定
                onClick = { onItemSelected(index) } // アイテムが選択されたときの処理
            )
        }
    }
}

@Composable
fun LibraryCard(title: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = title, style = MaterialTheme.typography.bodyLarge)
            IconButton(onClick = { /* TODO: メニューアクション */ }) {
                Icon(Icons.Filled.MoreVert, contentDescription = "メニュー")
            }
        }
    }
}

@Preview
@Composable
fun PreviewMyLibraryView() {
    MyLibraryView()
}


