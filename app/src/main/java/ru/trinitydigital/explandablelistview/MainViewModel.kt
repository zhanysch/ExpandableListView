package ru.trinitydigital.explandablelistview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.trinitydigital.data.model.MainModel
import ru.trinitydigital.data.model.SecondModel

class MainViewModel : ViewModel() {

    val data = MutableLiveData<List<MainModel>>()

    init {
        generateMainData()
    }


    private fun generateMainData() {
        val list = arrayListOf<MainModel>()

        for (i in 0..100) {
            val item = MainModel(
                id = i,
                title = "title of primary data $i",
                subList = generateSecondData(i)
            )
            list.add(item)
        }

        data.postValue(list)
    }

    private fun generateSecondData(pos: Int): ArrayList<SecondModel> {
        val list = arrayListOf<SecondModel>()
        val rnds = (1..10).random()
        for (i in 0..rnds) {
            list.add(SecondModel(id = i, title = "title of second data $pos $i"))
        }

        return list
    }
}