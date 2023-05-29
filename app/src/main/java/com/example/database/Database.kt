package com.example.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class Database(
    context: Context?,

) : SQLiteOpenHelper(context, "pooja.db", null,4 ) {

    var TABLE_NAME = "trans"
    var ID = "id"
    var AMOUNT = "amount "
    var CATEGORY = "category "
    var NOTE = "note"
    var IS_EXPENSES = "isexpenses"

    override fun onCreate(p0: SQLiteDatabase?) {
        var que = "CREATE TABLE  $TABLE_NAME($ID INTEGER PRIMARY KEY AUTONCRMMENT , $AMOUNT INTEGER , $CATEGORY TEXT , $NOTE TEXT ,$IS_EXPENSES INTEGER )"
        p0?.execSQL(que)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun addTrans(Model: Model){
        var db:SQLiteDatabase = writableDatabase
        var values = ContentValues().apply {
            Model.apply {
                put(AMOUNT,amount)
                put(CATEGORY,category)
                put(NOTE,note)
                put(IS_EXPENSES,isExpense)

            }
        }
        db.insert(TABLE_NAME,null,values )

    }
}