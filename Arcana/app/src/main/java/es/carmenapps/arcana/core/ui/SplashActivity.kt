package es.carmenapps.arcana.core.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import es.carmenapps.arcana.MainActivity
import es.carmenapps.arcana.databinding.FragmentSplashBinding
import es.carmenapps.arcana.util.APP_NAME
import es.carmenapps.arcana.util.FIRST_RUN_KEY
import timber.log.Timber


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

  private lateinit var binding: FragmentSplashBinding
  private var prefs: SharedPreferences? = null


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = FragmentSplashBinding.inflate(layoutInflater)
    setContentView(binding.root)
    prefs = getSharedPreferences(APP_NAME, MODE_PRIVATE)
    supportActionBar?.hide();
    Timber.d("[ARCANALOG] Is first run of APP ${prefs?.getBoolean(FIRST_RUN_KEY, true)}")

      Handler().postDelayed({
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        finish()
      }, 3000)


  }

  override fun onStart() {
    super.onStart()

  }

  override fun onStop() {
    super.onStop()
  }
}