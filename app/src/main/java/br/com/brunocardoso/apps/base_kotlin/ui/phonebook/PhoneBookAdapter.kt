package br.com.brunocardoso.apps.base_kotlin.ui.phonebook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.brunocardoso.apps.base_kotlin.R
import br.com.brunocardoso.apps.base_kotlin.shared.model.Contact
import br.com.brunocardoso.apps.base_kotlin.ui.phonebook.PhoneBookAdapter.PhoneBookViewHolder

/**
 * @author Bruno Cardoso on 24/07/2019.
 */
class PhoneBookAdapter(
    private var list: List<Contact>
) : Adapter<PhoneBookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneBookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return PhoneBookViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PhoneBookViewHolder, position: Int) {
        val contact = list.get(position)
        holder.bind(contact)
    }

    fun setList(list: List<Contact>) {
        this.list = list
        notifyDataSetChanged()
    }

    class PhoneBookViewHolder(itemView: View) : ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.contact_item_name)
        private val tvPhone: TextView = itemView.findViewById(R.id.contact_item_phone)

        fun bind(contact: Contact) {
            tvName.text = contact.name
            tvPhone.text = contact.phone
        }
    }
}