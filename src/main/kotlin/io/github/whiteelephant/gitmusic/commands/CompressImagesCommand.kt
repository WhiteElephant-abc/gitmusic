package io.github.whiteelephant.gitmusic.commands

import io.github.whiteelephant.gitmusic.Context

/**
 * compress_images命令 - 压缩封面图片以优化体积并在哈希变化时更新metadata
 *
 * 功能：扫描大于阈值的封面图片，使用ffmpeg压缩，计算新哈希，若变化则更新metadata
 *
 * 必需参数：
 * - --size <n>：压缩阈值，支持单位kb mb gb，默认单位kb
 *
 * 工作流步骤：
 * 1. scan_covers - 列出大于阈值的封面
 * 2. compress_each - 使用ffmpeg压缩并计算新哈希
 * 3. update_metadata_if_changed - 若哈希变化更新metadata并commit
 *
 * 事件输出：
 * - phase_start("scan")
 * - item_event("compressed")
 * - error（压缩失败）
 * - result/summary
 *
 * 锁策略：更新metadata时需要锁
 * 失败策略：压缩失败记录warn并继续，更新metadata失败为error并停止相关项
 *
 * TODO: 实现Command接口，设置name="compress-images"
 * TODO: 实现addArguments方法，添加--size参数（支持单位）
 * TODO: 实现run方法，按3个步骤调用core模块函数
 * TODO: 实现scan_covers步骤（调用core.cover.scanLargeCovers）
 * TODO: 实现compress_each步骤（调用core.cover.compress，使用ffmpeg）
 * TODO: 实现update_metadata_if_changed步骤（调用core.metadata.updateIfHashChanged）
 * TODO: 实现文件大小阈值解析（--size参数，支持kb/mb/gb单位）
 * TODO: 实现外部进程调用（ffmpeg）和错误处理
 * TODO: 实现哈希比较和metadata增量更新
 * TODO: 实现进度更新（压缩进度）
 * TODO: 实现回滚机制（压缩失败时恢复原文件）
 */

class CompressImagesCommand : Command {
    override val name: String = "compress-images"
    override val description: String = "压缩封面图片以优化体积并在哈希变化时更新metadata"
    override val aliases: List<String> = emptyList()
    override val errorStrategy: ErrorStrategy = ErrorStrategy.CONTINUE

    override fun addArguments(parser: Any) {
        TODO("添加compress-images命令的--size参数")
    }

    override fun run(ctx: Context, args: Any): Int {
        TODO("实现compress-images命令的3个步骤工作流")
    }
}