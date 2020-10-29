package br.com.fiap.pokedex.data.repository

import br.com.fiap.pokedex.data.remote.api.APIService
import br.com.fiap.pokedex.data.remote.api.PokemonService
import br.com.fiap.pokedex.data.remote.mapper.PokemonPayloadMapper
import br.com.fiap.pokedex.data.remote.model.PokemonPayload
import br.com.fiap.pokedex.domain.entity.Pokemon
import br.com.fiap.pokedex.domain.repository.PokemonRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepositoryImpl(val pokemonService: PokemonService?) : PokemonRepository {


    override fun pesquisar(id: String,
                           onComplete: (Pokemon?) -> Unit,
                           onError: (Throwable) -> Unit) {
        pokemonService
            ?.pesquisar(id)
            ?.enqueue(object: Callback<PokemonPayload>{

                override fun onFailure(call: Call<PokemonPayload>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<PokemonPayload>, response: Response<PokemonPayload>) {
                    if(response.isSuccessful) {
                        val pokemonPayload = response.body()
                        if(pokemonPayload == null) {
                            onError(Throwable("Pokemon Não Encontrado!"))
                        } else {
                            onComplete(PokemonPayloadMapper.map(pokemonPayload))
                        }

                    } else {
                        onError(Throwable("Pokemon Não Encontrado!"))
                    }
                }

            })

    }

}