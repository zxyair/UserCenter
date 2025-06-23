package org.example.usercenter.pojo;

import java.util.Date;

/**
 * 用户游戏记录实体类
 */
public class UserGameRecord {
    /**
     * 记录唯一ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 对局唯一ID
     */
    private Long gameId;

    /**
     * 对局成员（JSON字符串）
     */
    private String members;

    /**
     * 胜负（1=胜，0=负，2=平/其他）
     */
    private Integer result;

    /**
     * 本局积分变化
     */
    private Integer scoreChange;

    /**
     * 记录时间
     */
    private Date createTime;

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

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getScoreChange() {
        return scoreChange;
    }

    public void setScoreChange(Integer scoreChange) {
        this.scoreChange = scoreChange;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
