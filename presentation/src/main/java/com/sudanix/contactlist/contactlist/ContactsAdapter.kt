package com.sudanix.contactlist.contactlist

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sudanix.contactlist.R

class ContactsAdapter(
    private val context: Context,
    private val contacts: MutableList<ContactViewEntity>,
    private val clickListener: ContactClickListener
) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    fun update(list: List<ContactViewEntity>) {
        contacts.clear()
        contacts.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val contact = contacts[position]
        viewHolder.bind(contact, clickListener)
        viewHolder.nameTextView.text = contact.name
        viewHolder.partyTextView.text = contact.party
        viewHolder.descTextView.text = contact.description

        when (contact.party) {
            "Republican" -> viewHolder.profileImageView.setImageResource(R.drawable.republican_logo)
            "Democrat" -> viewHolder.profileImageView.setImageResource(R.drawable.democrat_logo)
            else -> viewHolder.profileImageView.setImageResource(R.mipmap.ic_launcher)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            viewHolder.profileImageView.transitionName = contact.congressNumber.toString()
        }
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val parentView: View = view.rootView
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val partyTextView: TextView = view.findViewById(R.id.partyTextView)
        val descTextView: TextView = view.findViewById(R.id.descTextView)
        val profileImageView: ImageView = view.findViewById(R.id.profileImageView)

        fun bind(contact: ContactViewEntity, listener: ContactClickListener) {
            parentView.setOnClickListener { listener.onContactClicked(profileImageView, contact) }
        }
    }

    interface ContactClickListener {
        fun onContactClicked(view: View, contact: ContactViewEntity)
    }
}
