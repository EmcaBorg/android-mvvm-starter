package android.mvvm.starter.domain.user.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
public class LoginRequest {


    @SerializedName("domainName")
    @Expose
    private String domainName;

    @SerializedName("username")

    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private String password;

}