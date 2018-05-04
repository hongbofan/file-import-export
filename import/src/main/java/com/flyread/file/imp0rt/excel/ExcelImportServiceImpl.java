package com.flyread.file.imp0rt.excel;

import com.flyread.file.imp0rt.base.ImportPipeline;
import com.flyread.file.imp0rt.base.impl.BaseImportHandlerContext;
import com.flyread.file.imp0rt.base.ImportService;
import com.flyread.file.imp0rt.model.BaseImportRow;
import com.flyread.file.imp0rt.model.ExcelRow;
import com.flyread.file.imp0rt.model.ImportResponse;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;

import java.io.File;

/**
 * @author by hongbf on 2018/2/28.
 */
public class ExcelImportServiceImpl implements ImportService {
    private final ImportPipeline pipeline;

    public ExcelImportServiceImpl(ImportPipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Override
    public ImportResponse importFile() {
        try {
            BaseImportHandlerContext head = pipeline.getHead();
            File file = pipeline.getRequest().getImportFile();
            Workbook workbook = null;
            try {
                workbook = WorkbookFactory.create(file);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                IOUtils.closeQuietly(workbook);
            }
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = sheet.getFirstRowNum(); i < sheet.getLastRowNum(); i++) {
                head.fireChannelRead(new ExcelRow(sheet.getRow(i)));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pipeline.getResponse();
    }
}
