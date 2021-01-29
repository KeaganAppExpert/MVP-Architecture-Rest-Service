package com.example.mvparchitecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("artistName")
    @Expose
    private String mArtistName;
    @SerializedName("artworkUrl100")
    @Expose
    private String mArtworkUrl100;
    @SerializedName("artworkUrl30")
    @Expose
    private String mArtworkUrl30;
    @SerializedName("artworkUrl60")
    @Expose
    private String mArtworkUrl60;
    @SerializedName("collectionArtistId")
    @Expose
    private Long mCollectionArtistId;
    @SerializedName("collectionArtistViewUrl")
    @Expose
    private String mCollectionArtistViewUrl;
    @SerializedName("collectionCensoredName")
    @Expose
    private String mCollectionCensoredName;
    @SerializedName("collectionExplicitness")
    @Expose
    private String mCollectionExplicitness;
    @SerializedName("collectionHdPrice")
    @Expose
    private Double mCollectionHdPrice;
    @SerializedName("collectionId")
    @Expose
    private Long mCollectionId;
    @SerializedName("collectionName")
    @Expose
    private String mCollectionName;
    @SerializedName("collectionPrice")
    @Expose
    private Double mCollectionPrice;
    @SerializedName("collectionViewUrl")
    @Expose
    private String mCollectionViewUrl;
    @SerializedName("contentAdvisoryRating")
    @Expose
    private String mContentAdvisoryRating;
    @SerializedName("country")
    @Expose
    private String mCountry;
    @SerializedName("currency")
    @Expose
    private String mCurrency;
    @SerializedName("discCount")
    @Expose
    private Long mDiscCount;
    @SerializedName("discNumber")
    @Expose
    private Long mDiscNumber;
    @SerializedName("hasITunesExtras")
    @Expose
    private Boolean mHasITunesExtras;
    @SerializedName("kind")
    @Expose
    private String mKind;
    @SerializedName("longDescription")
    @Expose
    private String mLongDescription;
    @SerializedName("previewUrl")
    @Expose
    private String mPreviewUrl;
    @SerializedName("primaryGenreName")
    @Expose
    private String mPrimaryGenreName;
    @SerializedName("releaseDate")
    @Expose
    private String mReleaseDate;
    @SerializedName("trackCensoredName")
    @Expose
    private String mTrackCensoredName;
    @SerializedName("trackCount")
    @Expose
    private Long mTrackCount;
    @SerializedName("trackExplicitness")
    @Expose
    private String mTrackExplicitness;
    @SerializedName("trackHdPrice")
    @Expose
    private Double mTrackHdPrice;
    @SerializedName("trackId")
    @Expose
    private Long mTrackId;
    @SerializedName("trackName")
    @Expose
    private String mTrackName;
    @SerializedName("trackNumber")
    @Expose
    private Long mTrackNumber;
    @SerializedName("trackPrice")
    @Expose
    private Double mTrackPrice;
    @SerializedName("trackTimeMillis")
    @Expose
    private Long mTrackTimeMillis;
    @SerializedName("trackViewUrl")
    @Expose
    private String mTrackViewUrl;
    @SerializedName("wrapperType")
    @Expose
    private String mWrapperType;

    public String getArtistName() {
        return mArtistName;
    }

    public void setArtistName(String artistName) {
        mArtistName = artistName;
    }

    public String getArtworkUrl100() {
        return mArtworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        mArtworkUrl100 = artworkUrl100;
    }

    public String getArtworkUrl30() {
        return mArtworkUrl30;
    }

    public void setArtworkUrl30(String artworkUrl30) {
        mArtworkUrl30 = artworkUrl30;
    }

    public String getArtworkUrl60() {
        return mArtworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        mArtworkUrl60 = artworkUrl60;
    }

    public Long getCollectionArtistId() {
        return mCollectionArtistId;
    }

    public void setCollectionArtistId(Long collectionArtistId) {
        mCollectionArtistId = collectionArtistId;
    }

    public String getCollectionArtistViewUrl() {
        return mCollectionArtistViewUrl;
    }

    public void setCollectionArtistViewUrl(String collectionArtistViewUrl) {
        mCollectionArtistViewUrl = collectionArtistViewUrl;
    }

    public String getCollectionCensoredName() {
        return mCollectionCensoredName;
    }

    public void setCollectionCensoredName(String collectionCensoredName) {
        mCollectionCensoredName = collectionCensoredName;
    }

    public String getCollectionExplicitness() {
        return mCollectionExplicitness;
    }

    public void setCollectionExplicitness(String collectionExplicitness) {
        mCollectionExplicitness = collectionExplicitness;
    }

    public Double getCollectionHdPrice() {
        return mCollectionHdPrice;
    }

    public void setCollectionHdPrice(Double collectionHdPrice) {
        mCollectionHdPrice = collectionHdPrice;
    }

    public Long getCollectionId() {
        return mCollectionId;
    }

    public void setCollectionId(Long collectionId) {
        mCollectionId = collectionId;
    }

    public String getCollectionName() {
        return mCollectionName;
    }

    public void setCollectionName(String collectionName) {
        mCollectionName = collectionName;
    }

    public Double getCollectionPrice() {
        return mCollectionPrice;
    }

    public void setCollectionPrice(Double collectionPrice) {
        mCollectionPrice = collectionPrice;
    }

    public String getCollectionViewUrl() {
        return mCollectionViewUrl;
    }

    public void setCollectionViewUrl(String collectionViewUrl) {
        mCollectionViewUrl = collectionViewUrl;
    }

    public String getContentAdvisoryRating() {
        return mContentAdvisoryRating;
    }

    public void setContentAdvisoryRating(String contentAdvisoryRating) {
        mContentAdvisoryRating = contentAdvisoryRating;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String currency) {
        mCurrency = currency;
    }

    public Long getDiscCount() {
        return mDiscCount;
    }

    public void setDiscCount(Long discCount) {
        mDiscCount = discCount;
    }

    public Long getDiscNumber() {
        return mDiscNumber;
    }

    public void setDiscNumber(Long discNumber) {
        mDiscNumber = discNumber;
    }

    public Boolean getHasITunesExtras() {
        return mHasITunesExtras;
    }

    public void setHasITunesExtras(Boolean hasITunesExtras) {
        mHasITunesExtras = hasITunesExtras;
    }

    public String getKind() {
        return mKind;
    }

    public void setKind(String kind) {
        mKind = kind;
    }

    public String getLongDescription() {
        return mLongDescription;
    }

    public void setLongDescription(String longDescription) {
        mLongDescription = longDescription;
    }

    public String getPreviewUrl() {
        return mPreviewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        mPreviewUrl = previewUrl;
    }

    public String getPrimaryGenreName() {
        return mPrimaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        mPrimaryGenreName = primaryGenreName;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    public String getTrackCensoredName() {
        return mTrackCensoredName;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        mTrackCensoredName = trackCensoredName;
    }

    public Long getTrackCount() {
        return mTrackCount;
    }

    public void setTrackCount(Long trackCount) {
        mTrackCount = trackCount;
    }

    public String getTrackExplicitness() {
        return mTrackExplicitness;
    }

    public void setTrackExplicitness(String trackExplicitness) {
        mTrackExplicitness = trackExplicitness;
    }

    public Double getTrackHdPrice() {
        return mTrackHdPrice;
    }

    public void setTrackHdPrice(Double trackHdPrice) {
        mTrackHdPrice = trackHdPrice;
    }

    public Long getTrackId() {
        return mTrackId;
    }

    public void setTrackId(Long trackId) {
        mTrackId = trackId;
    }

    public String getTrackName() {
        return mTrackName;
    }

    public void setTrackName(String trackName) {
        mTrackName = trackName;
    }

    public Long getTrackNumber() {
        return mTrackNumber;
    }

    public void setTrackNumber(Long trackNumber) {
        mTrackNumber = trackNumber;
    }

    public Double getTrackPrice() {
        return mTrackPrice;
    }

    public void setTrackPrice(Double trackPrice) {
        mTrackPrice = trackPrice;
    }

    public Long getTrackTimeMillis() {
        return mTrackTimeMillis;
    }

    public void setTrackTimeMillis(Long trackTimeMillis) {
        mTrackTimeMillis = trackTimeMillis;
    }

    public String getTrackViewUrl() {
        return mTrackViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        mTrackViewUrl = trackViewUrl;
    }

    public String getWrapperType() {
        return mWrapperType;
    }

    public void setWrapperType(String wrapperType) {
        mWrapperType = wrapperType;
    }

}
