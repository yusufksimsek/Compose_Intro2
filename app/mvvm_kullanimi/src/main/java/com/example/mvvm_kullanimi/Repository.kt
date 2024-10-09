package com.example.mvvm_kullanimi

import androidx.lifecycle.MutableLiveData

class Repository {

    var matematikselSonuc = MutableLiveData<String>()

    init {
        matematikselSonuc = MutableLiveData<String>("0")
    }

    fun matematikselSonucuGetir():MutableLiveData<String>{
        return matematikselSonuc
    }

    fun topla(alinanSayi1: String, alinanSayi2:String){

        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()

        val toplam = sayi1 + sayi2

        matematikselSonuc.value = toplam.toString()
    }

    fun carp(alinanSayi1: String, alinanSayi2:String){

        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()

        val carpim = sayi1 * sayi2

        matematikselSonuc.value = carpim.toString()
    }

}