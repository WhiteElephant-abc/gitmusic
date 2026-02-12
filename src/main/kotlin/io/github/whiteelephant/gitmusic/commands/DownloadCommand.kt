package io.github.whiteelephant.gitmusic.commands

import io.github.whiteelephant.gitmusic.Context

/**
 * download命令 - 使用yt-dlp下载音频并更新库，支持批处理与元数据预览
 *
 * 功能：调用yt-dlp获取元数据和音频，压缩封面，校验哈希，同步缓存，更新metadata
 *
 * 必需参数：
 * - <URL>：下载地址
 * - --batch-file <path>：批量下载文件路径（txt）
 * - --fetch：仅获取元数据预览（不下载）
 * - --no-preview：隐藏元数据预览
 *
 * 别名：fetch
 *
 * 工作流步骤：
 * 1. fetch_metadata - 若--fetch或预览阶段，调用yt-dlp获取元数据并emit预览事件
 * 2. download_media - 调用yt-dlp下载音频并捕获原始输出映射为progress事件
 * 3. compress_cover - 压缩封面并写入object_store
 * 4. verify_and_sync - 校验哈希并同步缓存，最后commit metadata
 *
 * 事件输出：
 * - item_event("preview")（元数据预览）
 * - progress（下载进度）
 * - item_event("downloaded", "cover_stored")
 * - error（下载或校验失败）
 * - result/summary
 *
 * 锁策略：写入metadata时需要锁
 * 失败策略：下载或校验失败为致命错误并中止当前项，批量模式继续处理其他项
 *
 * TODO: 实现Command接口，设置name="download"，别名["fetch"]
 * TODO: 实现addArguments方法，添加所有必需参数
 * TODO: 实现run方法，按4个步骤调用core模块函数
 * TODO: 实现fetch_metadata步骤（调用core.download.fetchMetadata，使用yt-dlp）
 * TODO: 实现download_media步骤（调用core.download.downloadMedia，捕获进度）
 * TODO: 实现compress_cover步骤（调用core.audio.processCover）
 * TODO: 实现verify_and_sync步骤（调用core.hash.verify和core.metadata.addOrUpdateAndCommit）
 * TODO: 处理批量下载（--batch-file）
 * TODO: 实现外部进程调用（yt-dlp）和输出解析
 * TODO: 实现进度映射（将yt-dlp输出转换为progress事件）
 * TODO: 处理--fetch和--no-preview参数
 * TODO: 实现错误恢复（单个URL失败不影响批量中其他URL）
 */

class DownloadCommand : Command {
    override val name: String = "download"
    override val description: String = "使用yt-dlp下载音频并更新库，支持批处理与元数据预览"
    override val aliases: List<String> = listOf("fetch")
    override val errorStrategy: ErrorStrategy = ErrorStrategy.CONTINUE

    override fun addArguments(parser: Any) {
        TODO("添加download命令的所有参数")
    }

    override fun run(ctx: Context, args: Any): Int {
        TODO("实现download命令的4个步骤工作流")
    }
}