package com.flyread.file.export.base.impl;

import com.flyread.file.export.base.ExportHandler;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * @author by hongbf on 2018/4/18.
 */
public abstract class BaseWriteHandler implements ExportHandler {
    protected Writer writer;
    @Override
    public void handleRequest(BaseExportHandlerContext context, Object msg) throws Exception {
        write(context.pipeline().getRequest().getOutputStream(),msg);
        writer.flush();
    }

    protected void write(OutputStream out ,Object data) throws Exception {
        write(out,data,null);
    }
    protected void write(OutputStream out , Object data, InputStream template) throws Exception {
        if (writer == null) {
            writer = new PrintWriter(out);
        }
        writer.write(data.toString());
    }
}
