package com.sample.gadleaderboard.ui.fragment.leaderBoard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.sample.gadleaderboard.R
import com.sample.gadleaderboard.ui.fragment.SectionPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class LeaderBoardFragment : Fragment() {

    private lateinit var viewModel: LeaderBoardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.leader_board_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sectionsPagerAdapter = SectionPagerAdapter(requireContext(), childFragmentManager)
        val viewPager: ViewPager = view.findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = view.findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
    }

    override fun onResume() {
        super.onResume()
        requireActivity().submit.visibility = View.VISIBLE
    }
}