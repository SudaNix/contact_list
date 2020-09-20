package com.sudanix.contactlist.contactlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sudanix.contactlist.R
import com.sudanix.contactlist.commons.snack
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_contact_list.*
import javax.inject.Inject

@AndroidEntryPoint
class ContactsFragment : Fragment(), ContactsView {

    companion object {
        private const val TAG = "ContactsFragment"
        fun getInstance(): ContactsFragment {
            return ContactsFragment()
        }
    }

    @Inject
    lateinit var presenter: ContactsFragmentPresenter

    private lateinit var contactsAdapter: ContactsAdapter
    private var contactClickedListener: (ContactViewEntity, View) -> (Unit) = { _, _ -> }

    // hold clicked contact image for transition effect
    private lateinit var profileImageView: View

    fun setContactClickedListener(lambda: (ContactViewEntity, View) -> (Unit)) {
        this.contactClickedListener = lambda
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        inflater.inflate(R.layout.fragment_contact_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttachView(this)
        initRecyclerView()
        presenter.loadContacts()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetachView()
    }

    private fun initRecyclerView() {
        contactsAdapter = ContactsAdapter(
            requireActivity(),
            mutableListOf(),
            object : ContactsAdapter.ContactClickListener {
                override fun onContactClicked(view: View, contact: ContactViewEntity) {
                    profileImageView = view
                    presenter.onContactClicked(contact)
                }
            })

        contactRecyclerView.layoutManager = LinearLayoutManager(context)
        contactRecyclerView.adapter = contactsAdapter
    }

    override fun showErrorMessage(message: String) {
        this.snack(message)
    }

    override fun displayContacts(contacts: List<ContactViewEntity>) {
        Log.v(TAG, "Found ${contacts.size} contacts")
        contactsAdapter.update(contacts)
    }

    override fun onContactClicked(contact: ContactViewEntity) {
        this.contactClickedListener(contact, profileImageView)
    }
}