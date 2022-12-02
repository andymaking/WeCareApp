package io.king.wecareapp.data.dummy

import android.os.Parcelable
import io.king.wecareapp.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Resdents(
    var image : Int, var name: String, var age: Int, var sex: String, var contact: String, var address: String, var role: String
): Parcelable

val residentsList = arrayOf(
    Resdents(
        image = R.drawable.pic_1,
        name = "Angel Emeka",
        age = 43,
        sex = "female",
        contact = "07066886668",
        address = "NO. 1 D.B Zang road, Jos, Plateau state",
        role = "resident"
    ),
)


data class DropDown(
    var image : Int, var title: String, var assessment: String, var comment: String, var visibility : Boolean = false
)

val dropDownList = arrayOf(
    DropDown(
        image = R.drawable.dropdownthree,
        title = "Communication",
        assessment = "communicating with others. He has capacity to make all decisions, and has clear",
        comment = "Unfortunately, theres no clean way of initializing an ArrayList in Java, so I wondered if Kotlin had improved on that issue. For reference,"
    ),
    DropDown(
        image = R.drawable.dropdowntwo,
        title = "Mobilization",
        assessment = "Peter likes to be able to make his own decisions and choices. Sometimes",
        comment = "There are two ways to define an array in Kotlin. Using the arrayOf () function - We can use the library function arrayOf () to create an array"
    ),
    DropDown(
        image = R.drawable.dropdownone,
        title = "Washing and dresssing",
        assessment = "Katherine has no issues with communication, or communicating with others. He has capacity to make all decisions, ",
        comment = "Katherine is able to communicate verbally and express his needs. Peter likes to be able to make his own decisions"
    ),

)