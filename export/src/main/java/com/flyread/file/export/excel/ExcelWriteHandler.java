package com.flyread.file.export.excel;

import com.flyread.file.export.base.impl.BaseExportHandlerContext;
import com.flyread.file.export.base.impl.BaseWriteHandler;
import com.flyread.file.export.excel.command.EachCommandExtend;
import com.flyread.file.export.model.ExportRequest;
import org.jxls.builder.xls.XlsCommentAreaBuilder;
import org.jxls.common.Context;
import org.jxls.transform.Transformer;
import org.jxls.util.JxlsHelper;

import java.io.*;
import java.util.Map;


/**
 * @author by hongbf on 2018/4/19.
 */
public class ExcelWriteHandler extends BaseWriteHandler {
    private final JxlsHelper helper;

    public ExcelWriteHandler() {
        this.helper = JxlsHelper.getInstance();
    }

    @Override
    public void handleRequest(BaseExportHandlerContext context, Object msg) throws Exception {

        ExportRequest request = context.pipeline().getRequest();
        write(request.getOutputStream(), msg, request.getTemplateInputStream());
    }

    @Override
    protected void write(OutputStream out, Object data, InputStream template) throws Exception {

        Context context = new Context();
        Map<String, Object> model = (Map<String, Object>) data;
        for (String key : model.keySet()) {
            context.putVar(key, model.get(key));
        }

        Transformer transformer = helper.createTransformer(template, out);
        XlsCommentAreaBuilder.addCommandMapping("each", EachCommandExtend.class);
        helper.processTemplate(context, transformer);
    }
}
