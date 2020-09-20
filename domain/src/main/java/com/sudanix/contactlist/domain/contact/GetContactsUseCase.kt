package com.sudanix.contactlist.domain.contact

import com.sudanix.contactlist.domain.commons.SingleUseCase
import io.reactivex.rxjava3.core.Single

class GetContactsUseCase constructor(private val repository: ContactRepository) :
    SingleUseCase<GetContactsUseCase.Request, List<Contact>> {

    override fun execute(request: Request): Single<List<Contact>> {
        return repository.getContacts(request)
    }

    class Request : SingleUseCase.RequestValues
}

