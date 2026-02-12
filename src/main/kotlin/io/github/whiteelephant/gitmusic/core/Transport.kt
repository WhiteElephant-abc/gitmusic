package io.github.whiteelephant.gitmusic.core

import java.nio.file.Path

/**
 * 传输抽象接口 - 定义远端访问的统一接口，支持多种后端（SCP、S3等）
 *
 * 职责：
 * 1. 文件上传：本地文件→远端存储，包含完整性校验
 * 2. 文件下载：远端文件→本地存储，包含完整性校验
 * 3. 远端操作：列出远端对象、删除远端对象、计算远端哈希
 * 4. 重试策略：网络错误时自动重试，支持指数退避
 * 5. 连接管理：建立和关闭连接，认证管理
 *
 * 关键接口（根据规范文档）：
 * - upload(local: Path, remote: String): RemoteResult // 上传文件，返回远端哈希
 * - download(remote: String, local: Path): Unit // 下载文件到本地
 * - remoteSha256(remotePath: String): String // 计算远端文件SHA256
 * - scanRemote(): List<String> // 列出远端所有对象oid
 * - deleteRemote(remote: String): Boolean // 删除远端对象
 * - existsRemote(remote: String): Boolean // 检查远端是否存在
 *
 * 设计要点：
 * - 抽象接口：允许实现SCP、S3、SFTP等不同后端
 * - 完整性校验：上传后必须验证远端哈希与本地一致
 * - 原子操作：上传到临时路径→校验→移动到最终路径
 * - 幂等性：相同文件已存在且哈希匹配时跳过上传
 * - 重试策略：可配置重试次数、指数退避、超时时间
 * - 连接池：复用连接，提高性能
 * - 安全性：凭据管理，不在日志中泄露敏感信息
 * - 进度报告：大文件传输时报告进度事件
 *
 * TODO: 定义RemoteResult数据类（remotePath、remoteHash、uploaded、duration等）
 * TODO: 定义Transport接口，包含所有关键方法
 * TODO: 定义TransportConfig数据类（主机、端口、用户名、密钥路径、重试配置等）
 * TODO: 定义TransportFactory（根据配置创建具体Transport实例）
 * TODO: 实现基础抽象类BaseTransport（提供重试、错误处理等通用逻辑）
 * TODO: 考虑使用Kotlin协程或响应式流支持异步操作
 * TODO: 考虑支持大文件分块传输和断点续传
 */

interface Transport {
    // TODO: 定义Transport接口方法
}

data class RemoteResult(
    // TODO: 定义RemoteResult字段
)

data class TransportConfig(
    // TODO: 定义TransportConfig字段
)