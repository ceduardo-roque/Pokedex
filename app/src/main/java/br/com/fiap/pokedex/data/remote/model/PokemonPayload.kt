package br.com.fiap.pokedex.data.remote.model

import com.google.gson.annotations.SerializedName

data class PokemonPayload(
    @SerializedName("name")  val nome: String,
    val sprites: Sprites
)

data class Sprites(
    @SerializedName("front_default")val frontDefault: String,
    val other: SpritesOther
)
data class SpritesOther(
    @SerializedName("dream_world") val dreamWorld: SpritesOtherDreamWorld,
    @SerializedName("official-artwork") val officialArtwork: SpritesOfficialArtwork
)

data class SpritesOtherDreamWorld(
    @SerializedName("front_default") val frontDefault: String
)

data class SpritesOfficialArtwork(
    @SerializedName("front_default") val frontDefault: String
)