package com.example.demo.test2.ali;

/**
 * @ClassName CourseTypeEnum
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/11  9:22 下午
 * @Version 1.0
 */
public enum CourseTypeEnum {

    VIDEO_COURSE(1, "录播课程"),
    LIVE_COURSE(2, "直播课程"),
    OFFINE_COURSE(3, "线下课程");


    private int seq;
    private String desc;

    public int getSeq() {
        return seq;
    }

    public String getDesc() {
        return desc;
    }

    CourseTypeEnum(int seq, String desc) {
        this.seq = seq;
        this.desc = desc;
    }


}
