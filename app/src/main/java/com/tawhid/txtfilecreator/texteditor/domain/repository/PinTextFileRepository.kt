package com.tawhid.txtfilecreator.texteditor.domain.repository

import com.tawhid.txtfilecreator.texteditor.domain.model.PinTextFile
import kotlinx.coroutines.flow.Flow

interface PinTextFileRepository {
    fun getPinTextFiles(): Flow<List<PinTextFile>>
    suspend fun getPinTextFileById(id:Int): PinTextFile?
    suspend fun insertPinTextFile(pintextfile: PinTextFile)
    suspend fun deleteNote(pintextfile: PinTextFile)
}