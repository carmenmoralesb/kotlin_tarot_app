package es.carmenapps.arcana.util

import android.widget.TextView

fun showFadingText(view: TextView, text: String?) {
  view.text = text
  view.animate().alpha(1f).setDuration(1000).setStartDelay(0).withEndAction(
    Runnable { view.animate().alpha(0f).setDuration(1000).startDelay = 2000 }
  )
}