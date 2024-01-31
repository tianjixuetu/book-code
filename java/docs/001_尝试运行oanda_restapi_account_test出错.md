1. 最开始是缺少httpClient,通过编译的时候传入地址，解决成功
` java -cp ".;D:\learn_java\book-code\java\oanda-restapi\target\test-classes;D:\learn_java\httpclient-4.5.13.jar" com.precioustech.fxtrading.oanda.restapi.account.OandaAccountDataProviderServiceTestTwo
   run test OandaAccountDataProviderServiceTestTwo`
2. 然后缺少具体的类
` java -cp ".;D:\learn_java\book-code\java\oanda-restapi\target\test-classes;D:\learn_java\httpclient-4.5.13.jar" com.precioustech.fxtrading.oanda.restapi.account.OandaAccountDataProviderServiceTestTwo
   run test OandaAccountDataProviderServiceTestTwo
   Exception in thread "main" java.lang.NoClassDefFoundError: com/precioustech/fxtrading/oanda/restapi/account/OandaAccountDataProviderService
   at com.precioustech.fxtrading.oanda.restapi.account.OandaAccountDataProviderServiceTestTwo.allAccountsTest(OandaAccountDataProviderServiceTestTwo.java:27)
   at com.precioustech.fxtrading.oanda.restapi.account.OandaAccountDataProviderServiceTestTwo.main(OandaAccountDataProviderServiceTestTwo.java:47)
   Caused by: java.lang.ClassNotFoundException: com.precioustech.fxtrading.oanda.restapi.account.OandaAccountDataProviderService
   at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
   at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
   at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526)`
3. 其他问题
