package com.dilip.reminderapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dilip.reminderapp.domian.model.Reminder
import com.dilip.reminderapp.domian.use_cases.DeleteUseCase
import com.dilip.reminderapp.domian.use_cases.GelAllReminderUseCase
import com.dilip.reminderapp.domian.use_cases.InsertUseCase
import com.dilip.reminderapp.domian.use_cases.UpdateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val insertUseCase: InsertUseCase,
    private val deleteUseCase: DeleteUseCase,
    private val updateUseCase: UpdateUseCase,
    private val getAllReminderUseCase: GelAllReminderUseCase
) : ViewModel() {

    val uiState = getAllReminderUseCase.invoke().map { UiState(it) }
        .stateIn(viewModelScope, started = SharingStarted.Eagerly, UiState())

    fun insert(reminder: Reminder) = viewModelScope.launch {
        insertUseCase.invoke(reminder)
    }

    fun update(reminder: Reminder) = viewModelScope.launch {
        updateUseCase.invoke(reminder)
    }

    fun delete(reminder: Reminder) = viewModelScope.launch {
        deleteUseCase.invoke(reminder)
    }
}

data class UiState(
    val data: List<Reminder> = emptyList()
)
