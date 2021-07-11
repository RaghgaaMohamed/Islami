package com.example.islami.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.R
import kotlinx.android.synthetic.main.fragment_tasbeh.*
import kotlinx.android.synthetic.main.fragment_tasbeh.view.*


class TasbehFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasbeh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var counteradd=0
        var countertotal=1
        plus.setOnClickListener {
            var add =counteradd++
            var total=countertotal++
            counter.setText(add.toString())
            totalcounter.setText(total.toString())
        }

        refrech.setOnClickListener {
            counter.setText("")
            totalcounter.setText("")
            counteradd=1
            countertotal=1

        }
        refrechcounter.setOnClickListener {
           counter.setText("")
            counteradd=1
        }
        refrechtotal.setOnClickListener {
          totalcounter.setText("")
            countertotal=1
        }

    }
}




