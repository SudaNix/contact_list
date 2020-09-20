package com.sudanix.contactlist.data.contact.dto

import com.sudanix.contactlist.domain.contact.Contact
import com.sudanix.contactlist.domain.contact.Extra
import com.sudanix.contactlist.domain.contact.Person

fun ContactDto.toContact() = Contact(
    caucus = caucus,
    congressNumbers = congressNumbers,
    current = current,
    description = description,
    district = district,
    enddate = enddate,
    extra = extra?.toExtra(),
    leadershipTitle = leadershipTitle,
    party = party,
    person = person?.toPerson(),
    phone = phone,
    roleType = roleType,
    roleTypeLabel = roleTypeLabel,
    senatorClass = senatorClass,
    senatorClassLabel = senatorClassLabel,
    senatorRank = senatorRank,
    senatorRankLabel = senatorRankLabel,
    startdate = startdate,
    state = state,
    title = title,
    titleLong = titleLong,
    website = website
)

fun PersonDto.toPerson() = Person(
    bioguideid = bioguideid,
    birthday = birthday,
    cspanid = cspanid,
    firstname = firstname,
    gender = gender,
    genderLabel = genderLabel,
    lastname = lastname,
    link = link,
    middlename = middlename,
    name = name,
    namemod = namemod,
    nickname = nickname,
    osid = osid,
    pvsid = pvsid,
    sortname = sortname,
    twitterid = twitterid,
    youtubeid = youtubeid
)

fun ExtraDto.toExtra() = Extra(
    address = address,
    contactForm = contactForm,
    fax = fax,
    office = office,
    rssUrl = rssUrl
)