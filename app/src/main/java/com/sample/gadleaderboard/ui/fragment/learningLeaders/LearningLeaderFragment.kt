package com.sample.gadleaderboard.ui.fragment.learningLeaders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sample.gadleaderboard.R

class LearningLeaderFragment : Fragment() {

    private lateinit var viewModel: LearningLeaderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.learning_leader_fragment, container, false)
    }
}