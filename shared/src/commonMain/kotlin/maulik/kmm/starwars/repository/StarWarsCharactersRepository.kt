package maulik.composestarwars.repository

import com.kuuurt.paging.multiplatform.Pager
import maulik.kmm.starwars.network.model.StarWarsCharacter

interface StarWarsCharactersRepository {
    fun getCharacters(): Pager<Int, StarWarsCharacter>
}