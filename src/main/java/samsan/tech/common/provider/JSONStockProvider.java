package samsan.tech.common.provider;

import samsan.tech.common.factory.stockProvider.StockProvider;
import samsan.tech.common.customType.JSONString;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class JSONStockProvider implements StockProvider {
    public JSONString getData() throws Exception{
        //String fileName = "database.properties";
        String fileName = "stock.json";
        File file = null;
        StringBuilder readFile = new StringBuilder();
        try {
            file = getFileFromResource(fileName);
            List<String> lines;
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            for(String line:lines){
                readFile.append(line);
            }
            return JSONString.fromString(readFile.toString());
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }

    }
}
