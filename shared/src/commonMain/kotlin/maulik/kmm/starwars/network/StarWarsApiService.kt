package maulik.kmm.starwars.network

import maulik.kmm.starwars.network.model.StarWarsApiResponse

interface StarWarsApiService {
    suspend fun getStarWarsCharacter(pageNo: Int): StarWarsApiResponse
}