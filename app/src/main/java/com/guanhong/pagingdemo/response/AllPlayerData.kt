package com.guanhong.pagingdemo.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class AllPlayerData(
    @SerializedName("data")
    val data: List<DataItem>?
)

@Entity(tableName = "DATA_ITEM_ENTITY")
data class DataItem(

    @PrimaryKey
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("weight_pounds")
    val weightPounds: Int? = 0,

    @SerializedName("height_feet")
    val heightFeet: Int? = 0,

    @SerializedName("height_inches")
    val heightInches: Int? = 0,

    @SerializedName("last_name")
    var lastName: String = "",

    @SerializedName("position")
    val position: String = "",

    @SerializedName("first_name")
    var firstName: String = ""
)