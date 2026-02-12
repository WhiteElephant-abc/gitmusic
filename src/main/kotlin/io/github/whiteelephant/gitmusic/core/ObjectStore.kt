package io.github.whiteelephant.gitmusic.core

import java.nio.file.Path

/**
 * 对象存储管理器 - 管理本地cache和远端对象的存储、检索和删除
 *
 * 职责：
 * 1. 本地cache管理：对象写入、路径解析、存在性检查、引用计数辅助
 * 2. 对象存储：接收临时文件，计算oid，存储到本地cache（音频、封面等）
 * 3. 对象检索：根据oid获取本地路径，若缺失则从远端下载
 * 4. 批量操作：确保多个oid本地可用（下载缺失的）
 * 5. 扫描和清理：列出本地和远端对象，用于sync和cleanup命令
 * 6. 幂等写入：相同oid的对象只存储一次
 *
 * 关键接口（根据规范文档）：
 * - storeAudio(tempPath: Path): StoreResult // 返回audio_oid和存储路径
 * - storeCover(coverBytes: ByteArray, audioOid: String): CoverResult
 * - getPath(oid: String): Path? // 返回本地路径，若不存在返回null
 * - ensureLocal(oids: List<String>): EnsureResult // 确保所有oid本地可用
 * - exists(oid: String): Boolean // 检查本地是否存在
 * - scanLocal(): List<String> // 列出本地所有oid
 * - delete(oid: String): Boolean // 删除本地对象（用于cleanup）
 *
 * 设计要点：
 * - 路径结构：{cacheDir}/{oid前2位}/{oid}（避免单个目录文件过多）
 * - 原子写入：写临时文件→fsync→mv到目标路径
 * - 幂等性：检查目标文件是否已存在且哈希匹配，若匹配则跳过
 * - 引用计数：可选实现，跟踪对象被metadata引用的次数
 * - 与Transport集成：缺失对象时自动调用transport.download
 * - 远端校验：上传后验证远端sha256，确保传输完整性
 *
 * TODO: 定义StoreResult数据类（oid、localPath、uploaded、remotePath等）
 * TODO: 定义CoverResult数据类（coverOid、localPath等）
 * TODO: 定义EnsureResult数据类（present、downloaded、failed列表）
 * TODO: 实现storeAudio方法（计算哈希，存储到本地，可选上传远端）
 * TODO: 实现storeCover方法（类似storeAudio，但处理封面图片）
 * TODO: 实现getPath方法（根据oid计算路径，检查存在性）
 * TODO: 实现ensureLocal方法（批量检查并下载缺失对象）
 * TODO: 实现scanLocal方法（遍历cache目录，收集所有oid）
 * TODO: 实现delete方法（安全删除，检查引用计数）
 * TODO: 实现路径计算辅助方法（oid到路径的映射）
 * TODO: 实现哈希计算（调用HashUtils）
 * TODO: 实现与Transport的集成（上传和下载）
 */

class ObjectStore(private val ctx: Context) {
    // TODO: 实现ObjectStore
}