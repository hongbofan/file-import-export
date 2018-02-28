package com.flyread.file.export.excel;

import com.flyread.file.export.base.ExportTranslate;
import org.apache.poi.hssf.usermodel.HSSFCell;

/**
 * @author by hongbf on 2018/2/26.
 */
public class ExcelExportTranslate implements ExportTranslate{
    private Object transformer;

    @Override
    public boolean translate(Object o) {
        if ("1".equals(o)) {
            return false;
        }
        return true;
    }

    public Object getTransformer() {
        return transformer;
    }

    public void setTransformer(Object transformer) {
        this.transformer = transformer;
    }
}
