package com.curm.sports.http;

import static com.curm.sports.http.Constans.TOKEN;

import android.text.TextUtils;

import com.curm.sports.app.MyApp;
import com.curm.sports.util.SPUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {

    private String TAG = "okhttp";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        String token = SPUtils.getStringData(MyApp.getAppContext(),TOKEN,"");
        if (!TextUtils.isEmpty(token)){
            Request.Builder builder = originalRequest.newBuilder()
                    .addHeader("Authorization","bearer " + token);
            return chain.proceed(builder.build());
        }

        Response response = chain.proceed(chain.request());
        int code = response.code();
        if (403 == code) {
            System.out.println("HttpManager" + "服务器拒绝访问" + 403);
            //此处进行相应的处理，如自动调用网络请求，或者跳转到登录页面等
        }
        return response;
    }
}
