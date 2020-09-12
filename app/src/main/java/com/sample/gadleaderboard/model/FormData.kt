package com.sample.gadleaderboard.model

import java.io.Serializable

data class FormData(
    val firstName: String,
    val lastName: String,
    val email: String,
    val projectLink: String
) : Serializable