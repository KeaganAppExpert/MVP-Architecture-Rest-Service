package com.example.mvparchitecture.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MusicModel {

    @SerializedName("resultCount")
    @Expose
    private Long mResultCount;
    @SerializedName("results")
    @Expose
    private List<Result> mResults;

    public Long getResultCount() {
        return mResultCount;
    }

    public void setResultCount(Long resultCount) {
        mResultCount = resultCount;
    }

    public List<Result> getResults() {
        return mResults;
    }

    public void setResults(List<Result> results) {
        mResults = results;
    }

}
