package com.alibaba.pelican.chaos.client.utils;

import com.alibaba.pelican.chaos.client.RemoteCmdClientConfig;
import com.alibaba.pelican.chaos.client.impl.RemoteCmdClient;
import com.alibaba.pelican.chaos.client.utils.CpuUtils;
import com.alibaba.pelican.deployment.element.impl.AbstractElement;
import com.alibaba.pelican.deployment.junit.AbstractJUnit4PelicanTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;

/**
 * @author moyun@middleware
 */
@Slf4j
public class TestCpuUtils extends AbstractJUnit4PelicanTests {

    @Test
    public void test() {
        Map<String, String> params = ((AbstractElement) this.getTestProject()).getVariables();
        RemoteCmdClientConfig connectUnit = new RemoteCmdClientConfig();
        connectUnit.setPassword(params.get("password"));
        connectUnit.setUserName(params.get("userName"));
        connectUnit.setIp(params.get("ip"));
        RemoteCmdClient commandExecutor = new RemoteCmdClient(connectUnit);
        CpuUtils.adjustCpuUsage(commandExecutor, "50:10");
    }

}
