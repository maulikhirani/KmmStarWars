package maulik.kmm.starwars.repository

import maulik.kmm.starwars.network.StarWarsApiService


@Suppress("CAST_NEVER_SUCCEEDS")
class StarWarsCharactersPagingSource constructor(
    private val starWarsApiService: StarWarsApiService
) /*: PagingSource<Int, StarWarsCharacter>() {

    override suspend fun load(params: PagingSourceLoadParams<Int>): PagingSourceLoadResult<Int, StarWarsCharacter> {
        val pageNo = params.key ?: 1
        try {
            val response = starWarsApiService.getStarWarsCharacter(pageNo)
            return PagingSourceLoadResultPage(
                response.characters,
                prevKey = if (pageNo == 1) null else pageNo.minus(1),
                nextKey = if (response.characters.isEmpty()) null else pageNo.plus(1)
            ) as PagingSourceLoadResult<Int, StarWarsCharacter>
        } catch (e: Exception) {
            return PagingSourceLoadResultError<Int, StarWarsCharacter>(e) as PagingSourceLoadResult<Int, StarWarsCharacter>
        }
    }

    override fun getRefreshKey(state: PagingState<Int, StarWarsCharacter>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}*/