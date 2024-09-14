package com.tawhid.txtfilecreator.texteditor.data.repository

import com.tawhid.txtfilecreator.texteditor.data.datasource.PinTextFileDao
import com.tawhid.txtfilecreator.texteditor.domain.model.PinTextFile
import com.tawhid.txtfilecreator.texteditor.domain.repository.PinTextFileRepository
import kotlinx.coroutines.flow.Flow

class PinTextFileRepositoryImpl (
    private val dao: PinTextFileDao
): PinTextFileRepository {
    override fun getPinTextFiles(): Flow<List<PinTextFile>> {
        return dao.getPinTextFiles()
    }

    override suspend fun getPinTextFileById(id: Int): PinTextFile? {
        return getPinTextFileById(id)
    }

    override suspend fun insertPinTextFile(pintextfile: PinTextFile) {
        dao.insertPinTextFile(pintextfile)
    }

    override suspend fun deleteNote(pintextfile: PinTextFile) {
        dao.deleteNote(pintextfile)
    }
}