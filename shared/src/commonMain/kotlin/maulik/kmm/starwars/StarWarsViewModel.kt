package maulik.kmm.starwars

import com.kuuurt.paging.multiplatform.Pager
import com.kuuurt.paging.multiplatform.PagingData
import com.kuuurt.paging.multiplatform.helpers.cachedIn
import kotlinx.coroutines.MainScope
import maulik.composestarwars.repository.StarWarsCharactersRepository
import maulik.kmm.starwars.di.di
import maulik.kmm.starwars.network.model.StarWarsCharacter
import maulik.kmm.starwars.util.CommonFlow
import maulik.kmm.starwars.util.asCommonFlow
import org.kodein.di.instance

class StarWarsViewModel {
    private val repository: StarWarsCharactersRepository by di.instance()
    private val scope = MainScope()

    val pager = repository.getCharacters()

    val characters: CommonFlow<PagingData<StarWarsCharacter>>
        get() = pager.pagingData
            .cachedIn(scope)
            .asCommonFlow()

    val charactersPager: Pager<Int, StarWarsCharacter>
        get() = pager

}