package com.sample.gadleaderboard.ui.fragment.learningLeaders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.gadleaderboard.R
import com.sample.gadleaderboard.adapter.LearnerListAdapter
import com.sample.gadleaderboard.model.ApiService
import com.sample.gadleaderboard.model.learningLeaders.LearningLeader
import kotlinx.android.synthetic.main.learning_leader_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LearningLeaderFragment : Fragment() {

    companion object {
        fun newInstance() = LearningLeaderFragment()
    }

    private lateinit var viewModel: LearningLeaderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.learning_leader_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        leader_list.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val adapter = LearnerListAdapter()
        leader_list.adapter = adapter

        val api = retrofit.create(ApiService::class.java)
        api.getLearningLeaders().enqueue(object : Callback<List<LearningLeader>> {
            override fun onResponse(
                call: Call<List<LearningLeader>>,
                response: Response<List<LearningLeader>>
            ) {
                adapter.submitList(response.body())
            }

            override fun onFailure(call: Call<List<LearningLeader>>, t: Throwable) {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
            }

        })
    }


}