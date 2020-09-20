package com.sudanix.contactlist.domain.contact

data class Contact (
    val caucus : String?,
    val congressNumbers : List<Int>,
    val current : Boolean?,
    val description : String?,
    val district : String?,
    val enddate : String?,
    val extra : Extra?,
    val leadershipTitle : String?,
    val party : String?,
    val person : Person?,
    val phone : String?,
    val roleType : String?,
    val roleTypeLabel : String?,
    val senatorClass : String?,
    val senatorClassLabel : String?,
    val senatorRank : String?,
    val senatorRankLabel : String?,
    val startdate : String?,
    val state : String?,
    val title : String?,
    val titleLong : String?,
    val website : String?
)

data class Person (
    val bioguideid : String?,
    val birthday : String?,
    val cspanid : String?,
    val firstname : String?,
    val gender : String?,
    val genderLabel : String?,
    val lastname : String?,
    val link : String?,
    val middlename : String?,
    val name : String?,
    val namemod : String?,
    val nickname : String?,
    val osid : String?,
    val pvsid : Int?,
    val sortname : String?,
    val twitterid : String?,
    val youtubeid : String?
)

data class Extra (
    val address : String?,
    val contactForm : String?,
    val fax : String?,
    val office : String?,
    val rssUrl : String?
)