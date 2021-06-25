package com.boraydata.hygiene.sal.entity;

import lombok.Data;

import java.util.List;

@Data
public class OverallEntity {

    private List<OverallList> results;

    @Data
    static class OverallList {
        /**
         * 现存确诊人数（较昨日增加数量）
         * 值为confirmedCount(Incr) - curedCount(Incr) - deadCount(Incr)
         */
        private Integer currentConfirmedCount;

        private Integer currentConfirmedIncr;

        private Integer confirmedIncr;

        private Integer suspectedIncr;

        private Integer curedIncr;

        private Integer deadIncr;

        private Integer seriousIncr;

        /**
         * 累计确诊人数（较昨日增加数量）
         */
        private Integer confirmedCount;

        /**
         * 疑似感染人数（较昨日增加数量）
         */
        private Integer suspectedCount;

        /**
         * 治愈人数（较昨日增加数量）
         */
        private Integer curedCount;

        /**
         * 死亡人数（较昨日增加数量）
         */
        private Integer deadCount;

        /**
         * 重症病例人数（较昨日增加数量）
         */
        private Integer seriousCount;

        /**
         * 数据最后变动时间
         */
        private Long updateTime;

        /**
         * 全国疫情信息概览
         */
        private GlobalStatistics globalStatistics;

        @Data
        static class GlobalStatistics {

            private Integer currentConfirmedCount;

            private Integer confirmedCount;

            private Integer curedCount;

            private Integer deadCount;

            private Integer confirmedIncr;

            private Integer curedIncr;

            private Integer deadIncr;

            private Integer currentConfirmedIncr;

            private Integer yesterdayConfirmedCountIncr;

        }

        private String generalRemark;

        private String remark1;

        private String remark2;

        private String remark3;

        private String remark4;

        private String remark5;

        /**
         * 病毒名称
         */
        private String note1;

        /**
         * 传染源
         */
        private String note2;

        /**
         * 传播途径
         */
        private String note3;

        private Boolean success;
    }
}
