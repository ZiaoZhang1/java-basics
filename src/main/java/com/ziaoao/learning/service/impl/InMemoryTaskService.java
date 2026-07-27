package com.ziaoao.learning.service.impl;

import com.ziaoao.learning.model.LearningTask;
import com.ziaoao.learning.service.TaskService;

import java.util.ArrayList;
import java.util.List;

/**
 * TaskService 的内存实现。
 *
 * <p>【周三：集合】现在使用 ArrayList 保存数据，程序结束后数据会消失。以后接入 MySQL 时，
 * 上层仍然可以面向 TaskService 编程，只替换实现类。</p>
 */
public class InMemoryTaskService implements TaskService {

    private final List<LearningTask> tasks = new ArrayList<>();
    private int nextId = 1;

    @Override
    public LearningTask addTask(String name) {
        return addTask(name, 30);
    }

    @Override
    public LearningTask addTask(String name, int plannedMinutes) {
        LearningTask task = new LearningTask(nextId, name, plannedMinutes);
        tasks.add(task);
        nextId++;
        return task;
    }

    @Override
    public List<LearningTask> findAll() {
        // List.copyOf 返回只读副本，避免调用者直接修改本类内部的 tasks。
        return List.copyOf(tasks);
    }

    @Override
    public LearningTask findById(int id) {
        for (LearningTask task : tasks) {
            // 建议断点：观察循环中 task.getId() 与参数 id 的值。
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    @Override
    public boolean completeTask(int id) {
        LearningTask task = findById(id);
        if (task == null) {
            return false;
        }

        task.complete();
        return true;
    }
}
