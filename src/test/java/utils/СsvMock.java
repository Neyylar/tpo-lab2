package utils;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class СsvMock {
    private final String filesource;
    private List<List<String>> values;
    public СsvMock(String filesource) {
        this.filesource = filesource;
    }

    private void readCsv(){
        List<List<String>> records = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(this.filesource));) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
            this.values = records;
        } catch (IOException e) {
            throw new RuntimeException("File not found");
        }
    }
    public double getFuncMock(double x, double accuracy){
        readCsv();
        for (List<String> line : values){
            if (line.size() < 2) throw new IllegalArgumentException("File contains wrong line " + line);
            if (Math.abs(Double.parseDouble(line.get(0)) - x) <= accuracy) {
                return (Double.parseDouble(line.get(1)));
            }
        }
        throw new IllegalArgumentException("File doesnt have that test argument: " + x);
    }
}
