package com.amsavarthan.sample.epoxy.epoxy.models

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.amsavarthan.sample.epoxy.R

@EpoxyModelClass(layout = R.layout.view_holder_header_item)
abstract class HeaderItem : EpoxyModelWithHolder<HeaderItem.Holder>() {

    @EpoxyAttribute
    lateinit var title: String

    @EpoxyAttribute
    var clickListener: View.OnClickListener? = null

    override fun bind(holder: Holder) {
        holder.titleTextView.text = title

        if (clickListener == null) {
            holder.moreButton.visibility = View.INVISIBLE
            return
        }
        holder.moreButton.visibility = View.VISIBLE
        holder.moreButton.setOnClickListener(clickListener)
    }

    class Holder : EpoxyHolder() {

        lateinit var titleTextView: TextView
        lateinit var moreButton: ImageView

        override fun bindView(itemView: View) {
            titleTextView = itemView.findViewById(R.id.header_title)
            moreButton = itemView.findViewById(R.id.btn_more)
        }
    }

}