package com.sudanix.contactlist.contactlist

import android.app.ActivityOptions
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sudanix.contactlist.R
import com.sudanix.contactlist.contactdetails.ContactDetailsActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_contact_list.*

@AndroidEntryPoint
class ContactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)
        initToolbar()

        val fragment = ContactsFragment.getInstance()

        fragment.setContactClickedListener { contact, profileImageView ->
            startContactDetailsPage(contact, profileImageView)
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.contentView, fragment)
            .commit()
    }

    private fun startContactDetailsPage(
        contact: ContactViewEntity,
        profileImageView: View
    ) {
        val intent = ContactDetailsActivity.getIntent(contact, this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val transitionActivityOptions: ActivityOptions =
                ActivityOptions.makeSceneTransitionAnimation(
                    this,
                    profileImageView,
                    profileImageView.transitionName
                )
            startActivity(intent, transitionActivityOptions.toBundle())
        } else {
            startActivity(intent)
        }
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.contact_list)
    }
}