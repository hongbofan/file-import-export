package com.flyread.file.export.excel;

import com.flyread.file.export.base.BaseExportContext;
import com.flyread.file.export.base.ExportHandler;
import com.flyread.file.export.excel.util.EachCommandExtend;
import com.flyread.file.export.model.ExportRequest;
import org.jxls.builder.xls.XlsCommentAreaBuilder;
import org.jxls.common.Context;
import org.jxls.transform.Transformer;
import org.jxls.util.JxlsHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * @author by hongbf on 2018/2/26.
 */
public class DefaultExcelExportHandler implements ExportHandler {

    @Override
    public void handleRequest(BaseExportContext context) throws Exception {
        ExcelExportContext c = (ExcelExportContext) context;
        ExportRequest request = c.getRequest();

        File template = c.getConfig(request.getTemplateFile().getName());
        this.exportByJxls(request, c.getOutputStream(),template,c.getJxlsHelper());
    }
    private void exportByJxls(ExportRequest request,OutputStream out,File input,JxlsHelper helper) throws Exception{
        if (input == null) {
            throw new NullPointerException("错误的配置类型:" + request.getOutputFileName());
        }

        InputStream fis = new FileInputStream(input);

        Context context = new Context();
        ExcelExportData data = (ExcelExportData) request.getExportData();
        Map<String,Object> model = data.getMap();
        if (model != null) {
            for (String key : model.keySet()) {
                context.putVar(key, model.get(key));
            }
        }
        Transformer transformer  = helper.createTransformer(fis,out);
        XlsCommentAreaBuilder.addCommandMapping("each",EachCommandExtend.class);
        helper.processTemplate(context,transformer);
    }
}
