package com.sample.gadleaderboard.ui.fragment.formSubmission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sample.gadleaderboard.R

class FormSubmissionFragment : Fragment() {

    private lateinit var viewModel: FormSubmissionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.form_submission_fragment, container, false)
    }

}