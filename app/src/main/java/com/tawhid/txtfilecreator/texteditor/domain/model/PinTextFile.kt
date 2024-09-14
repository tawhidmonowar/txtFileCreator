package com.tawhid.txtfilecreator.texteditor.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PinTextFile(
    val filePath: String,
    @PrimaryKey val id: Int? = null
) {

}
