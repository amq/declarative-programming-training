package at.technikum.wien.mse.swe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import at.technikum.wien.mse.swe.model.RiskCategory;
import org.junit.Test;

import at.technikum.wien.mse.swe.connector.SecurityAccountOverviewConnectorImpl;
import at.technikum.wien.mse.swe.model.SecurityAccountOverview;
import org.omg.PortableInterceptor.NON_EXISTENT;

/**
 * @author MatthiasKreuzriegler
 */
public class SecurityAccountOverviewConnectorTest {

    private final SecurityAccountOverviewConnector sut = new SecurityAccountOverviewConnectorImpl();
    private static final String FILENAME = "examples/SecurityAccountOverview_12345678.txt";


    @Test
    public void testRead_notNull() throws URISyntaxException {
        SecurityAccountOverview overview = sut.read(Paths.get(ClassLoader.getSystemResource(FILENAME).toURI()));
        assertNotNull("overview not found", overview);
    }

    @Test
    public void testRead_accountNumber() throws URISyntaxException {
        SecurityAccountOverview overview = sut.read(Paths.get(ClassLoader.getSystemResource(FILENAME).toURI()));
        assertNotNull("accountNumber not found", overview.getAccountNumber());
        assertEquals("12345678", overview.getAccountNumber());
    }

    @Test
    public void testRead_riskCategory() throws URISyntaxException {
        SecurityAccountOverview overview = sut.read(Paths.get(ClassLoader.getSystemResource(FILENAME).toURI()));
        assertNotNull("riskCategory not found", overview.getRiskCategory());
        assertEquals(RiskCategory.NON_EXISTING, overview.getRiskCategory());
    }

    @Test
    public void testRead_DepotOwner() throws URISyntaxException {
        SecurityAccountOverview overview = sut.read(Paths.get(ClassLoader.getSystemResource(FILENAME).toURI()));
        assertEquals("MUSTERMANN", overview.getLastName());
        assertEquals("MAX UND MARIA", overview.getFirstName());
    }

    @Test
    public void testRead_Balance() throws URISyntaxException {
        SecurityAccountOverview overview = sut.read(Paths.get(ClassLoader.getSystemResource(FILENAME).toURI()));
        assertNotNull("balance not found", overview.getBalance());
        assertEquals("EUR", overview.getCurrency());
        assertEquals(BigDecimal.valueOf(1692.45), overview.getBalance());
    }

}
