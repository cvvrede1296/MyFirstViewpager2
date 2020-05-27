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
class Placeholder1Fragment : Fragment() {

    private lateinit var pageViewModel: Page1ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
        //    setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        //}
        pageViewModel = Page1ViewModel()
        pageViewModel.setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?:1)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_1, container, false)
        val textView: TextView = root.findViewById(R.id.section_label_1)
        pageViewModel.text.observe(viewLifecycleOwner, Observer<String> {
            textView.text = it
        })
        return root
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): Placeholder1Fragment {
            return Placeholder1Fragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}