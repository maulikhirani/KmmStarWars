//
//  CharacterListRowView.swift
//  iosApp
//
//  Created by Maulik P Hirani on 5/19/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CharactersListRowView: View {
    let character: StarWarsCharacter
    
    var body: some View {
        HStack {
            if let image = "https://ui-avatars.com/api/?name=\(character.name)&background=random&size=100&rounded=true".replacingOccurrences(of: " ", with: "+"),
               let url = URL(string: image) {
                AsyncImage(url: url) { image in
                    image.resizable()
                } placeholder: {
                    ProgressView()
                }
                .frame(width: 50, height: 50)
                .clipShape(RoundedRectangle(cornerRadius: 25))
            } else {
                RoundedRectangle(cornerRadius: 25)
                    .frame(width: 50, height: 50)
                    .foregroundColor(.gray)
            }
            VStack(alignment: .leading) {
                Text(character.name )
                    .font(.title3)
                    .foregroundColor(.accentColor)
//                Text("\(character.name)")
//                    .font(.footnote)
//                    .foregroundColor(.gray)
            }
        }
    }
}
