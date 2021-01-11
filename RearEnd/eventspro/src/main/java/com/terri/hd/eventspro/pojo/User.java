package com.terri.hd.eventspro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
* @Author: Gaoquan Li
* @Date: 2021/1/11 下午4:04
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer id;

    private String openid;

    private String nickname;

    private Integer gender;

    private String country;

    private String province;

    private String city;

    private String language;

    private String avatarUrl;
}