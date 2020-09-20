package com.sudanix.contactlist.contactdetails

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.sudanix.contactlist.R
import com.sudanix.contactlist.contactlist.ContactViewEntity
import kotlinx.android.synthetic.main.activity_contact_details.*

class ContactDetailsActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "ContactDetailsActivity"
        private const val EXTRA_CONTACT = "EXTRA_CONTACT"

        fun getIntent(contactVM: ContactViewEntity, context: Context): Intent {
            val intent = Intent(context, ContactDetailsActivity::class.java)
            intent.putExtra(EXTRA_CONTACT, contactVM)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)
        initToolbar()

        val contactEntity = intent.getParcelableExtra<ContactViewEntity>(EXTRA_CONTACT)

        // TODO: if time is available, will replace manual with data binding

        fullNameTextView.text = contactEntity?.fullName
        emailTextView.text = contactEntity?.link
        roleTextView.text = contactEntity?.role
        productTextView.text = contactEntity?.product

        addressTextView.text = contactEntity?.address
        officeTextView.text = contactEntity?.office
        nameTextView.text = contactEntity?.name
        birthdayTextView.text = contactEntity?.birthday
        endDateTextView.text = contactEntity?.endDate
        genderTextView.text = contactEntity?.gender
        sortNameTextView.text = contactEntity?.sortName
        websiteTextView.text = contactEntity?.website

        initTransitionProfileImage(contactEntity)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initTransitionProfileImage(contactViewEntity: ContactViewEntity?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            profileImageView.transitionName = contactViewEntity?.congressNumber.toString()
        }

        when (contactViewEntity?.party) {
            "Republican" -> profileImageView.setImageResource(R.drawable.republican_logo)
            "Democrat" -> profileImageView.setImageResource(R.drawable.democrat_logo)
            else -> profileImageView.setImageResource(R.mipmap.ic_launcher)
        }
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.contact_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}