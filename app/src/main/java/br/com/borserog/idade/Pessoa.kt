package br.com.borserog.idade

import android.os.Parcel
import android.os.Parcelable

class Pessoa(val nome: String?, private val ano: Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    fun idade(): Int {
        return 2021 - this.ano
    }

    override fun toString(): String {
        return "Pessoa(nome='$nome', ano=$ano)"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeInt(ano)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pessoa> {
        override fun createFromParcel(parcel: Parcel): Pessoa {
            return Pessoa(parcel)
        }

        override fun newArray(size: Int): Array<Pessoa?> {
            return arrayOfNulls(size)
        }
    }
}