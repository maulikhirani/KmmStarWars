package maulik.kmm.starwars.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import maulik.kmm.starwars.network.model.StarWarsApiResponse

class StarWarsApiServiceImpl(
    private val httpClient: HttpClient
) : StarWarsApiService {
    override suspend fun getStarWarsCharacter(pageNo: Int): StarWarsApiResponse {
        return httpClient
            .get("https://swapi.dev/api/people?page=$pageNo")
            .body()
    }
}