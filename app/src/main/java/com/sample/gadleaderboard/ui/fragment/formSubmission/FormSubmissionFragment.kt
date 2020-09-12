package com.sample.gadleaderboard.ui.fragment.formSubmission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.sample.gadleaderboard.R
import com.sample.gadleaderboard.component.ConfirmDialog
import com.sample.gadleaderboard.model.FormData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.form_submission_fragment.*

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

        submit_form.setOnClickListener {
            if (first_name.checkField() && last_name.checkField() && email.checkEmail() && project_link.checkField()) {
                val formData = FormData(
                    firstName = first_name.text.toString(),
                    lastName = last_name.text.toString(),
                    email = email.text.toString(),
                    projectLink = project_link.text.toString()
                )
                val bundle = Bundle()
                bundle.putSerializable("formData", formData)
                val dialog = ConfirmDialog(requireContext())
                dialog.arguments = bundle
                dialog.show(childFragmentManager, "dialog_confirm")
            }
        }
    }

    private fun TextInputEditText.checkField(): Boolean {
        if (text.toString().isNullOrBlank()) {
            error = "Field Cannot be empty"
            return false
        }
        return true
    }

    private fun TextInputEditText.checkEmail(): Boolean {
        return if (!text.toString().isNullOrBlank()) {
            if (text.toString().contains("@")) {
                true
            } else {
                error = "Enter the appropriate field"
                false
            }
        } else {
            error = "Field Cannot be empty"
            false
        }
    }

    override fun onResume() {
        super.onResume()
        clearForm()
    }

    private fun clearForm() {
        first_name.setText("")
        last_name.setText("")
        email.setText("")
        project_link.setText("")
    }
}