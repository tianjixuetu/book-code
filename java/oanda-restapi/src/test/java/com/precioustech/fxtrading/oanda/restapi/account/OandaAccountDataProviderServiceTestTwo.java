package com.precioustech.fxtrading.oanda.restapi.account;

import com.precioustech.fxtrading.account.Account;
import com.precioustech.fxtrading.oanda.restapi.OandaTestUtils;
import org.apache.http.impl.client.CloseableHttpClient;

import static com.precioustech.fxtrading.oanda.restapi.OandaTestConstants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class OandaAccountDataProviderServiceTestTwo {
    private static OandaAccountDataProviderService createSpyAndCommonStuff(String fname,
                                                                    OandaAccountDataProviderService service) throws Exception {
        OandaAccountDataProviderService spy = spy(service);

        CloseableHttpClient mockHttpClient = mock(CloseableHttpClient.class);
        when(spy.getHttpClient()).thenReturn(mockHttpClient);

        OandaTestUtils.mockHttpInteraction(fname, mockHttpClient);

        return spy;
    }

    // TODO: this test logs "java.io.IOException: Stream Closed" because of same
    // FileInputStream reread once closed
    public static void allAccountsTest() throws Exception {
        final OandaAccountDataProviderService service = new OandaAccountDataProviderService(url, userName, accessToken);
        assertEquals("https://api-fxtrade.oanda.com/v1/accounts?username=testTrader", service.getAllAccountsUrl());
        OandaAccountDataProviderService spy = createSpyAndCommonStuff("src/test/resources/accountsAll.txt", service);
        spy.getLatestAccountInfo();
    }


    public static void accountIdTest() throws Exception {
        final OandaAccountDataProviderService service = new OandaAccountDataProviderService(url, userName, accessToken);
        assertEquals("https://api-fxtrade.oanda.com/v1/accounts/123456", service.getSingleAccountUrl(accountId));

        OandaAccountDataProviderService spy = createSpyAndCommonStuff("src/test/resources/account123456.txt", service);
        Account<Long> accInfo = spy.getLatestAccountInfo(accountId);
        System.out.println(accInfo);
        System.out.println("getCurrency()" + accInfo.getCurrency());
        System.out.println("getMarginRate()" + accInfo.getMarginRate());
        System.out.println("getUnrealisedPnl()" + accInfo.getUnrealisedPnl());
    }
    public static void main(String[] args) throws Exception {
        System.out.println("run test OandaAccountDataProviderServiceTestTwo");
        allAccountsTest();
        accountIdTest();
        System.out.println("run OandaAccountDataProviderServiceTestTwo successfully");
    }
}
