package com.sample.gadleaderboard.model

import com.sample.gadleaderboard.model.learningLeaders.LearningLeader
import com.sample.gadleaderboard.model.skillIq.SkillLeader
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/api/hours")
    fun getLearningLeaders(): Call<List<LearningLeader>>

    @GET("/api/skilliq")
    fun getSkillLeaders(): Call<List<SkillLeader>>

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun submitFormRequest(
        @Field("entry.1877115667") firstName: String,
        @Field("entry.1824927963") emailAddress: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.284483984") projectLink: String
    ): Call<Void>

    companion object {
        const val BASE_URL: String = " https://gadsapi.herokuapp.com"
        const val FORM_BASE_URL: String = "https://docs.google.com/forms/d/e/"
    }
}