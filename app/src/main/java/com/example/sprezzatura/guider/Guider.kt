package com.example.sprezzatura.guider

class Guider {

    class TreeNode(var titleText: String, var content: ArrayList<ContentItem>) {
        lateinit var nextNode : TreeNode
        lateinit var previousNode : TreeNode
    }

    class ContentItem(val title: String = "placeholder", val link: String) {

    }
}