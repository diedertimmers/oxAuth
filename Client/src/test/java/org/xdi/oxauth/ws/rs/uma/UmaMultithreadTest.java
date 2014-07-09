package org.xdi.oxauth.ws.rs.uma;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xdi.oxauth.client.uma.MetaDataConfigurationService;
import org.xdi.oxauth.client.uma.UmaClientFactory;
import org.xdi.oxauth.model.uma.MetadataConfiguration;

/**
 * @author Yuriy Zabrovarnyy
 * @version 0.9, 23/06/2014
 */

public class UmaMultithreadTest {

    private MetaDataConfigurationService service;

    @BeforeClass
    public void before() {
        ClientConnectionManager connectoinManager = new PoolingClientConnectionManager();
        final DefaultHttpClient defaultHttpClient = new DefaultHttpClient(connectoinManager);
        final ApacheHttpClient4Executor clientExecutor = new ApacheHttpClient4Executor(defaultHttpClient);

        String url = "https://seed.gluu.org/oxauth/seam/resource/restv1/oxauth/uma-configuration";

        service = UmaClientFactory.instance().createMetaDataConfigurationService(url, clientExecutor);
    }


    @Test(invocationCount = 30, threadPoolSize = 3)
    public void test() {
        final MetadataConfiguration metadataConfiguration = service.getMetadataConfiguration();

        Assert.assertNotNull(metadataConfiguration);
        System.out.println(metadataConfiguration);

    }
}

