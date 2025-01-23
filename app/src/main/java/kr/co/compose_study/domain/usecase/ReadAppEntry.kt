package kr.co.compose_study.domain.usecase

import kotlinx.coroutines.flow.Flow
import kr.co.compose_study.domain.manager.LocalUserManager

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}