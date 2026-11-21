package com.example.worldpopulation.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.worldpopulation.data.local.preferences.UserPreferencesRepository
import com.example.worldpopulation.domain.repository.PopulationRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class PopulationSyncWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val repository: PopulationRepository,
    private val preferencesRepository: UserPreferencesRepository
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            val syncResult = repository.syncData()
            if (syncResult.isSuccess) {
                preferencesRepository.setLastSyncTimestamp(System.currentTimeMillis())
                Result.success()
            } else {
                // Return retry if network error, preserving local cache
                Result.retry()
            }
        } catch (e: Exception) {
            Result.retry()
        }
    }
}
