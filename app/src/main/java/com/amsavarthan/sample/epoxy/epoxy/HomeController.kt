package com.amsavarthan.sample.epoxy.epoxy

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.carousel
import com.amsavarthan.sample.epoxy.RecentlyActiveItemBindingModel_
import com.amsavarthan.sample.epoxy.epoxy.models.headerItem
import com.amsavarthan.sample.epoxy.messageItem
import com.amsavarthan.sample.epoxy.models.Message
import com.amsavarthan.sample.epoxy.models.Profile

class HomeController(
    private val callback: AdapterCallback
) : AsyncEpoxyController() {

    var recentlyActive: List<Profile> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    var allMessages: List<Message> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {

        headerItem {
            id("recently_active")
            title("Recently Active")
            clickListener { _ -> this@HomeController.callback.goToMoreFragment() }
        }

        val models = recentlyActive.map {
            RecentlyActiveItemBindingModel_()
                .id(it.id)
                .profile(it)
                .clickListener { _ -> this@HomeController.callback.onItemClicked() }
        }

        carousel {
            id("recent")
            padding(Carousel.Padding.dp(12, 4, 12, 16, 4))
            models(models)
            numViewsToShowOnScreen(2.65f)
        }

        headerItem {
            id("all_messages")
            title("All Messages")
        }

        allMessages.forEach {
            messageItem {
                id(it.id)
                message(it)
                clickListener { _ -> this@HomeController.callback.onItemClicked() }
            }
        }

    }

    interface AdapterCallback {
        fun onItemClicked()
        fun goToMoreFragment()
    }

}
