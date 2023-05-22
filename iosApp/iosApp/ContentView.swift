import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: StarWarsVM
    
    
    var body: some View {
        VStack {
            Text("KMM StarWars").font(.title)
            if(viewModel.charactersList.isEmpty) {
                LottieView(lottieFile: "loader")
                    .frame(width: 300, height: 300)
            }
            List {
                ForEach(viewModel.charactersList, id: \.name) { character in
                    CharactersListRowView(character: character)
                }
                if viewModel.shouldDisplayNextPage {
                    nextPageView
                }
            }
            .navigationTitle("KMM StarWars")
            .onAppear {
                viewModel.fetchCharacters()
            }
        }
    }
    
    private var nextPageView: some View {
        HStack {
            Spacer()
            VStack {
                LottieView(lottieFile: "loader")
                    .frame(width: 150, height: 150)
            }
            Spacer()
        }
        .onAppear(perform: {
            viewModel.fetchNextData()
        })
    }
}
