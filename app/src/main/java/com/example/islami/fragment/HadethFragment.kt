package com.example.islami.fragment

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.*
import com.example.islami.Adapters.HadethlistAdapter
import com.example.islami.ui.activity.SuraDetailsActivity
import kotlinx.android.synthetic.main.fragment_dailog_hadeth.*
import kotlinx.android.synthetic.main.fragment_hadeth.*
import kotlinx.android.synthetic.main.hadeth_item.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.reflect.Array


class HadethFragment : Fragment(){
     var titles =ArrayList<String>()
    val Hadethcontent = ArrayList<String>()
    lateinit var hadethlistAdapter: HadethlistAdapter
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadethTitle()
        hadethlistAdapter = HadethlistAdapter(titles)

        recyclerview_hadeth.adapter = hadethlistAdapter
        hadethlistAdapter.OnHadethClick = object : HadethlistAdapter.OnTitleHadethClickListener {
            override fun OnItemClick(position: Int, title: String) {
                val dialog = DailogHadethFragment()
                val args = Bundle()
                args.putString(Constants.EXTRA_Hadeth_Title,title)
                readAhadethcontent()
                args.putString(Constants.EXTRA_Hadeth_Contact,Hadethcontent.get(position))
                dialog.arguments=args
               dialog.show(childFragmentManager, "")

            }
        }

    }

    private fun readAhadethcontent():List<String>{

        val reader:BufferedReader
        try {
            val file :InputStream?=context?.assets?.open("ahadeth.txt")
            reader= BufferedReader(InputStreamReader(file))
            var line:String?=""
            line=reader.readLine()

            while(line!=null){
                val title =line
                var content =""
                line =reader.readLine()
                while (!line?.trim().equals("#")) {
                    content+=line
                    line = reader.readLine()

                }
                Hadethcontent.add(content)
                Log.e("Hadethcontent",Hadethcontent.first())
                line=reader.readLine()
            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
        return Hadethcontent
    }


    fun readHadethTitle (): List<String>{

        val fileName ="ahadeth.txt"
        val reader: BufferedReader
        try {
            val file: InputStream? = activity?.assets?.open(fileName)
            reader = BufferedReader(InputStreamReader(file))
            var line: String? = ""
            line = reader.readLine()
            titles.add(line)
            line = reader.readLine()
            while (line!=null) {
                while (line != null && line.equals("#")) {
                    line = reader.readLine()
                    titles.add(line)


                    line=reader.readLine()
                }
                line = reader.readLine()
            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
        return titles

    }
}
