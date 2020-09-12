package com.sample.gadleaderboard.component

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.sample.gadleaderboard.R
import com.sample.gadleaderboard.model.ApiService
import com.sample.gadleaderboard.model.FormData
import kotlinx.android.synthetic.main.confirm_dialog.*
import kotlinx.android.synthetic.main.fail_dialog.*
import kotlinx.android.synthetic.main.success_dialog.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ConfirmDialog(context: Context) : DialogFragment() {

    private lateinit var formData: FormData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
        formData = arguments?.getSerializable("formData") as FormData
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.confirm_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(ApiService.FORM_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(ApiService::class.java)

        dialogCancel.setOnClickListener {
            dismiss()
        }

        dialogConfirm.setOnClickListener {
            api.submitFormRequest(
                firstName = formData.firstName,
                emailAddress = formData.lastName,
                lastName = formData.email,
                projectLink = formData.projectLink
            ).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.code() >= 200) {
                        // show success dialog
                        dismiss()
                        Toast.makeText(
                            requireContext(),
                            response.code().toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                        SuccessDialog(requireContext()).show()
                    } else {
                        //show fail dialog
                        FailDialog(requireContext()).show()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    // show fail dialog
                    FailDialog(requireContext()).show()
                }

            })
        }
    }
}

class SuccessDialog(context: Context) : Dialog(context) {
    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.success_dialog)
        setCancelable(false)
        setCanceledOnTouchOutside(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialogDismiss.setOnClickListener {
            dismiss()
        }
    }
}

class FailDialog(context: Context) : Dialog(context) {
    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.fail_dialog)
        setCancelable(false)
        setCanceledOnTouchOutside(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialogClose.setOnClickListener {
            dismiss()
        }
    }

}