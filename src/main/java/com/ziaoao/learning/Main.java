package com.ziaoao.learning;

import com.ziaoao.learning.model.LearningTask;
import com.ziaoao.learning.service.TaskService;
import com.ziaoao.learning.service.impl.InMemoryTaskService;

import java.util.List;
import java.util.Scanner;

/**
 * 学习任务管理程序的入口。
 *
 * <p>这个小项目把本周的 Java 基础知识整合在一个正常运行的程序中。</p>
 */
public class Main {

    public static void main(String[] args) {
        /*
         * 【周一：程序结构、变量和基本类型】
         * main 是程序入口。下面声明了引用类型、基本类型和局部变量。
         */
        Scanner scanner = new Scanner(System.in);
        TaskService taskService = new InMemoryTaskService();
        boolean running = true;

        System.out.println("=== 学习任务管理程序 ===");

        /*
         * 【周一：循环和条件判断】
         * while 会在 running 为 true 时重复执行。
         * 建议断点 1：停在 while 这一行，观察 running 和 option 的变化。
         */
        while (running) {
            printMenu();
            String option = scanner.nextLine().trim();

            if ("1".equals(option)) {
                addTask(scanner, taskService);
            } else if ("2".equals(option)) {
                showAllTasks(taskService);
            } else if ("3".equals(option)) {
                completeTask(scanner, taskService);
            } else if ("0".equals(option)) {
                running = false;
            } else {
                System.out.println("没有这个选项，请重新输入。");
            }
        }

        System.out.println("程序已退出。");
    }

    /**
     * 【周二：方法】
     * 这是一个无参数、无返回值的方法，负责输出菜单。
     */
    private static void printMenu() {
        System.out.println("\n请选择操作：");
        System.out.println("1. 新增学习任务");
        System.out.println("2. 查看全部任务");
        System.out.println("3. 完成一个任务");
        System.out.println("0. 退出");
        System.out.print("请输入选项：");
    }

    /**
     * 【周二：方法参数和对象】
     * scanner 和 taskService 是方法参数。
     */
    private static void addTask(Scanner scanner, TaskService taskService) {
        System.out.print("请输入任务名称：");
        String name = scanner.nextLine().trim();

        System.out.print("请输入计划时长（分钟，直接回车则默认 30 分钟）：");
        String minutesText = scanner.nextLine().trim();

        try {
            LearningTask task;

            /*
             * 【周二：方法重载】
             * 输入为空时调用一个参数的 addTask；
             * 输入了时长时调用两个参数的 addTask。
             */
            if (minutesText.isEmpty()) {
                task = taskService.addTask(name);
            } else {
                int plannedMinutes = Integer.parseInt(minutesText);
                task = taskService.addTask(name, plannedMinutes);
            }

            // 建议断点 2：观察 task 对象的 id、name、plannedMinutes 和 completed。
            System.out.println("新增成功：" + task);
        } catch (NumberFormatException exception) {
            /*
             * 【周五：异常和堆栈】
             * 当输入无法转换成 int 时，Integer.parseInt 会抛出此异常。
             */
            System.out.println("新增失败：计划时长必须是整数。");
            printStackTraceForLearning(exception);
        } catch (IllegalArgumentException exception) {
            System.out.println("新增失败：" + exception.getMessage());
            printStackTraceForLearning(exception);
        }
    }

    /**
     * 【周三：List 和遍历】
     * Service 返回 List，这里使用增强 for 循环逐个查看任务。
     */
    private static void showAllTasks(TaskService taskService) {
        List<LearningTask> tasks = taskService.findAll();

        if (tasks.isEmpty()) {
            System.out.println("当前还没有学习任务。");
            return;
        }

        System.out.println("\n--- 全部学习任务 ---");
        for (LearningTask task : tasks) {
            System.out.println(task);
        }
    }

    /**
     * 【周四：分层调用】
     * Main 只调用 TaskService，不直接操作存放任务的 ArrayList。
     */
    private static void completeTask(Scanner scanner, TaskService taskService) {
        System.out.print("请输入要完成的任务 ID：");
        String idText = scanner.nextLine().trim();

        try {
            int id = Integer.parseInt(idText);

            // 建议断点 3：使用 Step Into 进入 Service 实现类，观察查找过程。
            boolean completed = taskService.completeTask(id);

            if (completed) {
                System.out.println("任务已完成：" + taskService.findById(id));
            } else {
                System.out.println("没有找到 ID 为 " + id + " 的任务。");
            }
        } catch (NumberFormatException exception) {
            System.out.println("操作失败：任务 ID 必须是整数。");
            printStackTraceForLearning(exception);
        }
    }

    /**
     * 【周五：阅读异常堆栈】
     * 学习阶段暂时打印完整堆栈。阅读时，从上往下找第一个 com.ziaoao 开头的位置，
     * 它通常就是异常最先经过的自己代码。
     */
    private static void printStackTraceForLearning(RuntimeException exception) {
        exception.printStackTrace(System.out);
    }
}
