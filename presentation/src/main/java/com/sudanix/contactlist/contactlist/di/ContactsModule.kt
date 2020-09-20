package com.sudanix.contactlist.contactlist.di

import android.content.res.AssetManager
import com.sudanix.contactlist.data.contact.ContactDaoImpl
import com.sudanix.contactlist.domain.contact.ContactRepository
import com.sudanix.contactlist.domain.contact.GetContactsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
object ContactsModule {

    @Provides
    @FragmentScoped
    fun getContactsUseCase(repository: ContactRepository): GetContactsUseCase {
        return GetContactsUseCase(repository)
    }

    @Provides
    @FragmentScoped
    fun contactDaoImpl(assetManager: AssetManager): ContactRepository {
        return ContactDaoImpl(
            assetManager
        )
    }
}