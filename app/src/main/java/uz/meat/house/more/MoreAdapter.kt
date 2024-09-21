package uz.meat.house.more

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import uz.meat.house.R
import uz.meat.house.screen.language.adapter.List

class MoreAdapter(private val context: Activity, private val arrayList: ArrayList<List>) :
    ArrayAdapter<List>(context, R.layout.language_item, arrayList) {

    @SuppressLint("InflateParams", "ViewHolder", "MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.more_item, null)

        val imageView: ImageView = view.findViewById(R.id.more_img)
        val textView: TextView = view.findViewById(R.id.more_text)
        imageView.setImageResource(arrayList[position].imageId)
        textView.text = arrayList[position].text

        return view
    }
}