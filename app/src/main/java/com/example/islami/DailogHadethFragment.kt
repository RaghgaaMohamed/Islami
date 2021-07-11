package com.example.islami

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_dailog_hadeth.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


class DailogHadethFragment : DialogFragment() {
    val Hadethcontent = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, 0);
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dailog_hadeth, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mArge=arguments
        val hadtitle = mArge?.getString(Constants.EXTRA_Hadeth_Title)
        val hadcontent =mArge?.getString(Constants.EXTRA_Hadeth_Contact)
        Log.e("hadtitle",hadtitle.toString())
        Log.e("hadcontent",hadcontent.toString())
        entrititlehadeth.setText(hadtitle)
        contacthadeth.setText(hadcontent)
    }
    override fun onStart() {
        super.onStart()
        val dialog: Dialog? = getDialog()
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.getWindow()?.setLayout(width, height)
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


}

