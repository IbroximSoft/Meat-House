package uz.meat.house.screen

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import uz.meat.house.R
import uz.meat.house.databinding.ActivitySplashesBinding

class SplashesActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashesBinding

    private var splashTimer = 4000
    private val mTimeCounter = object : CountDownTimer(splashTimer.toLong(), 100) {
        override fun onTick(p0: Long) {}

        override fun onFinish() {
            binding.apply {
                splashLinear.isVisible = false
                splashFragment.isVisible = true
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mTimeCounter.start()
    }
}