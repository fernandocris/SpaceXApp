package uk.fernando.spacex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import uk.fernando.spacex.R
import uk.fernando.spacex.helpers.ResultResource
import uk.fernando.spacex.model.RocketModel
import uk.fernando.spacex.repository.RocketRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class RocketListViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var rocketRepository: RocketRepository

    private val rocketResult = MutableLiveData<ResultResource<List<RocketModel>>>()

    fun rocketResultObserver(): LiveData<ResultResource<List<RocketModel>>> = rocketResult

    fun getRockets() {
        viewModelScope.launch {
            rocketResult.postValue(ResultResource.Loading)

            try {

                val response = rocketRepository.getRockets()

                if (response.isSuccessful)
                    rocketResult.postValue(ResultResource.Success(response.body()))
                else if (response.code() == 404)
                    rocketResult.postValue(ResultResource.NotFound)
                else
                    rocketResult.postValue(ResultResource.Error(R.string.fetch_error))

            } catch (exception: Exception) {
                rocketResult.postValue(ResultResource.Error(R.string.fetch_error))
            }
        }
    }

}


