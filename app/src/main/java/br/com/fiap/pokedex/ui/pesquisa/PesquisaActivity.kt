    package br.com.fiap.pokedex.ui.pesquisa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.fiap.pokedex.R
import br.com.fiap.pokedex.data.remote.api.APIService
import br.com.fiap.pokedex.data.repository.PokemonRepositoryImpl
import br.com.fiap.pokedex.domain.repository.PokemonRepository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btPesquisar
import kotlinx.android.synthetic.main.activity_pesquisa.*

class PesquisaActivity : AppCompatActivity() {

    private lateinit var pokemonRepository: PokemonRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)

        pokemonRepository = PokemonRepositoryImpl(APIService.instance)

        btPesquisar.setOnClickListener {
            pokemonRepository.pesquisar(
                etPokemon.text.toString(),
                { pokemon ->
                    tvNomePokemon.text = pokemon?.nome
                    Picasso.get()
                        .load(pokemon?.urlImagem)
                        .into(ivPokemon)
                }, {
                    Toast.makeText(this@PesquisaActivity,"Pokémon não encontrado", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}