package com.sudanix.contactlist.domain.contact

import io.reactivex.rxjava3.core.Single

interface ContactRepository {
    fun getContacts(request: GetContactsUseCase.Request): Single<List<Contact>>
}