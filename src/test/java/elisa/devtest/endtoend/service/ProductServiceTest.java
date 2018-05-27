package elisa.devtest.endtoend.service;

import elisa.devtest.endtoend.dao.ProductDao;
import elisa.devtest.endtoend.model.Product;
import elisa.devtest.endtoend.model.ProductDto;
import elisa.devtest.endtoend.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {
    private ProductService productService = new ProductService();
    private final ProductDao productDao = mock(ProductDao.class);

    @Before
    public void setUp() {
        productService.setProductDao(productDao);
    }

    @Test
    @Transactional
    public void findProductsTest(){
        ProductDto productDto = new ProductDto("PHONES", TestUtils.PRODUCT_DTO_JSON_TEST);
        List<ProductDto> expected = new ArrayList<>();
        expected.add(productDto);

        when(productDao.findProducts()).thenReturn(expected);

        List<Product> actual = productService.findProducts();

        assertEquals(3, actual.size());
    }
}
