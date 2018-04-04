import com.flyread.file.imp0rt.ImportBootstrap;
import com.flyread.file.imp0rt.base.ImportType;
import com.flyread.file.imp0rt.base.impl.DefaultImportPipeline;
import com.flyread.file.imp0rt.excel.*;
import com.flyread.file.imp0rt.model.ImportConfig;
import com.flyread.file.imp0rt.model.ImportRequest;
import com.flyread.file.imp0rt.model.ImportResponse;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by hongbf on 2018/3/14.
 */
public class Test {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        new ImportBootstrap()
                .initFile("C:\\Users\\DELL\\Desktop\\新建文件夹\\template.txt")
                .initConfig("")
                .start(ImportType.TXT)
                .getResult()
                .forEach(System.out::println);
    }
    public static void test2() {
        new ImportBootstrap()
                .initFile("C:\\Users\\DELL\\Desktop\\新建文件夹\\template.xls")
                .initConfig("")
                .start(ImportType.EXCEL)
                .getResult()
                .forEach(System.out::println);
    }
}
