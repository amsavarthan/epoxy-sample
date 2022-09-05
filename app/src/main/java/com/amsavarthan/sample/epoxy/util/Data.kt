package com.amsavarthan.sample.epoxy.util

import com.amsavarthan.sample.epoxy.models.Message
import com.amsavarthan.sample.epoxy.models.Profile

object Data {

    val messages = listOf(
        Message(
            0,
            "Anuj",
            "Seals are dumb right?"
        ),
        Message(
            1,
            "Prabakaran",
            "Excited for TGA. You?"
        ),
        Message(
            2,
            "Viswa",
            "We should catch up sometime."
        ),
        Message(
            2,
            "Vasanth",
            "What's going on?"
        )
    )

    val recentlyActive = listOf(
        Profile(
            0,
            "Riyaa",
            "",
            "2 min ago"
        ),
        Profile(
            1,
            "Shiv",
            "",
            "16 min ago"
        ),
        Profile(
            2,
            "Shivanya",
            "",
            "21 min ago"
        ),
        Profile(
            3,
            "Megha",
            "",
            "30 min ago"
        ),
        Profile(
            3,
            "Lisa",
            "",
            "33 min ago"
        )
    )
}