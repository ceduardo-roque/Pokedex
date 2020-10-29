package br.com.fiap.pokedex.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIService {

    private  var INSTANCE : PokemonService? = null

    val instance: PokemonService?

    get() {
        if (INSTANCE == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            INSTANCE = retrofit.create(
                PokemonService::class.java)
        }
        return INSTANCE
    }

}