# Java Basics

一个使用标准分层结构编写的 Java 学习任务管理程序。

## 技术栈

- Java 17
- Maven

## 项目结构

```text
com.ziaoao.learning
├── Main.java
├── model
│   └── LearningTask.java
└── service
    ├── TaskService.java
    └── impl
        └── InMemoryTaskService.java
```

运行 `Main` 后可以新增、查看和完成学习任务。

## 本周知识点在代码中的位置

- 周一：`Main` 中的程序入口、变量、条件判断和循环。
- 周二：`Main` 中的方法，以及 `LearningTask` 中的对象、构造方法和封装。
- 周三：`InMemoryTaskService` 中的 `List`、`ArrayList` 和遍历。
- 周四：`TaskService` 接口、实现类以及 `Main` 对 Service 的调用。
- 周五：`Main` 中的 `try/catch`、运行时异常、堆栈和建议断点。

## 调试练习

1. 打开 `Main.java`，找到“建议断点”的注释。
2. 点击编辑器左侧行号区域添加断点。
3. 右键 `Main`，选择 **Debug**。
4. 使用 **Step Over** 观察下一行，使用 **Step Into** 进入 Service 实现。
5. 在计划时长或任务 ID 中输入 `abc`，观察 `NumberFormatException` 堆栈。
