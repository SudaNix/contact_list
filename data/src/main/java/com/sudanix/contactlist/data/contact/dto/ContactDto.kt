package com.sudanix.contactlist.data.contact.dto

import com.google.gson.annotations.SerializedName

data class ContactResDto(@SerializedName("objects") val contacts: List<ContactDto>)

data class ContactDto(
    @SerializedName("caucus") val caucus: String?,
    @SerializedName("congress_numbers") val congressNumbers: List<Int>,
    @SerializedName("current") val current: Boolean?,
    @SerializedName("description") val description: String?,
    @SerializedName("district") val district: String?,
    @SerializedName("enddate") val enddate: String?,
    @SerializedName("extra") val extra: ExtraDto?,
    @SerializedName("leadership_title") val leadershipTitle: String?,
    @SerializedName("party") val party: String?,
    @SerializedName("person") val person: PersonDto?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("role_type") val roleType: String?,
    @SerializedName("role_type_label") val roleTypeLabel: String?,
    @SerializedName("senator_class") val senatorClass: String?,
    @SerializedName("senator_class_label") val senatorClassLabel: String?,
    @SerializedName("senator_rank") val senatorRank: String?,
    @SerializedName("senator_rank_label") val senatorRankLabel: String?,
    @SerializedName("startdate") val startdate: String?,
    @SerializedName("state") val state: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("title_long") val titleLong: String?,
    @SerializedName("website") val website: String?
)

data class PersonDto(
    @SerializedName("bioguideid") val bioguideid: String?,
    @SerializedName("birthday") val birthday: String?,
    @SerializedName("cspanid") val cspanid: String?,
    @SerializedName("firstname") val firstname: String?,
    @SerializedName("gender") val gender: String?,
    @SerializedName("gender_label") val genderLabel: String?,
    @SerializedName("lastname") val lastname: String?,
    @SerializedName("link") val link: String?,
    @SerializedName("middlename") val middlename: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("namemod") val namemod: String?,
    @SerializedName("nickname") val nickname: String?,
    @SerializedName("osid") val osid: String?,
    @SerializedName("pvsid") val pvsid: Int?,
    @SerializedName("sortname") val sortname: String?,
    @SerializedName("twitterid") val twitterid: String?,
    @SerializedName("youtubeid") val youtubeid: String?
)

data class ExtraDto(
    @SerializedName("address") val address: String?,
    @SerializedName("contact_form") val contactForm: String?,
    @SerializedName("fax") val fax: String?,
    @SerializedName("office") val office: String?,
    @SerializedName("rss_url") val rssUrl: String?
)