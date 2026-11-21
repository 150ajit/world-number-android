package com.example.worldpopulation.presentation.stories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldpopulation.data.local.entity.DataStoryEntity
import com.example.worldpopulation.domain.repository.PopulationRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class StorySlide(
    val slideIndex: Int,
    val title: String,
    val stat: String,
    val text: String
)

data class StoryWithSlides(
    val entity: DataStoryEntity,
    val slides: List<StorySlide>
)

data class DataStoriesUiState(
    val stories: List<StoryWithSlides> = emptyList(),
    val selectedStory: StoryWithSlides? = null,
    val currentSlideIndex: Int = 0,
    val isLoading: Boolean = false
)

@HiltViewModel
class DataStoriesViewModel @Inject constructor(
    private val repository: PopulationRepository,
    private val gson: Gson
) : ViewModel() {

    private val _uiState = MutableStateFlow(DataStoriesUiState(isLoading = true))
    val uiState: StateFlow<DataStoriesUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getDataStories().collect { entities ->
                val parsed = entities.map { entity ->
                    val type = object : TypeToken<List<StorySlide>>() {}.type
                    val slides: List<StorySlide> = try {
                        gson.fromJson(entity.slidesJson, type)
                    } catch (e: Exception) {
                        emptyList()
                    }
                    StoryWithSlides(entity, slides)
                }
                _uiState.value = _uiState.value.copy(
                    stories = parsed,
                    selectedStory = parsed.firstOrNull(),
                    currentSlideIndex = 0,
                    isLoading = false
                )
            }
        }
    }

    fun selectStory(story: StoryWithSlides) {
        _uiState.value = _uiState.value.copy(
            selectedStory = story,
            currentSlideIndex = 0
        )
    }

    fun nextSlide() {
        val story = _uiState.value.selectedStory ?: return
        val current = _uiState.value.currentSlideIndex
        if (current < story.slides.size - 1) {
            _uiState.value = _uiState.value.copy(currentSlideIndex = current + 1)
        }
    }

    fun prevSlide() {
        val current = _uiState.value.currentSlideIndex
        if (current > 0) {
            _uiState.value = _uiState.value.copy(currentSlideIndex = current - 1)
        }
    }
}
