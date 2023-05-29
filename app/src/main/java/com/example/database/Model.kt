package com.example.database

import android.icu.util.CurrencyAmount
import android.provider.ContactsContract.CommonDataKinds.Note

class Model {

    var id = 0
    var amount = 0
    var category = ""
    var  note = ""
    var isExpense = 0

    constructor(id: Int, amount: Int , category : String , note : String,isExpense: Int){
        this.id =id
        this.amount = amount
        this.category = category
        this.note = note
        this.isExpense =isExpense
    }

}