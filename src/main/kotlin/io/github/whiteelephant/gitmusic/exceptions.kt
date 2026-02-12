package io.github.whiteelephant.gitmusic

/**
 * 自定义异常类型 - 项目特定的异常类层次结构
 *
 * 根据规范文档，需要以下异常类型：
 * 1. ValidationError：路径/参数验证失败，字段校验失败
 * 2. TransportError：远端传输错误（网络、SSH、SCP等）
 * 3. IOError：本地文件系统I/O错误（权限、磁盘空间、文件不存在等）
 * 4. LockError：锁获取失败、超时或释放错误
 * 5. ConflictError：资源冲突（如work目录文件冲突）
 * 6. GitError：git操作失败
 * 7. ConfigurationError：配置加载或解析失败
 * 8. ExternalToolError：外部工具调用失败（ffmpeg、yt-dlp等）
 *
 * 设计要点：
 * - 层次结构：所有异常继承自GitMusicException基类
 * - 丰富信息：包含错误代码、详细消息、上下文数据
 * - 可恢复性：区分可恢复错误和致命错误
 * - 事件集成：抛出前应emit error事件（由调用方负责）
 * - 多语言支持：考虑错误消息国际化（可选）
 * - 堆栈跟踪：包含完整堆栈便于调试，但生产日志可控制详细程度
 *
 * TODO: 定义GitMusicException抽象基类
 * TODO: 定义所有具体异常类（继承GitMusicException）
 * TODO: 定义错误代码枚举或密封类
 * TODO: 实现富错误信息（错误代码、上下文映射、可读消息）
 * TODO: 考虑使用Kotlin的密封类表示错误类型
 * TODO: 提供辅助函数创建常见错误
 * TODO: 集成withEventEmitting装饰器（在抛出前自动emit error）
 */

abstract class GitMusicException(
    message: String,
    cause: Throwable? = null,
    val code: ErrorCode? = null,
    val context: Map<String, Any> = emptyMap()
) : RuntimeException(message, cause)

// TODO: 定义ErrorCode密封类或枚举
sealed class ErrorCode

// TODO: 定义具体异常类
class ValidationError : GitMusicException {
    // TODO: 实现ValidationError
}

class TransportError : GitMusicException {
    // TODO: 实现TransportError
}

class IOError : GitMusicException {
    // TODO: 实现IOError
}

class LockError : GitMusicException {
    // TODO: 实现LockError
}

class ConflictError : GitMusicException {
    // TODO: 实现ConflictError
}

class GitError : GitMusicException {
    // TODO: 实现GitError
}

class ConfigurationError : GitMusicException {
    // TODO: 实现ConfigurationError
}

class ExternalToolError : GitMusicException {
    // TODO: 实现ExternalToolError
}