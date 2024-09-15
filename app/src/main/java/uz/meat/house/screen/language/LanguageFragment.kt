package uz.meat.house.screen.language

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yariksoffice.lingver.Lingver
import uz.meat.house.utils.Preferences
import uz.meat.house.R
import uz.meat.house.databinding.FragmentLanguageBinding
import uz.meat.house.screen.ScreenActivity
import uz.meat.house.screen.language.adapter.List
import uz.meat.house.screen.language.adapter.MoreAdapter
import uz.meat.house.utils.languageIntents

class LanguageFragment : Fragment() {

    private var _binding: FragmentLanguageBinding? = null
    private val binding get() = _binding!!
    private lateinit var languageList: ArrayList<List>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLanguageBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Preferences.init(requireContext())

        val imageId = intArrayOf(
            R.drawable.uzb_language,
            R.drawable.english_language,
            R.drawable.russia_language
        )

        val text = arrayOf(
            "O'zbekcha",
            "English",
            "Русский"
        )

        languageList = ArrayList()

        for (i in text.indices) {
            val list = List(text[i], imageId[i])
            languageList.add(list)
        }

        binding.apply {
            languagesList.isClickable = true
            languagesList.adapter = MoreAdapter(view.context as Activity, languageList)

            languagesList.onItemClickListener =
                AdapterView.OnItemClickListener { _: AdapterView<*>?, _: View?, position: Int, _: Long ->
                    when (position) {
                        0 -> {
                            languageChange("uz")
                        }

                        1 -> {
                            languageChange("en")
                        }

                        2 -> {
                            languageChange("ru")
                        }
                    }
                }

            btnLanguage.setOnClickListener {
                val intent = Intent(requireContext(), ScreenActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                requireActivity().finish()
            }
        }
    }

    private fun languageChange(text: String) {
        Lingver.getInstance().setLocale(requireContext(), text)
        Preferences.language = text
        findNavController().navigate(R.id.languageFragment)
//        languageIntents(requireContext())
    }
}