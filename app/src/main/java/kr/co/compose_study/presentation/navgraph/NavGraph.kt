package kr.co.compose_study.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import kr.co.compose_study.presentation.bookmark.BookmarkScreen
import kr.co.compose_study.presentation.bookmark.BookmarkViewModel
import kr.co.compose_study.presentation.home.HomeScreen
import kr.co.compose_study.presentation.home.HomeViewModel
import kr.co.compose_study.presentation.onboarding.OnBoardingScreen
import kr.co.compose_study.presentation.onboarding.OnBoardingViewModel
import kr.co.compose_study.presentation.search.SearchScreen
import kr.co.compose_study.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(
                route = Route.OnBoardingScreen.route
            ) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(route = Route.NewsNavigatorScreen.route) {
//                val viewModel : HomeViewModel = hiltViewModel()
//                val articles = viewModel.news.collectAsLazyPagingItems()
//
//                HomeScreen(articles = articles, navigate = {})

//                val viewModel: SearchViewModel = hiltViewModel()
//                SearchScreen(
//                    state = viewModel.state.value,
//                    event = viewModel::onEvent,
//                    navigate = {}
//                )

                val viewModel: BookmarkViewModel = hiltViewModel()
                BookmarkScreen(
                    state = viewModel.state.value,
                    navigate = {}
                )
            }
        }
    }
}