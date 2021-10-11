package org.techtown.aop_part4_chapter06.data.services

import org.techtown.aop_part4_chapter06.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface KaKaoLocalApiService {
    //인증정보
    @Headers("Authorization:KaKaoAK ${BuildConfig.KAKAO_API_KEY}")
    @GET("/v2/local/geo/transcoord.json?output_coord=TM")
    suspend fun getTmCoordinates(
        //경도
        @Query("x")longitude:Double,
        //위도
        @Query("y")latitude:Double
    )
}