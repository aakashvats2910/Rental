package com.example.rental.adapters

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.NonNull
import com.example.rental.R
import com.example.rental.util.Result

class ResultAdapter : ArrayAdapter<Result> {

    constructor(context: Context, resource: Int, objects: List<Result>) : super(
        context,
        resource,
        objects
    )

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var myConvertedView = convertView
        myConvertedView = (context as Activity).layoutInflater.inflate(R.layout.result_list, parent, false)

        var description_field = myConvertedView.findViewById<TextView>(R.id.description_field)
        var place_field = myConvertedView.findViewById<TextView>(R.id.place_field)

        val result = getItem(position)

        place_field.text = result!!.place
        description_field.text = result.description

        return myConvertedView
    }


}