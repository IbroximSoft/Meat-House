package uz.meat.house.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.saadiftkhar.toaster.Toaster
import com.yariksoffice.lingver.Lingver
import uz.meat.house.R
import uz.meat.house.screen.ScreenActivity
import uz.meat.house.screen.SplashesActivity
import java.text.SimpleDateFormat
import java.util.Date

fun languageText(text: String, context: Context) {
    Preferences.init(context)
    when (text) {
        "Uzbekcha" -> {

        }

        "Узбекча" -> {
            Lingver.getInstance().setLocale(context, "ru")
            Preferences.language = "ru"
            languageIntents(context)
        }
    }
}

fun languageIntents(context: Context) {
    val intent = Intent(context, SplashesActivity::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    context.startActivity(intent)
}

fun Fragment.warningToast(text: String) {
    Toaster.warning(context = requireContext(), text = text, font = R.font.roboto_regular)
}

fun Fragment.errorToast(text: String) {
    Toaster.error(context = requireContext(), text = text, font = R.font.roboto_regular)
}

fun Fragment.successToast(text: String) {
    Toaster.success(context = requireContext(), text = text, font = R.font.roboto_regular)
}

@SuppressLint("SimpleDateFormat")
fun todayDate(): String {
    val currentDate: String
    val simpleDate = SimpleDateFormat("dd.MM.yyyy")
    currentDate = simpleDate.format(Date())
    return currentDate
}
