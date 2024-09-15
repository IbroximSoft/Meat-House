package uz.meat.house.screen.language.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import uz.meat.house.R
import uz.meat.house.utils.Preferences

class MoreAdapter(private val context: Activity, private val arrayList: ArrayList<List>) :
    ArrayAdapter<List>(context, R.layout.language_item, arrayList) {

    @SuppressLint("InflateParams", "ViewHolder", "MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.language_item, null)

        val imageView: ImageView = view.findViewById(R.id.language_img)
        val languageCheck: ImageView = view.findViewById(R.id.lang_more_icon)
        val textView: TextView = view.findViewById(R.id.language_text)
        imageView.setImageResource(arrayList[position].imageId)
        textView.text = arrayList[position].text

        Preferences.init(context)

        val language = Preferences.language

        if ((position == 0)) {
            if (language == "uz") languageCheck.isVisible = true

        } else if (position == 1) {
            if (language == "en") languageCheck.isVisible = true

        } else if (position == 2) {
            if (language == "ru") languageCheck.isVisible = true
        }

        return view
    }
}