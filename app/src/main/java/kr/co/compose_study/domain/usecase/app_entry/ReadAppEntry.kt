package kr.co.compose_study.domain.usecase.app_entry

import kotlinx.coroutines.flow.Flow
import kr.co.compose_study.domain.manager.LocalUserManager

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}