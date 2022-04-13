package com.example.core.data.source.local.room

import androidx.room.*
import com.example.core.data.source.local.entity.MovieEntity
import com.example.core.data.source.local.entity.TvShowEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getAllMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie WHERE title LIKE '%' || :query || '%'")
    fun findDataMovie(query: String): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie WHERE favorite = 1")
    fun getFavMovies(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(favorite: List<MovieEntity>)

    @Update
    fun updateMovie(favorite: MovieEntity)

    @Query("SELECT * FROM tvshow")
    fun getAllTvShow(): Flow<List<TvShowEntity>>

    @Query("SELECT * FROM tvshow WHERE original_name LIKE '%' || :query || '%'")
    fun findDataTv(query: String): Flow<List<TvShowEntity>>

    @Query("SELECT * FROM tvshow WHERE favorite = 1")
    fun getFavTvShow(): Flow<List<TvShowEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShow(favorite: List<TvShowEntity>)

    @Update
    fun updateTvShow(favorite: TvShowEntity)

}