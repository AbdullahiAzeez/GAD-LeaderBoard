package com.sample.gadleaderboard.ui.fragment.skillIQ

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.gadleaderboard.R
import com.sample.gadleaderboard.adapter.SkillListAdapter
import com.sample.gadleaderboard.model.ApiService
import com.sample.gadleaderboard.model.skillIq.SkillLeader
import kotlinx.android.synthetic.main.skill_iq_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SkillIQFragment : Fragment() {

    companion object {
        fun newInstance() = SkillIQFragment()
    }

    private lateinit var viewModel: SkillIqViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.skill_iq_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        skill_list.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL, false
        )
        val adapter = SkillListAdapter()
        skill_list.adapter = adapter


        val api = retrofit.create(ApiService::class.java)
        api.getSkillLeaders().enqueue(object : Callback<List<SkillLeader>> {
            override fun onResponse(
                call: Call<List<SkillLeader>>,
                response: Response<List<SkillLeader>>
            ) {
                adapter.submitList(response.body())
            }

            override fun onFailure(call: Call<List<SkillLeader>>, t: Throwable) {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
            }

        })
    }
}