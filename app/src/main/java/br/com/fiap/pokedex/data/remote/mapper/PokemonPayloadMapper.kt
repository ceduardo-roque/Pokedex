package br.com.fiap.pokedex.data.remote.mapper

import br.com.fiap.pokedex.data.remote.model.PokemonPayload
import br.com.fiap.pokedex.domain.entity.Pokemon

object PokemonPayloadMapper {

    fun map(pokemons: List<PokemonPayload>) = pokemons.map { map(it) }

    fun map(pokemon: PokemonPayload) = Pokemon(
        pokemon.nome,
        pokemon.sprites.other.officialArtwork.frontDefault
    )

}