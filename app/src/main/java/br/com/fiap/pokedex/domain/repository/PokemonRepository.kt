package br.com.fiap.pokedex.domain.repository

import br.com.fiap.pokedex.domain.entity.Pokemon

interface PokemonRepository {

    fun pesquisar(id: String,
        onComplete: (Pokemon?) -> Unit,
        onError: (Throwable) -> Unit
    )

}