package com.example.tutorial_application.presentation.view.testpager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tutorial_application.presentation.view.testpager.screens.PageAge
import com.example.tutorial_application.presentation.view.testpager.screens.PageConfirm
import com.example.tutorial_application.presentation.view.testpager.screens.PageName
import com.example.tutorial_application.presentation.viewmodel.testpager.FormViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val pagerState = rememberPagerState(
        pageCount = { 3 }
    )
    val viewModel: FormViewModel = viewModel()
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("swipe画面") })
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (pagerState.currentPage > 0) {
                    Button(onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    }) {
                        Text("<")
                    }
                }
                if (pagerState.currentPage < 2) {
                    Button(onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }) { Text(">") }
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .weight(1f)//残りのスペース全部埋めるイメージ
            ) {
                when (it) {
                    0 -> PageName(viewModel)
                    1 -> PageAge(viewModel)
                    2 -> PageConfirm(viewModel)
                }
            }

        }
    }
}