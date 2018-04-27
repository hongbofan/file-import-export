import com.flyread.file.export.ExportBootstrap;
import com.flyread.file.export.base.ExportType;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by hongbofan on 2018/2/16.
 */
public class Test {
    public static void main(String[] args) {

        Map<String,Object> data = new HashMap<>();
        data.put("list",new ArrayList<Person>(){{add(new Person("1","1","1",new Date(),19));}});
        System.out.println(new ExportBootstrap()
                .initConfig("")
                .initData(data)
                .build()
                .start(ExportType.TXT)
                .getPath());
    }


}
