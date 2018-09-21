package com.dxy.library.network.http.builder;


import com.dxy.library.network.http.header.Headers;
import com.dxy.library.network.http.param.Params;
import okhttp3.HttpUrl;

/**
 * Get请求构建者
 * @author duanxinyuan
 * 2016/9/28 13:15
 */
public class GetBuilder extends OkBuilder {

    public static GetBuilder getBuilder() {
        return new GetBuilder();
    }

    public GetBuilder buildGet(String url) {
        url(url).get();
        return this;
    }

    public GetBuilder buildGet(String url, Headers headers) {
        if (null != headers) {
            addHeader(headers);
        }
        url(url).get();
        return this;
    }

    public GetBuilder buildGet(String url, Params params) {
        HttpUrl httpUrl = HttpUrl.parse(url);
        if (null != httpUrl) {
            HttpUrl.Builder builder = httpUrl.newBuilder();
            addQueryParameter(builder, params);
            httpUrl = builder.build();
            url(httpUrl).get();
        }
        return this;
    }

    public GetBuilder buildGet(String url, Headers headers, Params params) {
        addHeader(headers);
        return buildGet(url, params);
    }

}
