package uk.fernando.spacex.helpers

import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import uk.fernando.spacex.R
import uk.fernando.spacex.extension.toFormattedPrice


@BindingAdapter(value = ["loadImage"])
fun ImageView.loadImage(imageList: List<String>?) {
    if (imageList == null || imageList.isEmpty())
        load("") {
            error(R.drawable.image_not_found)
        }
    else
        load(imageList[0]) {
            error(R.drawable.image_not_found)
            placeholder(R.drawable.ic_loading_image)
            crossfade(true)
        }
}

@BindingAdapter(value = ["formattedPrice"])
fun TextView.formattedPrice(amount: Int) {
    text = amount.toDouble().toFormattedPrice("US$")
}

@BindingAdapter(value = ["setStatusColor"])
fun TextView.setStatusColor(status: Boolean) {
    if (status)
        setTextColor(Color.GREEN)
    else
        setTextColor(Color.RED)
}
