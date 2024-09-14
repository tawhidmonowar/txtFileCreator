package com.tawhid.txtfilecreator.texteditor.data.datasource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tawhid.txtfilecreator.texteditor.domain.model.PinTextFile
import kotlinx.coroutines.flow.Flow

@Dao
interface PinTextFileDao {
    @Query("SELECT * FROM pintextfile")
    fun getPinTextFiles(): Flow<List<PinTextFile>>
    @Query("SELECT * FROM pintextfile WHERE id = :id")
    suspend fun getPinTextFileById(id:Int): PinTextFile?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPinTextFile(pintextfile: PinTextFile)
    @Delete
    suspend fun deleteNote(pintextfile: PinTextFile)
}