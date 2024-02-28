package com.example.driveeasy

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val SPLASH_SCREEN = 5000

    // Variables
    private lateinit var topAnim: Animation
    private lateinit var bottomAnim: Animation
    private lateinit var image: ImageView
    private lateinit var logo: TextView
    private lateinit var slogan: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        // Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        // Hooks
        image = findViewById(R.id.imageView2)
        logo = findViewById(R.id.textView)
        slogan = findViewById(R.id.textView)

        image.startAnimation(topAnim)
        logo.startAnimation(bottomAnim)
        slogan.startAnimation(bottomAnim)

        Handler().postDelayed({
            val intent = Intent(this@MainActivity, SigninActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_SCREEN.toLong())
    }
}