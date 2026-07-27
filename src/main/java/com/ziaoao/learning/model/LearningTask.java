package com.ziaoao.learning.model;

/**
 * 学习任务。
 *
 * <p>【周二：类、对象、构造方法和封装】</p>
 */
public class LearningTask {

    // private 表示字段只能由当前类直接访问，这就是封装的一部分。
    private final int id;
    private String name;
    private int plannedMinutes;
    private boolean completed;

    /**
     * 两个参数的构造方法：没有传学习时长时，默认安排 30 分钟。
     */
    public LearningTask(int id, String name) {
        this(id, name, 30);
    }

    /**
     * 三个参数的构造方法。
     *
     * <p>this.id 表示当前对象的字段，id 表示调用者传进来的参数。</p>
     */
    public LearningTask(int id, String name, int plannedMinutes) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("任务名称不能为空");
        }
        if (plannedMinutes <= 0) {
            throw new IllegalArgumentException("计划时长必须大于 0");
        }

        this.id = id;
        this.name = name;
        this.plannedMinutes = plannedMinutes;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("任务名称不能为空");
        }
        this.name = name;
    }

    public int getPlannedMinutes() {
        return plannedMinutes;
    }

    public void setPlannedMinutes(int plannedMinutes) {
        if (plannedMinutes <= 0) {
            throw new IllegalArgumentException("计划时长必须大于 0");
        }
        this.plannedMinutes = plannedMinutes;
    }

    public boolean isCompleted() {
        return completed;
    }

    /**
     * 对外提供“完成任务”的行为，而不是让其他类直接修改 completed 字段。
     */
    public void complete() {
        this.completed = true;
    }

    /**
     * println 输出对象时会自动调用 toString()。
     */
    @Override
    public String toString() {
        return "LearningTask{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", plannedMinutes=" + plannedMinutes +
                ", completed=" + completed +
                '}';
    }
}
