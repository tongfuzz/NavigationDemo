package com.kk.tongfu.navigationdemo.beans

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep

/**
 * Created by tongfu
 * on 2019-09-11
 * Desc:
 */

@Keep
class UserInfo(var userName: String?, var userAge: Int) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(userName)
        parcel.writeInt(userAge)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserInfo> {
        override fun createFromParcel(parcel: Parcel): UserInfo {
            return UserInfo(parcel)
        }

        override fun newArray(size: Int): Array<UserInfo?> {
            return arrayOfNulls(size)
        }
    }

}