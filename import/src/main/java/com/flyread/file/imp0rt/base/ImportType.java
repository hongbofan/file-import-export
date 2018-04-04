package com.flyread.file.imp0rt.base;

/**
 * @author by hongbf on 2018/2/26.
 */
public enum ImportType {
    EXCEL("excel", "excel","excel"),
    TXT("txt","txt","txt");

    /**
     * 编码
     */
    private String code;
    /**
     * 描述
     */
    private String desc;
    /**
     * 中文名称
     */
    private String chineseName;

    /**
     * 构造函数
     *
     * @param code
     * @param desc
     * @param chineseName
     */
    ImportType(String code, String desc, String chineseName) {
        this.code = code;
        this.desc = desc;
        this.chineseName = chineseName;
    }

    /**
     * 根据code获取枚举
     *
     * @param code 编码
     * @return 状态
     */
    public static ImportType getStatusByCode(String code) {
        for (ImportType val : values()) {
            if (val.code.equals(code)) {
                return val;
            }
        }
        return null;
    }


    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getChineseName() {
        return chineseName;
    }
}
