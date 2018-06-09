package com.yxl.football.api;

import com.yxl.football.entiy.ImmediateScoreModel;
import com.yxl.football.entiy.InstantScoreListModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServer {

    @GET("http://master.cp.lovedou.com/score/instant/")
    Call<ImmediateScoreModel> getImmediateScore(@Query("lotteryId") String lotteryId, @Query
            ("issue")
            String issue, @Query("league") String league, @Query("page") String page, @Query
                                                        ("pageSize") String pageSize);

    @POST("http://i.qqshidao.com/api/index" +
            ".php?c_id=41000&c_type=2&c_cpid=2&suid=1dbe8f7755bb40795db8111e2b88dab0" +
            "&imei=865720038533045&mac=02:00:00:00:00:00")
    @FormUrlEncoded
    Call<InstantScoreListModel> getInstantScoreList(@Field("cid") String cid, @Field("c_ck")
            String c_ck, @Field
                                                            ("mytime") String mytime, @Field("t")
                                                            String t, @Field("stid") String stid,
                                                    @Field
                                                            ("c_key") String c_key);

    @POST("http://i.qqshidao.com/api/index" +
            ".php?suid=1dbe8f7755bb40795db8111e2b88dab0&quid=&imei=865720038533045&mac=02:00:00" +
            ":00:00:00&c_type=2&c_cpid=2&c_id=41000")
    @FormUrlEncoded
    Call<InstantScoreListModel> getEndingScoreList(@Field("cid") String cid, @Field("c_ck")
            String c_ck, @Field("mytime") String mytime, @Field("t") String t, @Field("stid")
                                                           String stid, @Field
                                                           ("c_key") String c_key);

    @POST("http://i.qqshidao.com/api/index" +
            ".php?suid=1dbe8f7755bb40795db8111e2b88dab0&quid=&imei=865720038533045&mac=02:00:00" +
            ":00:00:00&c_type=2&c_cpid=2&c_id=41000")
    @FormUrlEncoded
    Call<InstantScoreListModel> getScheduleScoreList(@Field("cid") String cid, @Field("c_ck")
            String c_ck, @Field("mytime") String mytime, @Field("t") String t, @Field("stid")
            String stid, @Field
                                                             ("c_key") String c_key);
}
