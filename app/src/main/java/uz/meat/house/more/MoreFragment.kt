package uz.meat.house.more

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import uz.meat.house.R
import uz.meat.house.databinding.FragmentMoreBinding
import uz.meat.house.screen.language.adapter.List
import uz.meat.house.utils.Preferences
import uz.meat.house.utils.warningToast

class MoreFragment : Fragment() {

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!
    private lateinit var languageList: ArrayList<List>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Preferences.init(requireContext())

        val imageId = intArrayOf(
            R.drawable.ic_news,
            R.drawable.ic_language,
            R.drawable.ic_night,
            R.drawable.ic_help,
            R.drawable.ic_share,
            R.drawable.ic_work,
            R.drawable.ic_info,
        )

        val text = arrayOf(
            "Yangiliklar",
            "Til",
            "Qorong'u rejim",
            "Yordam",
            "Ulashish",
            "Yetkazib berish shartlari",
            "Yuridik ma'lumot"
        )

        languageList = ArrayList()

        for (i in text.indices) {
            val list = List(text[i], imageId[i])
            languageList.add(list)
        }

        binding.apply {
            moreList.isClickable = true
            moreList.adapter = MoreAdapter(view.context as Activity, languageList)

            moreList.onItemClickListener =
                AdapterView.OnItemClickListener { _: AdapterView<*>?, _: View?, position: Int, _: Long ->
                    when (position) {
                        0 -> {
                            warningToast("Yangiliklar")
                        }

                        1 -> {
                            warningToast("Til")
                        }

                        2 -> {
                            warningToast("Qorong'u rejim")
                        }

                        3 -> {
                            warningToast("Yordam")
                        }

                        4 -> {
                            warningToast("Ulashish")
                        }

                        5 -> {
                            warningToast("Yetkazib berish shartlari")
                        }

                        6 -> {
                            warningToast("Yuridik ma'lumot")
                        }

                    }
                }
        }
    }
}