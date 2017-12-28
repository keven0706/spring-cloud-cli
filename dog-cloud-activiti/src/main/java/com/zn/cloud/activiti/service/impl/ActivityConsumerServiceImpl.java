package com.zn.cloud.activiti.service.impl;

import com.zn.cloud.activiti.dto.TaskRepresentation;
import com.zn.cloud.activiti.service.ActivityConsumerService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by zhaining
 * @description
 * @created date 2017/11/24.
 */
@Service("activityService")
public class ActivityConsumerServiceImpl implements ActivityConsumerService
{
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @Override
    public boolean startActivityDemo()
    {
        System.out.println("method startActivityDemo begin....");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("apply","zhangsan");
        map.put("approve","lisi");
        //流程启动
        ProcessInstance pi1 =  runtimeService.startProcessInstanceByKey("leave",map);
        String processId = pi1.getId();
        //String taskId = null;//pi1.getTasks().get(0).getId();
        //taskService.complete(taskId, map);//完成第一步申请

//        Task task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
//        String taskId2 = task.getId();
//        map.put("pass", false);
//        taskService.complete(taskId2, map);//驳回申请
        System.out.println("method startActivityDemo end....");
        return false;
    }

    @Override
    public List<TaskRepresentation> getTasks(String assignee)
    {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(assignee).list();;
        List<TaskRepresentation> dtos = new ArrayList<TaskRepresentation>();
        for (Task task : tasks) {
            dtos.add(new TaskRepresentation(task.getId(), task.getName()));
        }
        return dtos;
    }

    @Override
    public String complete(Boolean joinApproved, String taskId)
    {
        Map<String, Object> taskVariables = new HashMap<>(16);
        taskVariables.put("pass", joinApproved);
        taskService.complete(taskId, taskVariables);
        return "ok";
    }
}
