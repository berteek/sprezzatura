package com.example.sprezzatura.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprezzatura.guider.Guider
import com.example.sprezzatura.guider.GuiderAdapter
import com.example.sprezzatura.R
import com.example.sprezzatura.databinding.FragmentOtherBinding

class OtherFragment : Fragment() {

    private var _binding: FragmentOtherBinding? = null
    private lateinit var binding: FragmentOtherBinding

    private val adapter = GuiderAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOtherBinding.bind(view)
        _binding = binding

        init()

        var node: Guider.TreeNode = Guider.TreeNode("Title text Title text Title text Title text Title text",
            arrayListOf(
            Guider.ContentItem("first item", ""),
            Guider.ContentItem("second item", ""),
            Guider.ContentItem("third item", "")
        ))

        addNode(node)
    }

    private fun init() {
        binding.apply {
            guiderRecyclerView.layoutManager = LinearLayoutManager(this@OtherFragment.context)
            guiderRecyclerView.adapter = adapter
        }
    }

    private fun addNode(node: Guider.TreeNode) {
        binding.guiderTextView.text = node.titleText
        adapter.addNode(node)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_other, container, false)
    }
}