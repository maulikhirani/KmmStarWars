package maulik.kmm.starwars.di

import maulik.kmm.starwars.network.StarWarsApiService
import maulik.kmm.starwars.network.StarWarsApiServiceImpl
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val apiServiceModule = DI.Module("apiServiceModule") {
    bindSingleton<StarWarsApiService> { StarWarsApiServiceImpl(instance()) }
}