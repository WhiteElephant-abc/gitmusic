package io.github.whiteelephant.gitmusic.core

import java.nio.file.Path

/**
 * SCP传输适配器 - Transport接口的SCP/SFTP实现
 *
 * 职责：
 * 1. 通过SCP/SFTP协议上传文件到远端服务器
 * 2. 从远端服务器下载文件到本地
 * 3. 在远端执行命令（如sha256sum计算）
 * 4. 管理SSH连接和会话
 * 5. 实现重试和错误处理
 *
 * 上传流程（根据规范文档）：
 * 1. 本地写入临时文件 obj.tmp → fsync
 * 2. transport.upload(localTmp, remoteTmp) 上传到远端临时路径
 * 3. 在远端执行 sha256sum remote_tmp（由transport实现）并返回远端哈希
 * 4. 本地计算本地哈希并比对远端哈希；若一致，远端 mv remote_tmp remote_final（原子）
 * 5. 若不一致，重试或报错
 *
 * 下载流程：
 * 1. transport.download(remote, localPart) 下载到本地.part文件
 * 2. 本地计算哈希 → 比对期望 → mv到最终路径
 *
 * 设计要点：
 * - 使用JSch或Apache Mina SSHD实现SSH/SCP/SFTP
 * - 连接池：复用SSH会话，避免频繁建立连接
 * - 远端命令执行：通过SSH通道执行sha256sum等命令
 * - 原子移动：在远端使用mv命令原子移动文件
 * - 权限设置：上传后设置适当的文件权限
 * - 密钥认证：支持SSH密钥认证，密码可选但不推荐
 * - 超时控制：连接超时、读取超时、命令执行超时
 * - 重试机制：网络错误时自动重试，支持指数退避
 *
 * TODO: 实现Transport接口
 * TODO: 定义ScpConfig数据类（继承TransportConfig，添加SSH特定配置）
 * TODO: 实现upload方法（遵循上述5步流程）
 * TODO: 实现download方法（下载、校验、原子移动）
 * TODO: 实现remoteSha256方法（通过SSH执行sha256sum命令）
 * TODO: 实现scanRemote方法（通过SSH执行ls/find命令列出文件）
 * TODO: 实现deleteRemote方法（通过SSH执行rm命令）
 * TODO: 实现SSH连接管理（连接建立、维护、关闭）
 * TODO: 实现连接池和会话复用
 * TODO: 实现重试逻辑（网络错误、超时等）
 * TODO: 实现进度报告（传输字节数、速率等）
 * TODO: 实现安全最佳实践（主机密钥验证、密钥管理）
 */

class ScpAdapter(private val config: TransportConfig) : Transport {
    // TODO: 实现ScpAdapter
}