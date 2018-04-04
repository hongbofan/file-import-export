import com.flyread.file.imp0rt.model.ImportConfig;

/**
 * @author by hongbf on 2018/4/4.
 */
public class Test1 {
    public static void main(String[] args) {
        String s = "ISBN|题名";
        String ss = "\\|";
        ImportConfig config = new ImportConfig();
        config.setSeparator(ss);
        System.out.println(s.split(config.getSeparator())[0]);
    }
}
