package com.example.myfirstviewpager2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.myfirstviewpager2.R

/**
 * A placeholder fragment containing a simple view.
 */
class Placeholder2Fragment : Fragment() {

    private lateinit var pageViewModel: Page2ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
        //    setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        //}
        pageViewModel = Page2ViewModel()
        pageViewModel.setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?:1)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_2, container, false)
        val textView: TextView = root.findViewById(R.id.section_label_2)
        pageViewModel.text.observe(viewLifecycleOwner, Observer<String> {
            textView.text = it
        })
        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): Placeholder2Fragment {
            return Placeholder2Fragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}