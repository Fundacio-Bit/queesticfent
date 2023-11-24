package org.fundaciobit.basecamp.api3.utils;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author anadal
 *
 */
public class TokenResponse {

    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("expires_in")
    private Integer expiresIn;
    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    @SerializedName("access_token")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @SerializedName("expires_in")
    public Integer getExpiresIn() {
        return expiresIn;
    }

    @SerializedName("expires_in")
    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    @SerializedName("refresh_token")
    public String getRefreshToken() {
        return refreshToken;
    }

    @SerializedName("refresh_token")
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class " + this.getClass().getSimpleName()).append("\n\t");
        sb.append("accessToken");
        sb.append('=');
        sb.append(((this.accessToken == null) ? "<null>" : this.accessToken));
        sb.append("\n\t");
        sb.append("expiresIn");
        sb.append('=');
        sb.append(((this.expiresIn == null) ? "<null>" : this.expiresIn));
        sb.append("\n\t");
        sb.append("refreshToken");
        sb.append('=');
        sb.append(((this.refreshToken == null) ? "<null>" : this.refreshToken));
        sb.append("\n\t");
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), '}');
        } else {
            sb.append('}');
        }
        return sb.toString();
    }

}
