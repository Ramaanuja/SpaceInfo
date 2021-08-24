package com.example.spaceinfo.datalayer.localdatasource

interface RoomDataSource {
    fun isPictureFavorite(date: String): Boolean
    fun isTodayPictureFavorite(): Boolean
}

class FakeRoomDataSource: RoomDataSource{
    override fun isPictureFavorite(date: String): Boolean {
        return false
    }

    override fun isTodayPictureFavorite(): Boolean {
        return false
    }

}