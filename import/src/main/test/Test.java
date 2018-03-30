import com.flyread.file.imp0rt.ImportBootstrap;
import com.flyread.file.imp0rt.base.*;
import com.flyread.file.imp0rt.excel.*;
import com.flyread.file.imp0rt.model.ImportRequest;
import com.flyread.file.imp0rt.model.ImportResponse;
import com.flyread.file.imp0rt.txt.TxtDecoderHandler;
import com.flyread.file.imp0rt.txt.TxtReadLineHandler;
import com.flyread.file.imp0rt.txt.TxtToJavaBeanHandler;

import java.io.File;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by hongbf on 2018/3/14.
 */
public class Test {
    public static void main(String[] args) {
        test2();
    }

/*    public static void test1() {
        File file = new File("C:\\Users\\DELL\\Desktop\\新建文件夹\\template.xls");
        Map<ExcelCellType, Format> map = new HashMap<>();
        map.put(ExcelCellType.CELL_TYPE_NUMERIC, DecimalFormat.getPercentInstance());
        System.out.println(new ImportBootstrap().initRequest(file, -1, 0, new ExcelImportTranslate(map))
                .initPipeline(Arrays.asList(new ExcelImportListHandler()),false).build(ImportType.EXCEL).importFile().getData());
    }*/
    public static void test2() {
        DefaultImportPipeline pipeline = new DefaultImportPipeline();
        pipeline.addFirst(new TxtToJavaBeanHandler());
        //pipeline.addFirst(new ExcelReadLineHandler());
        pipeline.addFirst(new TxtReadLineHandler());
        pipeline.addFirst(new TxtDecoderHandler());

        ImportRequest request = new ImportRequest(new File("C:\\Users\\DELL\\Desktop\\新建文件夹\\template.txt"));
        request.setSelectSheet(0);
        request.setStartRowNum(0);
        request.setTranslate(new ExcelImportTranslate(new HashMap<>()));
        ExcelImportContext context = new ExcelImportContext();
        context.setRequest(request);
        context.setImportPipeline(pipeline);
        context.setResponse(new ImportResponse());
        System.out.println(new ExcelImportServiceImpl(context).importFile().getData());
    }
}
