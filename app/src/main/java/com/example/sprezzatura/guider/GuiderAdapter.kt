package com.example.sprezzatura.guider

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sprezzatura.R
import com.example.sprezzatura.databinding.GuiderButtonBinding

class GuiderAdapter: RecyclerView.Adapter<GuiderAdapter.GuiderHolder>() {

    private var content = ArrayList<Guider.ContentItem>()

    class GuiderHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = GuiderButtonBinding.bind(item)

        fun bind(contentItem: Guider.ContentItem) = with(binding) {
            textView.text = contentItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuiderHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.guider_button, parent, false)
        return GuiderHolder(view)
    }

    override fun onBindViewHolder(holder: GuiderHolder, position: Int) {
        holder.bind(content[position])
    }

    override fun getItemCount(): Int {
        return content.size
    }

    fun addContentItem(contentItem: Guider.ContentItem) {
        content.add(contentItem)
        notifyDataSetChanged()
    }

    private fun clearContent() {
        content.clear()
        notifyDataSetChanged()
    }

    fun addNode(node: Guider.TreeNode) {
        content = node.content
        notifyDataSetChanged()
    }
}