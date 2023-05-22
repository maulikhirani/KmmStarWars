package maulik.kmm.starwars.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StarWarsApiResponse(
    @SerialName("count")
    val count: Int,
    @SerialName("results")
    val characters: List<StarWarsCharacter>
)

@Serializable
data class StarWarsCharacter(
    @SerialName("name")
    val name: String
)
