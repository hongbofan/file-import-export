import com.flyread.file.imp0rt.ImportBootstrap;

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
                .start()
                .getResult()
                .forEach(System.out::println);
    }
    public static void test2() {
        new ImportBootstrap()
                .initFile("C:\\Users\\DELL\\Desktop\\新建文件夹\\template.xls")
                .initConfig("")
                .start()
                .getResult()
                .forEach(System.out::println);
    }
}
