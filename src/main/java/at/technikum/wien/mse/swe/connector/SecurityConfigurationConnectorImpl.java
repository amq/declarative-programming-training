package at.technikum.wien.mse.swe.connector;

import java.nio.file.Path;

import at.technikum.wien.mse.swe.MyParser;
import at.technikum.wien.mse.swe.SecurityConfigurationConnector;
import at.technikum.wien.mse.swe.model.SecurityConfiguration;

/**
 * @author MatthiasKreuzriegler
 */
public class SecurityConfigurationConnectorImpl implements SecurityConfigurationConnector {

    @Override
    public SecurityConfiguration read(Path file) {
        String content = MyParser.readFileContent(file);
        return mapConficuration(content);
    }

    private SecurityConfiguration mapConficuration(String content) {
        SecurityConfiguration configuration = new SecurityConfiguration();
        MyParser.myParser(configuration, content);

        return configuration;
    }
}
