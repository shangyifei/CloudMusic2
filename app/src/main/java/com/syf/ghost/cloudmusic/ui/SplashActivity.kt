package com.syf.ghost.cloudmusic.ui


import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.app.ActivityOptionsCompat
import android.transition.Explode
import android.view.WindowManager
import com.syf.ghost.cloudmusic.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        if (Build.VERSION.SDK_INT>21) {
            window.exitTransition = Explode()
            window.exitTransition.duration =500
        }
        countDownTimer(3000)
        setContentView(R.layout.activity_splash)
        setAdImage("")
        "".repeat(1)
    }

    private fun setAdImage(imageUrl: String) {
        window.setBackgroundDrawable(null)
    }

    private fun countDownTimer(millsTimer: Long) {
        object : CountDownTimer(millsTimer, 1) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                if (Build.VERSION.SDK_INT>15) {
                    startActivity(
                        Intent(this@SplashActivity, MainActivity::class.java),
                        ActivityOptionsCompat.makeSceneTransitionAnimation(this@SplashActivity).toBundle()
                    )
                }else{
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                }
                finish()
            }
        }.start()
    }
}
