package com.bigoloo.realme.domain.model

import kotlinx.serialization.*


@Serializable
data class Diary(
    @SerialName("mod") val mood: Int,
    @SerialName("createTimestamp") val createTimestamp: Long
)