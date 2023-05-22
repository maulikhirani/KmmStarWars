package maulik.kmm.starwars.di

import org.kodein.di.DI

val di = DI {
    import(networkModule)
    import(apiServiceModule)
    import(repositoryModule)
}