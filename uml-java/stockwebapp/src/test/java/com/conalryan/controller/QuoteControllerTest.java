package com.conalryan.controller;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.math.BigDecimal;

import com.conalryan.model.StockQuote;
import com.conalryan.services.StockService;
import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

public class QuoteControllerTest {

    @Test
    public void testQuote() throws Exception {
        StockService mockService = mock(StockService.class);
        QuoteController controller = new QuoteController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/quote"))
                .andExpect(view().name("quote"));
    }

    /*@Test
    public void testQuote() throws Exception {
        StockQuote expectedStockQuote = createStockQuote();
        StockService mockStockService = mock(StockService.class);
        when(mockStockService.getQuote("AAPL"))
                .thenReturn(expectedStockQuote);

        QuoteController controller = new QuoteController();
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/quote.jsp"))
                .build();

        mockMvc.perform(get("/quote"))
                .andExpect(view().name("quote"));
                //.andExpect(model().attributeExists("quote"));
                //.andExpect(model().attribute("quote",
                  //      hasItem(expectedStockQuote)));

    }

    private StockQuote createStockQuote() {
        BigDecimal price = new BigDecimal(100);
        DateTime date = new DateTime(2015, 2, 23, 0, 0, 0, 0);
        String symbol = "AAPL";

        return new StockQuote(price, date, symbol);
    }*/
}