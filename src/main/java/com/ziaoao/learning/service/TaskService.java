package com.ziaoao.learning.service;

import com.ziaoao.learning.model.LearningTask;

import java.util.List;

/**
 * 任务服务接口。
 *
 * <p>【周四：接口与分层意识】接口只说明“可以做什么”，
 * 不关心数据具体存在哪里、操作具体怎样完成。</p>
 */
public interface TaskService {

    /**
     * 新增一个默认 30 分钟的任务。
     */
    LearningTask addTask(String name);

    /**
     * 同名、不同参数的方法构成方法重载。
     */
    LearningTask addTask(String name, int plannedMinutes);

    List<LearningTask> findAll();

    LearningTask findById(int id);

    boolean completeTask(int id);
}
