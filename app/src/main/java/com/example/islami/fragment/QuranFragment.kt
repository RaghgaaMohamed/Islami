package com.example.islami.fragment

import android.content.DialogInterface
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.islami.Adapters.SuralistAdapter
import com.example.islami.Adapters.ayaAdapter
import com.example.islami.AyaResponse
import com.example.islami.Constants
import com.example.islami.R
import com.example.islami.RecitersVerseItem
import com.example.islami.api.ApiManager
import com.example.islami.base.BaseFragment
import com.example.islami.ui.activity.SuraDetailsActivity
import kotlinx.android.synthetic.main.activity_sura_details.*
import kotlinx.android.synthetic.main.fragment_quran.*
import kotlinx.android.synthetic.main.fragment_radio.*
import kotlinx.android.synthetic.main.item_aya.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class QuranFragment : BaseFragment() {

    var ArSuras = listOf("الفاتحه", "البقرة", "آل عمران", "النساء", "المائدة", "الأنعام", "الأعراف", "الأنفال", "التوبة", "يونس", "هود"
        , "يوسف", "الرعد", "إبراهيم", "الحجر", "النحل", "الإسراء", "الكهف", "مريم", "طه", "الأنبياء", "الحج", "المؤمنون"
        , "النّور", "الفرقان", "الشعراء", "النّمل", "القصص", "العنكبوت", "الرّوم", "لقمان", "السجدة", "الأحزاب", "سبأ"
        , "فاطر", "يس", "الصافات", "ص", "الزمر", "غافر", "فصّلت", "الشورى", "الزخرف", "الدّخان", "الجاثية", "الأحقاف"
        , "محمد", "الفتح", "الحجرات", "ق", "الذاريات", "الطور", "النجم", "القمر", "الرحمن", "الواقعة", "الحديد", "المجادلة"
        , "الحشر", "الممتحنة", "الصف", "الجمعة", "المنافقون", "التغابن", "الطلاق", "التحريم", "الملك", "القلم", "الحاقة", "المعارج"
        , "نوح", "الجن", "المزّمّل", "المدّثر", "القيامة", "الإنسان", "المرسلات", "النبأ", "النازعات", "عبس", "التكوير", "الإنفطار"
        , "المطفّفين", "الإنشقاق", "البروج", "الطارق", "الأعلى", "الغاشية", "الفجر", "البلد", "الشمس", "الليل", "الضحى", "الشرح"
        , "التين", "العلق", "القدر", "البينة", "الزلزلة", "العاديات", "القارعة", "التكاثر", "العصر",
        "الهمزة", "الفيل", "قريش", "الماعون", "الكوثر", "الكافرون", "النصر", "المسد", "الإخلاص", "الفلق", "الناس")

    lateinit var suralistAdapter: SuralistAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       suralistAdapter= SuralistAdapter(ArSuras)

        recycler_view.adapter=suralistAdapter

        suralistAdapter.onSuranameClick=object : SuralistAdapter.OnitemClickListener{
            override fun onItemClick(position: Int, name: String) {
                startSuraDetailsActivity(position,name)
            }
        }




    }

    private fun startSuraDetailsActivity(position: Int, name: String) {
        val fileName =""+(position+1)+".txt"
        val intent = Intent(context,SuraDetailsActivity::class.java)
        intent.putExtra(Constants.EXTRA_Sura_Name,name)
        intent.putExtra(Constants.EXTRA_File_Name,fileName)
        startActivity(intent)
    }

}




