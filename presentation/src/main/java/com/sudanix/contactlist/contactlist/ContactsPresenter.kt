package com.sudanix.contactlist.contactlist

import com.sudanix.contactlist.app.di.IoThreadScheduler
import com.sudanix.contactlist.app.di.UiThreadScheduler
import com.sudanix.contactlist.domain.contact.GetContactsUseCase
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class ContactsFragmentPresenter @Inject constructor(
    private val getContactsUseCase: GetContactsUseCase,
    @UiThreadScheduler private val uiThread: Scheduler,
    @IoThreadScheduler private val ioThread: Scheduler
) {

    private var view: ContactsView? = null
    private val compositeDisposable = CompositeDisposable()

    fun onAttachView(view: ContactsView) {
        this.view = view
    }

    fun onDetachView() {
        compositeDisposable.clear()
        this.view = null
    }

    fun loadContacts() {
        compositeDisposable.clear()

        val request = GetContactsUseCase.Request()
        val subscription = getContactsUseCase.execute(request)
            .subscribeOn(ioThread)
            .map {
                it
                    .sortedByDescending { s -> s.person?.lastname }
                    .map { s -> s.toContactVM() }
            }
            .observeOn(uiThread)
            .subscribe({
                view?.displayContacts(it)
            }, {
                view?.showErrorMessage(it.message ?: "unexpected error")
            })

        compositeDisposable.add(subscription)
    }

    fun onContactClicked(contact: ContactViewEntity) {
        view?.onContactClicked(contact)
    }
}