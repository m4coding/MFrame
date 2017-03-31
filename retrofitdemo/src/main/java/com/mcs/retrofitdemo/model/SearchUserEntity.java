package com.mcs.retrofitdemo.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/3/31
 * @changeRecord [修改记录] <br/>
 */

public class SearchUserEntity {

    /**
     * total_count : 1
     * incomplete_results : false
     * items : [{"login":"mcshengInworking","id":13324985,"avatar_url":"https://avatars0.githubusercontent.com/u/13324985?v=3","gravatar_id":"","url":"https://api.github.com/users/mcshengInworking","html_url":"https://github.com/mcshengInworking","followers_url":"https://api.github.com/users/mcshengInworking/followers","following_url":"https://api.github.com/users/mcshengInworking/following{/other_user}","gists_url":"https://api.github.com/users/mcshengInworking/gists{/gist_id}","starred_url":"https://api.github.com/users/mcshengInworking/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/mcshengInworking/subscriptions","organizations_url":"https://api.github.com/users/mcshengInworking/orgs","repos_url":"https://api.github.com/users/mcshengInworking/repos","events_url":"https://api.github.com/users/mcshengInworking/events{/privacy}","received_events_url":"https://api.github.com/users/mcshengInworking/received_events","type":"User","site_admin":false,"score":39.862103}]
     */

    @SerializedName("total_count")
    private int mTotalCount;
    @SerializedName("incomplete_results")
    private boolean mIncompleteResults;
    @SerializedName("items")
    private List<ItemsBean> mItems;

    public int getTotalCount() {
        return mTotalCount;
    }

    public void setTotalCount(int totalCount) {
        mTotalCount = totalCount;
    }

    public boolean isIncompleteResults() {
        return mIncompleteResults;
    }

    public void setIncompleteResults(boolean incompleteResults) {
        mIncompleteResults = incompleteResults;
    }

    public List<ItemsBean> getItems() {
        return mItems;
    }

    public void setItems(List<ItemsBean> items) {
        mItems = items;
    }

    public static class ItemsBean {
        /**
         * login : mcshengInworking
         * id : 13324985
         * avatar_url : https://avatars0.githubusercontent.com/u/13324985?v=3
         * gravatar_id :
         * url : https://api.github.com/users/mcshengInworking
         * html_url : https://github.com/mcshengInworking
         * followers_url : https://api.github.com/users/mcshengInworking/followers
         * following_url : https://api.github.com/users/mcshengInworking/following{/other_user}
         * gists_url : https://api.github.com/users/mcshengInworking/gists{/gist_id}
         * starred_url : https://api.github.com/users/mcshengInworking/starred{/owner}{/repo}
         * subscriptions_url : https://api.github.com/users/mcshengInworking/subscriptions
         * organizations_url : https://api.github.com/users/mcshengInworking/orgs
         * repos_url : https://api.github.com/users/mcshengInworking/repos
         * events_url : https://api.github.com/users/mcshengInworking/events{/privacy}
         * received_events_url : https://api.github.com/users/mcshengInworking/received_events
         * type : User
         * site_admin : false
         * score : 39.862103
         */

        @SerializedName("login")
        private String mLogin;
        @SerializedName("id")
        private int mId;
        @SerializedName("avatar_url")
        private String mAvatarUrl;
        @SerializedName("gravatar_id")
        private String mGravatarId;
        @SerializedName("url")
        private String mUrl;
        @SerializedName("html_url")
        private String mHtmlUrl;
        @SerializedName("followers_url")
        private String mFollowersUrl;
        @SerializedName("following_url")
        private String mFollowingUrl;
        @SerializedName("gists_url")
        private String mGistsUrl;
        @SerializedName("starred_url")
        private String mStarredUrl;
        @SerializedName("subscriptions_url")
        private String mSubscriptionsUrl;
        @SerializedName("organizations_url")
        private String mOrganizationsUrl;
        @SerializedName("repos_url")
        private String mReposUrl;
        @SerializedName("events_url")
        private String mEventsUrl;
        @SerializedName("received_events_url")
        private String mReceivedEventsUrl;
        @SerializedName("type")
        private String mType;
        @SerializedName("site_admin")
        private boolean mSiteAdmin;
        @SerializedName("score")
        private double mScore;

        public String getLogin() {
            return mLogin;
        }

        public void setLogin(String login) {
            mLogin = login;
        }

        public int getId() {
            return mId;
        }

        public void setId(int id) {
            mId = id;
        }

        public String getAvatarUrl() {
            return mAvatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            mAvatarUrl = avatarUrl;
        }

        public String getGravatarId() {
            return mGravatarId;
        }

        public void setGravatarId(String gravatarId) {
            mGravatarId = gravatarId;
        }

        public String getUrl() {
            return mUrl;
        }

        public void setUrl(String url) {
            mUrl = url;
        }

        public String getHtmlUrl() {
            return mHtmlUrl;
        }

        public void setHtmlUrl(String htmlUrl) {
            mHtmlUrl = htmlUrl;
        }

        public String getFollowersUrl() {
            return mFollowersUrl;
        }

        public void setFollowersUrl(String followersUrl) {
            mFollowersUrl = followersUrl;
        }

        public String getFollowingUrl() {
            return mFollowingUrl;
        }

        public void setFollowingUrl(String followingUrl) {
            mFollowingUrl = followingUrl;
        }

        public String getGistsUrl() {
            return mGistsUrl;
        }

        public void setGistsUrl(String gistsUrl) {
            mGistsUrl = gistsUrl;
        }

        public String getStarredUrl() {
            return mStarredUrl;
        }

        public void setStarredUrl(String starredUrl) {
            mStarredUrl = starredUrl;
        }

        public String getSubscriptionsUrl() {
            return mSubscriptionsUrl;
        }

        public void setSubscriptionsUrl(String subscriptionsUrl) {
            mSubscriptionsUrl = subscriptionsUrl;
        }

        public String getOrganizationsUrl() {
            return mOrganizationsUrl;
        }

        public void setOrganizationsUrl(String organizationsUrl) {
            mOrganizationsUrl = organizationsUrl;
        }

        public String getReposUrl() {
            return mReposUrl;
        }

        public void setReposUrl(String reposUrl) {
            mReposUrl = reposUrl;
        }

        public String getEventsUrl() {
            return mEventsUrl;
        }

        public void setEventsUrl(String eventsUrl) {
            mEventsUrl = eventsUrl;
        }

        public String getReceivedEventsUrl() {
            return mReceivedEventsUrl;
        }

        public void setReceivedEventsUrl(String receivedEventsUrl) {
            mReceivedEventsUrl = receivedEventsUrl;
        }

        public String getType() {
            return mType;
        }

        public void setType(String type) {
            mType = type;
        }

        public boolean isSiteAdmin() {
            return mSiteAdmin;
        }

        public void setSiteAdmin(boolean siteAdmin) {
            mSiteAdmin = siteAdmin;
        }

        public double getScore() {
            return mScore;
        }

        public void setScore(double score) {
            mScore = score;
        }
    }

    public String toString() {
        //输入格式化的json，而不是紧凑的
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
