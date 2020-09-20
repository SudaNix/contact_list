package com.sudanix.contactlist.contactlist

import android.os.Parcelable
import com.sudanix.contactlist.domain.contact.Contact
import kotlinx.android.parcel.Parcelize

// This Model can have some hierarchy instead of flat
@Parcelize
data class ContactViewEntity(
    val name: String,
    val fullName: String,
    val party: String,
    val description: String,
    val link: String,
    val role: String,
    val admin: String,
    val product: String,
    val address: String,
    val office: String,
    val birthday: String,
    val endDate: String,
    val gender: String,
    val sortName: String,
    val website: String,
    val congressNumber: Int
) : Parcelable

fun Contact.toContactVM() = ContactViewEntity(
    name = person?.name ?: "-",
    fullName = "${person?.firstname} ${person?.lastname}",
    party = party ?: "-",
    description = description ?: "-",
    link = website ?: "-",
    role = "Bio Guide Id",
    admin = person?.bioguideid ?: "-",
    product = party ?: "-",
    address = extra?.address ?: "-",
    office = extra?.office ?: "-",
    birthday = person?.birthday ?: "-",
    endDate = enddate ?: "-",
    gender = person?.gender ?: "-",
    sortName = person?.sortname ?: "-",
    website = website ?: "-",
    congressNumber = congressNumbers.first()
)