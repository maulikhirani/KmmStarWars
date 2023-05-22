//
//  StarWarsVM.swift
//  iosApp
//
//  Created by Maulik P Hirani on 5/17/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

@MainActor
class StarWarsVM: ObservableObject {
    let commonViewModel = StarWarsViewModel()
    var hasNextPage: Bool = false
    @Published public var charactersList: [StarWarsCharacter] = []
    
    func fetchCharacters() {
        commonViewModel.characters.watch { nullablePagingData in
            guard let list = nullablePagingData?.compactMap({ $0 as? StarWarsCharacter }) else {
                return
            }
            
            self.charactersList = list
            self.hasNextPage = self.commonViewModel.charactersPager.hasNextPage
        }
    }
    
    func fetchNextData() {
        commonViewModel.charactersPager.loadNext()
    }
    
    public var shouldDisplayNextPage: Bool {
        return hasNextPage
    }
    
}
