import com.flyread.file.export.ExportBootstrap;
import com.flyread.file.export.base.ExportType;
import com.flyread.file.export.excel.ExcelExportData;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by hongbofan on 2018/2/16.
 */
public class Test {
    public static void main(String[] args) {
        ExcelExportData meta = new ExcelExportData();
        meta.getMap().put("list",new ArrayList<Person>(){{add(new Person("1","1","1",new Date(),19));}});
        System.out.println(new ExportBootstrap()
                .initRequest("1234",".xls","C:\\Users\\DELL\\Desktop\\新建文件夹","/download/",new File("C:\\Users\\DELL\\Desktop\\新建文件夹\\template.xls"),meta)
                .initPipeline()
                .build(ExportType.EXCEL)
                .exportFile()
                .getPath());
    }
}
