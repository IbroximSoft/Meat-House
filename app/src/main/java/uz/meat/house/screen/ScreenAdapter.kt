package uz.meat.house.screen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import uz.meat.house.R

class ScreenAdapter internal constructor(private val context: Context) : PagerAdapter() {
    private val layouts = intArrayOf(
        R.layout.screen_one_item,
        R.layout.screen_two_item
    )

    override fun getCount(): Int {
        return layouts.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(layouts[position], container, false)
        view.tag = position
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container).removeView(`object` as View?)
    }

}