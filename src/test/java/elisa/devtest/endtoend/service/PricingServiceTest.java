package elisa.devtest.endtoend.service;

import elisa.devtest.endtoend.dao.PricingDao;
import elisa.devtest.endtoend.model.Price;
import elisa.devtest.endtoend.model.PriceDto;
import elisa.devtest.endtoend.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PricingServiceTest {

    private PricingService pricingService = new PricingService();
    private final PricingDao pricingDao = mock(PricingDao.class);

    @Before
    public void setUp() {
        pricingService.setPricingDao(pricingDao);
    }

    @Test
    public void findPricesTest(){
        PriceDto priceDto = new PriceDto("PHONES", TestUtils.PRICING_DTO_JSON_TEST);
        List<PriceDto> expected = new ArrayList<>();
        expected.add(priceDto);

        when(pricingDao.findPrices()).thenReturn(expected);

        List<Price> actual = pricingService.findPrices();

        assertEquals(2, actual.size());
    }
}
