package Data;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {

    //Read json file
    public void   getJsonDataToMap() throws IOException {
//     String jsonContent=  FileUtils.readFileToString(new File(System.getProperty("user.dir")+"src\\test\\java\\Data\\PerchaseOrder.json", StandardCharsets.UTF_8));

     //String to hashmap --> Jackson DataBind
        ObjectMapper mapper = new ObjectMapper();
//        List<HashMap<String,String>> data  = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});

    }
}
