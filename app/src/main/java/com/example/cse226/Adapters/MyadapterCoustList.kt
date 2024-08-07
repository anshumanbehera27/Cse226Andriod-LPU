package com.example.cse226.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.cse226.Model.ModelList
import com.example.cse226.R

class MyadapterCoustList(
    context: Context,
    private val resource: Int,
    private val items: List<ModelList>
) : ArrayAdapter<ModelList>(context, resource, items) {

    /*
    // TODO 2 Custom List View Adapter
      context - current activity
      resource - layout file in which layout you want to show the data XML file
      items - data all of the data you need to pass to show in the list view
    */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = convertView ?: layoutInflater.inflate(resource, parent, false)
        /*
         LayoutInflater is a class in Android that's responsible
         for taking your XML layout files and converting them into View objects
         that can be displayed on the screen. Essentially, it "inflates" your layouts
        */
        // Get access to all the data from the Custom XML file
        val imageView = view.findViewById<ImageView>(R.id.ivprofile)
        val titleTextView = view.findViewById<TextView>(R.id.tvheading)
        val descriptionTextView = view.findViewById<TextView>(R.id.tvdescription)
        val delete = view.findViewById<Button>(R.id.btndelete)

        // Initialize the total item from the data
        val mItem = items[position]
        imageView.setImageDrawable(context.resources.getDrawable(mItem.image, null))
        titleTextView.text = mItem.heading
        descriptionTextView.text = mItem.description
        // how to delete the Item with the help of the Alert Dialog
        return view
    }
}

