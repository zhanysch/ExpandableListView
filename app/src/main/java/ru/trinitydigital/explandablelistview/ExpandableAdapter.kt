package ru.trinitydigital.explandablelistview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import android.widget.Toast
import ru.trinitydigital.data.model.MainModel

class ExpandableAdapter : BaseExpandableListAdapter() {

    private val list = arrayListOf<MainModel>()

    fun update(list: List<MainModel>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getGroupCount() = list.size

    override fun getChildrenCount(groupPosition: Int) = list[groupPosition].subList.size

    override fun getGroup(groupPosition: Int) = list[groupPosition]

    override fun getChild(groupPosition: Int, childPosition: Int) =
        list[groupPosition].subList[childPosition]

    override fun getGroupId(groupPosition: Int) = groupPosition.toLong()

    override fun getChildId(groupPosition: Int, childPosition: Int) = childPosition.toLong()

    override fun hasStableIds() = true

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_parent, parent, false)

        }
        view?.findViewById<TextView>(R.id.tv_title)?.text = list[groupPosition].title

        return view
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        var view = convertView
        if (convertView == null) {
            view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_child, parent, false)

        }

        val item = list[groupPosition].subList[childPosition]
        view?.findViewById<TextView>(R.id.tv_title)?.text =
            item.title
        view?.setOnClickListener {
            Toast.makeText(parent?.context, item.title, Toast.LENGTH_LONG).show()
        }

        return view
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int) = true
}