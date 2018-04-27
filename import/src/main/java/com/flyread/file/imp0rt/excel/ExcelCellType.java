package com.flyread.file.imp0rt.excel;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

/**
 * @author by hongbf on 2018/2/28.
 */
public enum  ExcelCellType {

    CELL_TYPE_NUMERIC(0, "numeric","numeric"),
    CELL_TYPE_STRING(1, "string","string"),
    CELL_TYPE_FORMULA(2, "formula","formula"),
    CELL_TYPE_BLANK(3, "blank","blank"),
    CELL_TYPE_BOOLEAN(4, "boolean","boolean"),
    CELL_TYPE_ERROR(5, "error","error");

    /**
     * 编码
     */
    private int code;
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
    ExcelCellType(int code, String desc, String chineseName) {
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
    public static ExcelCellType getStatusByCode(int code) {
        for (ExcelCellType val : values()) {
            if (val.code == code) {
                return val;
            }
        }
        return null;
    }


    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getChineseName() {
        return chineseName;
    }
}
