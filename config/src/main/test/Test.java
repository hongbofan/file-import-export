import com.flyread.file.config.builder.Builder;
import com.flyread.file.config.builder.ImportConfigBuilder;
import com.flyread.file.config.builder.XmlConfigBuilder;
import com.flyread.file.config.model.Configuration;
import com.flyread.file.config.model.CsvType;
import com.flyread.file.config.model.MapperType;
import com.flyread.file.imp0rt.ImportBootstrap;
import com.flyread.file.imp0rt.base.ImportHandler;
import com.flyread.file.imp0rt.base.impl.*;
import com.flyread.file.imp0rt.model.ImportConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by hongbf on 2018/5/3.
 */
public class Test {
    public static void main(String[] args) {

        try {

            ImportBootstrap bootstraps = new ImportConfigBuilder(new XmlConfigBuilder()).build(Test.class.getResourceAsStream("xxxx-config.xml"),"C:\\Users\\DELL\\Desktop\\新建文件夹\\template.xls");
            bootstraps.start().getResult().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
