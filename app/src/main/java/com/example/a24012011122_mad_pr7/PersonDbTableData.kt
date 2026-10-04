package com.example.a24012011122_mad_pr7

object PersonDbTableData {
    const val TABLE_NAME = "persons"
    const val COL_ID = "id"
    const val COL_NAME = "name"
    const val COL_EMAIL = "email"
    const val COL_PHONE = "phone"
    const val COL_ADDRESS = "address"
    const val COL_LATITUDE = "latitude"
    const val COL_LONGITUDE = "longitude"

    const val CREATE_TABLE = "CREATE TABLE $TABLE_NAME (" +
            "$COL_ID TEXT PRIMARY KEY, " +
            "$COL_NAME TEXT, " +
            "$COL_EMAIL TEXT, " +
            "$COL_PHONE TEXT, " +
            "$COL_ADDRESS TEXT, " +
            "$COL_LATITUDE REAL, " +
            "$COL_LONGITUDE REAL)"
}
