package uz.meat.house.screen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import uz.meat.house.HomeActivity
import uz.meat.house.R
import uz.meat.house.databinding.ActivityScreenBinding

class ScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScreenBinding
    private var screenAdapter: ScreenAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        screenAdapter = ScreenAdapter(this)
        binding.apply {
            screenPage.adapter = screenAdapter
            screenPage.setPageTransformer(false, ScreenPageTransformer())
        }
    }

    fun nextPage(view: View) {
        if (view.id == R.id.screen_next) {
            if (binding.screenPage.currentItem < screenAdapter?.count!! - 1) {
                binding.screenPage.setCurrentItem(binding.screenPage.currentItem + 1, true)
            }
        }
    }

    fun nextPage4(view: View) {
        if (view.id == R.id.screen_finish) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}