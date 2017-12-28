package com.zn.cloud.activiti.service;

import com.zn.cloud.activiti.dto.TaskRepresentation;
import org.activiti.engine.task.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author by zhaining
 * @description
 * @created date 2017/11/24.
 */
@RestController
@RequestMapping("/activityService")
public interface ActivityConsumerService
{
    /**
     * 流程demo
     * @return
     */
    @RequestMapping(value="/startActivityDemo",method= RequestMethod.GET)
    boolean startActivityDemo();

    /**
     * dd
     * @param assignee
     * @return
     */
    @RequestMapping(value="/task" ,method = RequestMethod.GET)
    List<TaskRepresentation> getTasks(@RequestParam String assignee);

    /**
     * a
     * @param joinApproved
     * @param taskId
     * @return
     */
    @RequestMapping(value = "/{joinApproved}/{taskId}", method = RequestMethod.GET)
    String complete(@PathVariable("joinApproved") Boolean joinApproved, @PathVariable("taskId") String taskId);
}
