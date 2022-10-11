package com.tkpd.devcamp2022.day3.room_datastore.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tkpd.devcamp2022.day3.room_datastore.repository.state.UserListState
import com.tkpd.devcamp2022.day3.room_datastore.repository.UserListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserListViewModel(
    private val userListRepository: UserListRepository
): ViewModel() {

    private val _stateUserList = MutableLiveData<UserListState>()
    val stateUserList: LiveData<UserListState>
        get() = _stateUserList

    //TODO(1,13) Add param isFromCached
    fun getUserList(isFromCached: Boolean) {
        viewModelScope.launch {
            //val state = userListRepository.getUserList(isFromCached)
            val state = userListRepository.getUserList()
            _stateUserList.value = state
        }
    }
}