package at.technikum.wien.mse.swe.connector;

import java.nio.file.Path;

import at.technikum.wien.mse.swe.MyParser;
import at.technikum.wien.mse.swe.SecurityAccountOverviewConnector;
import at.technikum.wien.mse.swe.model.SecurityAccountOverview;

/**
 * @author MatthiasKreuzriegler
 */
public class SecurityAccountOverviewConnectorImpl implements SecurityAccountOverviewConnector {

    @Override
    public SecurityAccountOverview read(Path file) {
        String content = MyParser.readFileContent(file);
        return mapOverview(content);
    }

    private SecurityAccountOverview mapOverview(String content) {
        SecurityAccountOverview overview = new SecurityAccountOverview();
        MyParser.myParser(overview, content);

        return overview;
    }
}
