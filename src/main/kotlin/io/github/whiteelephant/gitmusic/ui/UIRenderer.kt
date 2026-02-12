package io.github.whiteelephant.gitmusic.ui

/**
 * UI渲染器抽象接口 - 定义统一的渲染接口，支持不同后端和运行模式
 *
 * 职责：
 * 1. 表格渲染：以结构化方式显示数据表格
 * 2. 进度显示：显示聚合进度条和单项进度
 * 3. 事件渲染：将事件转换为人类可读输出
 * 4. 面板渲染：显示标题面板、摘要信息
 * 5. 刷新控制：管理终端输出（覆盖行或追加行）
 *
 * 关键接口（根据规范文档）：
 * - renderTable(spec: TableSpec, rows: Iterable<Map<String, Any>>): Unit
 * - renderProgress(taskId: String, completed: Int, total: Int, meta: Map<String, Any> = emptyMap()): Unit
 * - renderEvent(event: Map<String, Any>): Unit
 * - renderPanel(title: String, lines: Iterable<String>): Unit
 * - flush(): Unit // 确保输出显示
 * - clearProgress(taskId: String): Unit // 清除进度条
 *
 * 运行模式：
 * - INTERACTIVE模式：使用终端渲染器（Mordant/Text），显示颜色、进度条、表格
 * - LOG_ONLY模式：使用Json/Noop渲染器，不渲染人类可读输出，事件通过EventEmitter处理
 *
 * 设计要点：
 * - 抽象接口：允许不同实现（Mordant、Text、Json、Noop、Capture等）
 * - 终端兼容：检测终端能力（支持颜色、覆盖行、宽度等）
 * - 性能：避免过于频繁的渲染调用，批量更新
 * - 一致性：不同命令的相似输出保持一致的视觉风格
 * - 可测试性：提供CaptureRenderer用于单元测试断言
 * - 国际化：考虑未来多语言支持（可选）
 *
 * TODO: 定义UIRenderer接口，包含所有关键方法
 * TODO: 定义TableSpec数据类（表格样式定义）
 * TODO: 定义ProgressStyle枚举（条形、旋转、百分比等）
 * TODO: 考虑使用Kotlin的expect/actual多平台支持
 * TODO: 考虑终端检测和回退逻辑（无颜色支持时降级）
 */

interface UIRenderer {
    // TODO: 定义UIRenderer接口方法
}

data class TableSpec(
    // TODO: 定义TableSpec字段（id、columns、maxRows、truncate、sortable等）
)