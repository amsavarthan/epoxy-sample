package com.amsavarthan.sample.epoxy.epoxy

import com.airbnb.epoxy.AsyncEpoxyController
import com.amsavarthan.sample.epoxy.models.Profile
import com.amsavarthan.sample.epoxy.recentlyActiveItem

class MoreController(
    private val callback: AdapterCallback
) : AsyncEpoxyController() {

    var recentlyActive: List<Profile> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {

        this@MoreController.recentlyActive.first().let {
            recentlyActiveItem {
                id(it.id)
                profile(it)
                spanSizeOverride { totalSpanCount, _, _ -> totalSpanCount }
                clickListener { _ -> this@MoreController.callback.onItemClicked() }
            }
        }

        recentlyActive.subList(1, recentlyActive.size).forEach {
            recentlyActiveItem {
                id(it.id)
                profile(it)
                clickListener { _ -> this@MoreController.callback.onItemClicked() }
            }
        }

    }

    interface AdapterCallback {
        fun onItemClicked()
    }

}