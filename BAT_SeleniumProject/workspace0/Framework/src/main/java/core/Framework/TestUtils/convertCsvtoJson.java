package core.Framework.TestUtils;
 
import java.io.File;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
 
public class convertCsvtoJson {
 
    public static void main(String[] args) throws Exception {
    	
        File input = new File(System.getProperty("user.dir")+"\\src\\main\\java\\core\\Framework\\TestData\\TestDataCSV.csv");
        File output = new File(System.getProperty("user.dir")+"\\src\\main\\java\\core\\Framework\\TestData\\Testoutput.json");
 
        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        CsvMapper csvMapper = new CsvMapper();
 
        // Read data from CSV file
        List<Object> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(input).readAll();
 
        ObjectMapper mapper = new ObjectMapper();
 
        // Write JSON formated data to output.json file
       // mapper.writerWithDefaultPrettyPrinter().writeValue(output, readAll);
        mapper.writeValue(output, readAll);
 
        // Write JSON formated data to stdout
        //System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(readAll));
        System.out.println(mapper.writeValueAsString(readAll));
        
        
        //If you want to print JSON data in one line use
       // mapper.writexxxx(..) method instead of mapper.writerWithDefaultPrettyPrinter().writexxxx(..)
    }
}