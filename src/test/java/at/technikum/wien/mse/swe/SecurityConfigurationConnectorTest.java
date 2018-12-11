package at.technikum.wien.mse.swe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import at.technikum.wien.mse.swe.model.RiskCategory;
import org.junit.Test;

import at.technikum.wien.mse.swe.connector.SecurityConfigurationConnectorImpl;
import at.technikum.wien.mse.swe.model.SecurityConfiguration;

/**
 * @author MatthiasKreuzriegler
 */
public class SecurityConfigurationConnectorTest {

    private final SecurityConfigurationConnector sut = new SecurityConfigurationConnectorImpl();
    private static final String FILENAME = "examples/SecurityConfiguration_AT0000937503.txt";


    @Test
    public void testRead_notNull() throws URISyntaxException {
        SecurityConfiguration configuration = sut.read(Paths.get(ClassLoader.getSystemResource(FILENAME).toURI()));
        assertNotNull("configuration not found", configuration);
    }

    @Test
    public void testRead_isin() throws URISyntaxException {
        SecurityConfiguration configuration = sut.read(Paths.get(ClassLoader.getSystemResource(FILENAME).toURI()));
        assertNotNull("isin not found", configuration.getIsin());
        assertEquals("AT0000937503", configuration.getIsin());
    }

    @Test
    public void testRead_RiskCatedory() throws URISyntaxException {
        SecurityConfiguration configuration = sut.read(Paths.get(ClassLoader.getSystemResource(FILENAME).toURI()));
        assertEquals(RiskCategory.LOW, configuration.getRiskCategory());
    }

    @Test
    public void testRead_Name() throws URISyntaxException {
        SecurityConfiguration configuration = sut.read(Paths.get(ClassLoader.getSystemResource(FILENAME).toURI()));
        assertEquals("voestalpine Aktie", configuration.getName());
    }

    @Test
    public void testRead_YearHighest() throws URISyntaxException {
        SecurityConfiguration configuration = sut.read(Paths.get(ClassLoader.getSystemResource(FILENAME).toURI()));
        assertNotNull("yearHighest not found", configuration.getBalanceHighest());
        assertEquals("EUR", configuration.getCurrency());
        assertEquals(BigDecimal.valueOf(54.98d), configuration.getBalanceHighest());
    }

    @Test
    public void testRead_YearLowest() throws URISyntaxException {
        SecurityConfiguration configuration = sut.read(Paths.get(ClassLoader.getSystemResource(FILENAME).toURI()));
        assertNotNull("yearLowest not found", configuration.getBalanceLowest());
        assertEquals("EUR", configuration.getCurrency());
        assertEquals(BigDecimal.valueOf(29.60d), configuration.getBalanceLowest());
    }

}
