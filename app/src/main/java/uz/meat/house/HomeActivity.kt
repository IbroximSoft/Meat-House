package uz.meat.house

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import uz.meat.house.basket.BasketFragment
import uz.meat.house.databinding.ActivityHomeBinding
import uz.meat.house.home.HomeFragment
import uz.meat.house.more.MoreFragment
import uz.meat.house.search.SearchFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appbar()
    }

    private fun appbar(){
        binding.apply {
            bottomNavigation.setOnItemSelectedListener {
                when (it.itemId) {

                    R.id.nav_home -> {
                        loadFragment(HomeFragment())
                        true
                    }
                    R.id.nav_search -> {
                        loadFragment(SearchFragment())
                        true
                    }
                    R.id.nav_basket -> {
                        loadFragment(BasketFragment())
                        true
                    }
                    R.id.nav_more -> {
                        loadFragment(MoreFragment())
                        true
                    }
                    else -> false
                }
            }
        }
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.menu_fragment,fragment)
        transaction.commit()
    }
}