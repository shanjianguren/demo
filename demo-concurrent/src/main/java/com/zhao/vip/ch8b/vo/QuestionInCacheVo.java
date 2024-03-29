package com.zhao.vip.ch8b.vo;

/**
 * 类说明：题目保存在缓存中的实体
 */
public class QuestionInCacheVo {
    private final String questionDetail;
    private final String questionSha;

    public QuestionInCacheVo(String questionDetail, String questionSha) {
        this.questionDetail = questionDetail;
        this.questionSha = questionSha;
    }

    public String getQuestionDetail() {
        return questionDetail;
    }

    public String getQuestionSha() {
        return questionSha;
    }
}
