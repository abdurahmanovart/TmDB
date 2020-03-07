package ai.arturxdroid.tmdb.ui.binding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object PicassoBindingAdapter {

    val IMAGE_URL = "https://image.tmdb.org/t/p/w500"

    @JvmStatic
    @BindingAdapter("bind:imageUrl")
    public fun loadImage(imageView: ImageView, urlImage: String?) {
        if (urlImage != null)
            Picasso.get().load(IMAGE_URL + urlImage).into(imageView)
    }

    @JvmStatic
    @BindingAdapter("bind:src")
    fun setImageResource(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource)
    }

    @JvmStatic
    @BindingAdapter("bind:src")
    fun setImageResource(imageView: ImageView, resource: Drawable) {
        imageView.setImageDrawable(resource)
    }
}