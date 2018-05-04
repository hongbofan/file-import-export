import com.flyread.file.config.model.xml.Configuration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * @author by hongbf on 2018/5/3.
 */
public class Test {
    public static void main(String[] args) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Configuration.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Configuration config = (Configuration) unmarshaller.unmarshal(Test.class.getResourceAsStream("xxxx-config.xml"));
            System.out.println(config);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
