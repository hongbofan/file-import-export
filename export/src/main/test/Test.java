import java.util.regex.Pattern;


/**
 * Created by hongbofan on 2018/2/16.
 */
public class Test {
    public static void main(String[] args) {
        String filterHeader = "";

        String header = filterHeader.split("::")[0];
        Pattern pattern = Pattern.compile(filterHeader.split("::")[1]);
        String s = "1sss";
        System.out.println(s.replaceAll(pattern.pattern(),filterHeader.split("::")[2]));
    }
}
