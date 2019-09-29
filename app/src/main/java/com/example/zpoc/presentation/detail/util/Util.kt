package com.example.zpoc.presentation.detail.util

import com.example.zpoc.domain.model.User
import javax.inject.Inject

class Util @Inject constructor() {

    fun formatUserIntoLabelStrning(user: User): String {
        return "Name: ${user.username} \n " +
                "Email: ${user.email} \n" +
                "Phone: ${user.phone} \n" +
                "Website: ${user.website}"
    }

}