package uk.fernando.spacex.network

import uk.fernando.spacex.model.RocketModel
import retrofit2.Response
import retrofit2.http.GET

interface SpaceXApi {

    @GET("rockets")
    suspend fun getRockets(): Response<List<RocketModel>>

}