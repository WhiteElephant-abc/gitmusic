package io.github.whiteelephant.gitmusic.core

/**
 * 运行时Context - 包含所有运行时依赖和配置
 *
 * 职责：作为依赖注入容器，提供命令执行所需的所有资源和配置
 *
 * 包含字段（根据规范文档）：
 * 1. 路径相关：
 *    - projectRoot: Path - 项目根目录（config.yaml所在）
 *    - workDir: Path - work目录（用户编辑音频文件）
 *    - cacheDir: Path - cache目录（本地对象存储）
 *    - releaseDir: Path - release目录（成品输出）
 *    - logsDir: Path - 日志目录
 *    - tmpDir: Path - 临时文件目录
 *
 * 2. 运行模式：
 *    - mode: RunMode - INTERACTIVE 或 LOG_ONLY
 *    - isVerbose: Boolean - 详细输出模式
 *
 * 3. 服务组件：
 *    - transport: Transport - 远端传输适配器（默认ScpAdapter）
 *    - ui: UIRenderer - UI渲染器（根据mode选择MordantRenderer或JsonRenderer）
 *    - events: EventEmitter - 事件发射器
 *    - locking: LockManager - 锁管理器
 *    - executor: ExecutorService - 线程池（用于并行任务）
 *
 * 4. 配置：
 *    - config: AppConfig - 从config.yaml加载的完整配置
 *
 * 设计要点：
 * - 所有路径为绝对路径，由CLI解析后注入
 * - 库函数通过Context访问所需服务，不自行创建实例
 * - Context是线程安全的，可在并发任务中共享
 * - 在命令执行开始时创建，结束时清理（关闭传输连接、关闭线程池）
 *
 * TODO: 定义RunMode枚举（INTERACTIVE, LOG_ONLY）
 * TODO: 定义AppConfig数据类（对应config.yaml结构）
 * TODO: 定义Context类，包含所有上述字段
 * TODO: 实现工厂方法/构建器（便于CLI创建Context）
 * TODO: 实现资源清理方法（close或use模式）
 * TODO: 实现路径验证方法（确保目录存在、可读写等）
 * TODO: 考虑使用依赖注入框架（如Koin）或手动依赖管理
 * TODO: 确保线程安全性（使用val不可变字段或线程安全容器）
 */

enum class RunMode {
    INTERACTIVE,
    LOG_ONLY
}

// 配置类，对应config.yaml结构
data class AppConfig(
    // TODO: 定义所有配置字段
)

data class Context(
    // TODO: 定义所有Context字段
)