package com.sudanix.contactlist.data.contact

import android.content.res.AssetManager
import android.util.Log
import com.google.gson.Gson
import com.sudanix.contactlist.data.commons.getStringFromFile
import com.sudanix.contactlist.data.contact.dto.ContactResDto
import com.sudanix.contactlist.data.contact.dto.toContact
import com.sudanix.contactlist.domain.contact.Contact
import com.sudanix.contactlist.domain.contact.ContactRepository
import com.sudanix.contactlist.domain.contact.GetContactsUseCase
import io.reactivex.rxjava3.core.Single

class ContactDaoImpl(private val assetManager: AssetManager) : ContactRepository {

    override fun getContacts(request: GetContactsUseCase.Request): Single<List<Contact>> {
        return Single.create<List<Contact>> {
            try {

                // Read & parse json data
                val json =
                    getStringFromFile(
                        filePath = "us_senators.json",
                        assetManager = assetManager
                    )
                val contactResDto = Gson().fromJson(json, ContactResDto::class.java)

                // Map data dto to domain model
                val contacts = contactResDto.contacts.map { c -> c.toContact() }
                contacts.forEach { c -> Log.v("ContactDaoImpl", c.person.toString()) }

                it.onSuccess(contacts)
            } catch (e: Throwable) {
                e.printStackTrace()
                it.onError(e)
            }
        }
    }
}
