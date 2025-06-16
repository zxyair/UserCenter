package org.example.usercenter.pojo;

import java.util.Date;

/**
 * 用户积分实体类
 */
public class UserScore {
    /**
     * 唯一ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 当前积分
     */
    private Integer score;

    /**
     * 更新时间
     */
    private Date updateTime;

    // Getter和Setter方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
