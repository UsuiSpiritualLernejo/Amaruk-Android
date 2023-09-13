package usl.amaruk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import kotlinx.android.synthetic.main.fragment_info.*
import usl.R
import usl.amaruk.utils.LanguageManager
import usl.databinding.FragmentInfoBinding

class AboutFragment : Fragment() {

    private lateinit var bindingFragmentInfo: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LanguageManager.updateResources(requireContext(), language.getLangCode())
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingFragmentInfo = FragmentInfoBinding.inflate(layoutInflater)
        bindingFragmentInfo.textAbout.text = resources.getString(R.string.about_us_descript)
    }
}
