package kr.co.compose_study.presentation.onboarding

sealed class OnBoardingEvent {
    data object SaveAppEntry : OnBoardingEvent()
}