package com.sample.gadleaderboard.ui.fragment.skillIQ

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sample.gadleaderboard.R

class SkillIQFragment : Fragment() {

    private lateinit var viewModel: SkillIqViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.skill_iq_fragment, container, false)
    }
}