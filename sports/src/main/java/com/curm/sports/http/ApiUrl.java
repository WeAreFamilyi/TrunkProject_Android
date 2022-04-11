package com.curm.sports.http;

import com.curm.sports.entity.BaseResponse;
import com.curm.sports.entity.Upload;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiUrl {


    /****
     * 上传图片
     * @param parts
     * @return
     */
    @Headers("Accept:application/json")
    @POST("Constans.UPLOAD")
    @Multipart
    Observable<BaseResponse<Upload>> upload(@Part MultipartBody.Part parts);

    /****
     * 上传多张图片
     * @param parts
     * @return
     */
    @Headers("Accept:application/json")
    @POST("Constans.UPLOADS")
    @Multipart
    Observable<BaseResponse<Upload>> uploadList(@Part List<MultipartBody.Part> parts);

}

