package br.com.fiap.pokedex.ui.lista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.pokedex.R
import br.com.fiap.pokedex.domain.entity.Pokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon_item.view.*

class ListaAdapter(
    val pokemons: List<Pokemon>,
    val clickListener: (Pokemon) -> Unit
) : RecyclerView.Adapter<ListaAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return PokemonViewHolder(view)
    }
    override fun getItemCount(): Int {
        return pokemons.size
    }
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.bindView(pokemon, clickListener)
    }

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(pokemon: Pokemon,
                     clickListener: (Pokemon) -> Unit) = with(itemView) {
            tvNomePokemonLista.text = pokemon.nome

            Picasso.get().load(pokemon.urlImagem).into(ivPokemon)

            setOnClickListener { clickListener(pokemon) }
        }
    }
}