package uk.fernando.spacex.repository


import uk.fernando.spacex.network.SpaceXApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class RocketRepository @Inject constructor() {

    @Inject
    lateinit var spaceXApi: SpaceXApi

    suspend fun getRockets() = withContext(Dispatchers.IO) {
        spaceXApi.getRockets()
    }

}