package kr.co.compose_study

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kr.co.compose_study.domain.usecase.AppEntryUseCases
import kr.co.compose_study.presentation.onboarding.OnBoardingScreen
import kr.co.compose_study.presentation.onboarding.OnBoardingViewModel
import kr.co.compose_study.ui.theme.Compose_StudyTheme
import javax.inject.Inject
import androidx.hilt.navigation.compose.hiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var appEntryUseCases: AppEntryUseCases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()
        lifecycleScope.launch {
            appEntryUseCases.readAppEntry().collect{
                Log.d("Test", it.toString())
            }
        }
        setContent {
            Compose_StudyTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    val viewModel : OnBoardingViewModel = hiltViewModel()
                    OnBoardingScreen(
                        event = viewModel::onEvent
                    )
                }
            }
        }
    }
}