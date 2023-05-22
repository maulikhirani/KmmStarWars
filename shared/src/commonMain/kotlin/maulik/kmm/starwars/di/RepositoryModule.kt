package maulik.kmm.starwars.di

import maulik.composestarwars.repository.StarWarsCharactersRepository
import maulik.composestarwars.repository.StarWarsCharactersRepositoryImpl
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val repositoryModule = DI.Module("repositoryModule") {
    bindSingleton<StarWarsCharactersRepository> { StarWarsCharactersRepositoryImpl(instance()) }
}