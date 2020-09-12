package com.sample.gadleaderboard.ui.fragment

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sample.gadleaderboard.R
import com.sample.gadleaderboard.ui.fragment.learningLeaders.LearningLeaderFragment
import com.sample.gadleaderboard.ui.fragment.skillIQ.SkillIQFragment

private val TAB_TITLES = arrayOf(
    R.string.learning_leader_text,
    R.string.skill_iq_test
)

class SectionPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            LearningLeaderFragment.newInstance()
        } else {
            SkillIQFragment.newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }
}