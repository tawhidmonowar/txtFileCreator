package com.tawhid.txtfilecreator.texteditor.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tawhid.txtfilecreator.texteditor.domain.model.PinTextFile

@Database (
    entities = [PinTextFile::class],
    version = 1
)
abstract class PinTextFileDatabase: RoomDatabase() {
    abstract val pinTextFileDao: PinTextFileDao
}