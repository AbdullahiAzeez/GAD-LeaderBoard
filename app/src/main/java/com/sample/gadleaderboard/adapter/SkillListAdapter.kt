package com.sample.gadleaderboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sample.gadleaderboard.R
import com.sample.gadleaderboard.model.skillIq.SkillLeader

class SkillListAdapter :
    ListAdapter<SkillLeader, SkillListAdapter.ViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_user_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val learnerName: TextView = view.findViewById(R.id.user_name)
        private val learnerOthers: TextView = view.findViewById(R.id.user_details)
        private val learningBadge: ImageView = view.findViewById(R.id.image_user)
        fun bind(leader: SkillLeader) {
            learnerName.text = leader.name
            learnerOthers.text = "${leader.score} skill IQ score, ${leader.country}."
            Glide.with(view)
                .load(leader.badgeUrl)
                .placeholder(R.drawable.ic_top_learner)
                .into(learningBadge)
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<SkillLeader>() {

        override fun areItemsTheSame(oldItem: SkillLeader, newItem: SkillLeader): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(
            oldItem: SkillLeader,
            newItem: SkillLeader
        ): Boolean =
            oldItem == newItem
    }
}