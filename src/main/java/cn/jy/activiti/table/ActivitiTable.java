package cn.jy.activiti.table;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

/**
 * @author DengQiang.Wu
 * @date 2019-09-04 17:31
 */
public class ActivitiTable {


    /**
     * 创建流程引擎的表
     */
    @Test
    public void createTabale() {
        ProcessEngine processEngineConfiguration = ProcessEngineConfiguration.
                createProcessEngineConfigurationFromResource("activiti.cfg.xml", "processEngineConfiguration").
                buildProcessEngine();
    }
}
