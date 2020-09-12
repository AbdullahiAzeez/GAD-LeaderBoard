package com.sample.gadleaderboard.ui.fragment.formSubmission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sample.gadleaderboard.R
import kotlinx.android.synthetic.main.activity_main.*

class FormSubmissionFragment : Fragment() {

    private lateinit var viewModel: FormSubmissionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.form_submission_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().submit.visibility = View.INVISIBLE
    }

}