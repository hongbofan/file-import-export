package com.flyread.file.imp0rt.excel;

import com.flyread.file.imp0rt.base.BaseImportContext;
import com.flyread.file.imp0rt.base.BaseImportHandlerContext;
import com.flyread.file.imp0rt.base.DefaultImportPipeline;
import com.flyread.file.imp0rt.base.ImportService;
import com.flyread.file.imp0rt.model.ImportRequest;
import com.flyread.file.imp0rt.model.ImportResponse;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author by hongbf on 2018/2/28.
 */
public class ExcelImportServiceImpl implements ImportService {
    private final ExcelImportContext context;

    public ExcelImportServiceImpl(BaseImportContext context) {
        this.context = (ExcelImportContext) context;
    }

    @Override
    public ImportResponse importFile() {
        try {
            DefaultImportPipeline pipeline = (DefaultImportPipeline) context.getImportPipeline();
            BaseImportHandlerContext head = pipeline.getHead();


            File file = context.getRequest().getImportFile();
            Files.lines(Paths.get(file.getAbsolutePath()), Charset.forName("GBK")).forEach((line)-> {
                head.fireChannelRead(line);
            });
/*            FileInputStream fileInputStream = new FileInputStream(file);
            FileChannel channel = fileInputStream.getChannel();
            ByteBuffer bf = ByteBuffer.allocate(1024);
            bf.clear();
            while (channel.read(bf) != -1) {

                byte[] bytes = bf.array();
                System.out.println(Charset.forName("utf8").decode(bf));
                head.fireChannelRead(bytes);
            }
            channel.close();*/

/*            Workbook workbook = null;
            try{
                workbook = WorkbookFactory.create(file);
            }catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                IOUtils.closeQuietly(workbook);
            }
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 0;i<sheet.getLastRowNum();i++) {
                head.fireChannelRead(sheet.getRow(i));
            }*/

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return context.getResponse();
    }
}
