package maulik.composestarwars.repository

import com.kuuurt.paging.multiplatform.Pager
import com.kuuurt.paging.multiplatform.PagingConfig
import com.kuuurt.paging.multiplatform.PagingResult
import kotlinx.coroutines.MainScope
import maulik.kmm.starwars.network.StarWarsApiService

class StarWarsCharactersRepositoryImpl constructor(
    private val starWarsApiService: StarWarsApiService
) : StarWarsCharactersRepository {

    private val scope = MainScope()

    override fun getCharacters() = Pager(
        initialKey = 1,
        clientScope = scope,
        config = PagingConfig(10),
        getItems = { currentKey, size ->
            val response = starWarsApiService.getStarWarsCharacter(currentKey)
            PagingResult(
                items = response.characters,
                currentKey = currentKey,
                prevKey = { null }, // Key for previous page, null means don't load previous pages
                nextKey = {
                    println("Current key is $currentKey")
                    currentKey + 1
                } // Key for next page. Use `items` or `currentKey` to get it depending on the pagination strategy
            )
        }
    )

}