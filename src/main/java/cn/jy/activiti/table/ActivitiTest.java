package cn.jy.activiti.table;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.List;

/**
 * @author DengQiang.Wu
 * @date 2019-09-04 18:07
 */
public class ActivitiTest {


    /**
     * 创建 act_re_procdef shenqing:1:4
     */
    @Test
    public void createActivitiTask() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        processEngine.getRepositoryService().createDeployment().addClasspathResource("activiti.bpmn")
                .addClasspathResource("activiti.png").deploy();
    }

    /**
     * 启动流程实例
     *
     */
    @Test
    public void testStartProcessInstance() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        processEngine.getRuntimeService().startProcessInstanceById("shenqing:1:4");
    }

    /**
     * 完成请假申请
     */
    @Test
    public void testQingJia() {

        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        defaultProcessEngine.getTaskService().complete("7505");
    }

    @Test
    public void testQueryTask() {
        TaskService taskService = ProcessEngines.getDefaultProcessEngine().getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskAssignee("小王").list();
        for (Task task : tasks) {
            System.out.println(task.getName());
        }
    }

    @Test
    public void testFinishTask_manager() {
        TaskService taskService = ProcessEngines.getDefaultProcessEngine().getTaskService();
        taskService.complete("15002");
    }
}
