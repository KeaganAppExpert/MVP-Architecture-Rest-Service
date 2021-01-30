package com.example.mvparchitecture.data.utils;

import com.example.mvparchitecture.data.remote.APIService;
import com.example.mvparchitecture.data.remote.RetrofitClient;

public class ApiUtils {
    public static final String BASE_URL = "https://itunes.apple.com";

    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
