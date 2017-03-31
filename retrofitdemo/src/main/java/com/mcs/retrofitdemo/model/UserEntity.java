package com.mcs.retrofitdemo.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

/**
 * @author mochangsheng
 * @version 1.0
 * @title 类的名称
 * @description 该类的主要功能描述
 * @created 2017/3/19 0019
 * @changeRecord [修改记录] <br/>
 */
public class UserEntity {


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
     * name : null
     * company : null
     * blog : null
     * location : shenzhen
     * email : mocsheng@foxmail.com
     * hireable : null
     * bio : Do a good
     * public_repos : 8
     * public_gists : 0
     * followers : 2
     * following : 15
     * created_at : 2015-07-14T02:11:30Z
     * updated_at : 2017-03-29T02:24:30Z
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
    @SerializedName("name")
    private Object mName;
    @SerializedName("company")
    private Object mCompany;
    @SerializedName("blog")
    private Object mBlog;
    @SerializedName("location")
    private String mLocation;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("hireable")
    private Object mHireable;
    @SerializedName("bio")
    private String mBio;
    @SerializedName("public_repos")
    private int mPublicRepos;
    @SerializedName("public_gists")
    private int mPublicGists;
    @SerializedName("followers")
    private int mFollowers;
    @SerializedName("following")
    private int mFollowing;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("updated_at")
    private String mUpdatedAt;

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

    public Object getName() {
        return mName;
    }

    public void setName(Object name) {
        mName = name;
    }

    public Object getCompany() {
        return mCompany;
    }

    public void setCompany(Object company) {
        mCompany = company;
    }

    public Object getBlog() {
        return mBlog;
    }

    public void setBlog(Object blog) {
        mBlog = blog;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public Object getHireable() {
        return mHireable;
    }

    public void setHireable(Object hireable) {
        mHireable = hireable;
    }

    public String getBio() {
        return mBio;
    }

    public void setBio(String bio) {
        mBio = bio;
    }

    public int getPublicRepos() {
        return mPublicRepos;
    }

    public void setPublicRepos(int publicRepos) {
        mPublicRepos = publicRepos;
    }

    public int getPublicGists() {
        return mPublicGists;
    }

    public void setPublicGists(int publicGists) {
        mPublicGists = publicGists;
    }

    public int getFollowers() {
        return mFollowers;
    }

    public void setFollowers(int followers) {
        mFollowers = followers;
    }

    public int getFollowing() {
        return mFollowing;
    }

    public void setFollowing(int following) {
        mFollowing = following;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public String toString() {
        //输入格式化的json，而不是紧凑的
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

}
