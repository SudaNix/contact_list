package com.sudanix.contactlist.domain.commons

import io.reactivex.rxjava3.core.Single

interface SingleUseCase<Q : SingleUseCase.RequestValues, T> {

    fun execute(request: Q): Single<T>

    interface RequestValues
}
