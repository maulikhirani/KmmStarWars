# KMM StarWars

KMM StarWars is a multiplatform version of [Compose StarWars][1] which demonstrates the aspects of [Kotlin Multiplatform Mobile]. The core business logic is written once, only the UI is built using native UI tools on both platforms. Android uses Jetpack Compose and iOS uses Swift UI for design.

## What does the app look like?

Well, the idea is fairly simple - we are using an open source API from https://swapi.dev/ to load the list of StarWars universe characters. We don't load all characters at once, so we use the concept of pagination to load more data when scrolled to bottom.

https://github.com/maulikhirani/KmmStarWars/assets/25861055/0be2fbe8-f63c-4c46-82cd-83a7d43fe034

## How the app is built?

There are different layers of a KMM project: **Native** and **Shared**. Shared layer is built with the help of popular tools/SDKs with the support of KMM.

### Shared Layer
|Tool/SDK|Usage|
|---|---|
|[Ktor Client][3]|Networking (calling the API)|
|[Kodein][4]|Dependency injection|
|[Multiplatform Paging][5]|Loading the list with pagination|

Ktor Client on Shared layer internally delegates to native specific networking mechanisms. In our case, OkHttp for Android and Darwin for iOS.
Multiplatform Paging acts as a shared pagination logic, it delegates to [AndroidX Paging][6] on Android.

### Android
|Tool/SDK|Usage|
|---|---|
|[Jetpack Compose][7] with [Material 3][8]|UI design|
|[Coil][9]|Loading network images|
|[Lottie][10]|Animated loading indicator|
|[Paging Runtime Compose][11]|Loading the list with pagination|

### iOS
|Tool/SDK|Usage|
|---|---|
|[SwiftUI][12]|UI design|
|[AsyncImage for SwiftUI][13]|Loading network images|
|[Lottie with SwiftUI][14]|Animated loading indicator|
|[Multiplatform Paging with SwiftUI][15]|Loading the list with pagination|

[1]: https://github.com/maulikhirani/ComposeStarWars
[2]: https://kotlinlang.org/docs/multiplatform-mobile-getting-started.html
[3]: https://ktor.io/docs/getting-started-ktor-client-multiplatform-mobile.html#coroutines
[4]: https://github.com/kosi-libs/Kodein
[5]: https://github.com/kuuuurt/multiplatform-paging
[6]: https://developer.android.com/jetpack/androidx/releases/paging
[7]: https://developer.android.com/jetpack/compose
[8]: https://m3.material.io/develop/android/jetpack-compose
[9]: https://coil-kt.github.io/coil/compose/
[10]: https://github.com/airbnb/lottie/blob/master/android-compose.md
[11]: https://developer.android.com/reference/kotlin/androidx/paging/compose/package-summary#collectaslazypagingitems
[12]: https://developer.apple.com/xcode/swiftui/
[13]: https://developer.apple.com/documentation/swiftui/asyncimage
[14]: https://www.appcoda.com/swiftui-lottie/
[15]: https://github.com/kuuuurt/multiplatform-paging#jetpack-compose-and-swiftui

