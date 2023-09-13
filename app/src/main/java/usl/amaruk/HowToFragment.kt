package usl.amaruk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.text.Spannable
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import kotlinx.android.synthetic.main.fragment_help.*
import usl.R
import usl.amaruk.utils.LanguageManager
import usl.databinding.FragmentHelpBinding
import usl.databinding.FragmentHomeBinding

class HowToFragment : Fragment() {

    private lateinit var bindingFragmentHelp: FragmentHelpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LanguageManager.updateResources(requireContext(), language.getLangCode())
        return inflater.inflate(R.layout.fragment_help, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingFragmentHelp = FragmentHelpBinding.inflate(layoutInflater)
        bindingFragmentHelp.helpText.text = resources.getString(R.string.how_to_use_descript)
        setFontSizeForPath(SpannableString(resources.getString(R.string.how_to_use_descript)), "業", 0.6f)
    }

    private fun setFontSizeForPath(
        spannable: Spannable,
        path: String,
        fontSizeInPixel: Float
    ) {
        val startIndexOfPath = spannable.toString().indexOf(path)
        if (startIndexOfPath == -1) return
        spannable.setSpan(RelativeSizeSpan(fontSizeInPixel), 80, 82, 0)
        bindingFragmentHelp.helpText.text = spannable
    }
}
