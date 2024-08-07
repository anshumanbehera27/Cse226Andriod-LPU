package com.example.cse226

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.cse226.Adapters.MyadapterCoustList
import com.example.cse226.Model.ModelList

class CoustomListActivity : AppCompatActivity() {
    lateinit var listView: ListView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coustom_list_view)

        listView = findViewById(R.id.coustom_listview)
        var list = mutableListOf<ModelList>()
        list.add(ModelList(R.drawable.food_1 , "food1" , "best food to have"))
        list.add(ModelList(R.drawable.food_2 , "food2" , "good food to have "))
        list.add(ModelList(R.drawable.food_3 , "food3" , "this the most fav food of your coustomer"))
        list.add(ModelList(R.drawable.food_4 , "food4" , "best food to have"))

        var ad = MyadapterCoustList(this , R.layout.coustom_list_view , list)
        // now fill the Adapter to the List view
        listView.adapter = ad

     // TODO how to delete by selecting the code in the list view
        listView.setOnItemClickListener{
            adapterView , view , position , id ->
            list.removeAt(position)
            ad.notifyDataSetChanged()

        }

        // Todo how to delete by Long press it
        listView.setOnItemLongClickListener{
                adapterView , view , position , id ->
            list.removeAt(position)
            ad.notifyDataSetChanged()
            return@setOnItemLongClickListener  true
        }

        // TODO How to apply the Altert Function on the List view
        /**
         * how to apply the dilgo box in side the list view
         * how to build to
         * dilog box is that where we need to  find the popup message and got the answer to it
         *
         */
        listView.setOnItemClickListener{
            adapterView , view , position , id ->
            val builder = AlertDialog.Builder(this)
            builder.setCancelable(true)
            builder.setTitle("Delete")
            builder.setMessage("Are you sure you want to delete this item?")
            builder.setPositiveButton("Yes") { dialog, which ->
                list.removeAt(position)
                ad.notifyDataSetChanged()
            }
            builder.setNegativeButton("No") { dialog, which ->
                dialog.cancel()
            }
            builder.show()
        }
    }
}