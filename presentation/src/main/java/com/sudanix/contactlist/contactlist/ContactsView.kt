package com.sudanix.contactlist.contactlist

interface ContactsView {
    fun showErrorMessage(message: String)
    fun displayContacts(contacts: List<ContactViewEntity>)
    fun onContactClicked(contact: ContactViewEntity)
}