package br.com.brunocardoso.apps.base_kotlin.ui.phonebook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.brunocardoso.apps.base_kotlin.R
import br.com.brunocardoso.apps.base_kotlin.shared.model.Phone
import br.com.brunocardoso.apps.base_kotlin.ui.phonebook.PhoneBookAdapter.PhoneBookViewHolder

/**
 * @author Bruno Cardoso on 24/07/2019.
 */
class PhoneBookAdapter(
    private var list: List<Phone>
) : Adapter<PhoneBookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneBookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recyclerview_item, parent
            , false
        )
        return PhoneBookViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PhoneBookViewHolder, position: Int) {
        val phone = list.get(position)
        holder.bind(phone)
    }

    fun setList(list: List<Phone>) {
        this.list = list
        notifyDataSetChanged()
    }

    class PhoneBookViewHolder(itemView: View) : ViewHolder(itemView) {
        private val tvWord: TextView = itemView.findViewById<TextView>(R.id.textView)

        fun bind(phone: Phone) {
            tvWord.text = phone.name
        }
    }
}