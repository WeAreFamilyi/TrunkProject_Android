package com.curm.sports.http;

import com.curm.sports.entity.BaseResponse;
import com.curm.sports.entity.Upload;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class HttpRequestUtils {

    /***
     * 上传图片
     * @param context
     * @param filePath
     * @param consumer
     */
    public static void postUpload(RxAppCompatActivity context,String filePath, Observer<BaseResponse<Upload>> consumer){
        File file = new File(filePath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("file", filePath, requestBody);

        RetrofitUtils.getApiUrl(context)
                .upload(part).compose(RxHelper.observableIO2Main(context))
                .subscribe(consumer);
    }

    /***
     * 上传多张图片
     * @param context
     * @param filePath
     * @param consumer
     */
    public static void postUploadList(RxAppCompatActivity context,List<String> filePath, Observer<BaseResponse<Upload>> consumer){

        List<MultipartBody.Part> parts = new ArrayList<>();
        for (int i = 0; i < filePath.size(); i++) {
            File file = new File(filePath.get(i));
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
            MultipartBody.Part part = MultipartBody.Part.createFormData("file", filePath.get(i), requestBody);
            parts.add(part);
        }
        RetrofitUtils.getApiUrl(context)
                .uploadList(parts).compose(RxHelper.observableIO2Main(context))
                .subscribe(consumer);
    }

}
