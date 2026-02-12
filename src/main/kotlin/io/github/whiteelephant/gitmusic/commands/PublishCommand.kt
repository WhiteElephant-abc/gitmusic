package io.github.whiteelephant.gitmusic.commands

import io.github.whiteelephant.gitmusic.Context

/**
 * publish命令 - 发布work目录改动到库
 *
 * 功能：扫描work目录，与metadata.jsonl比对，生成字段级diff，完成对象写入、封面压缩、哈希校验、同步上传与metadata提交
 *
 * 必需参数：
 * - --changed-only：仅处理有变动的文件
 * - --preview：仅显示预览，不执行发布
 *
 * 工作流步骤（根据规范文档）：
 * 1. scan_work - 列出work目录文件并读取嵌入标签
 * 2. diff_with_metadata - 与metadata.jsonl比对，标注NEW/MOD/SAME并生成字段级diff
 * 3. preview_and_confirm - 渲染预览表格并等待用户确认；若--preview则退出并返回预览
 * 4. hash_and_store_audio - 提取音频流、计算音频帧哈希、写入object_store（本地并上传远端）
 * 5. compress_and_store_cover - 提取并压缩封面，写入object_store
 * 6. validate_and_verify - 本地与远端哈希校验，失败终止命令
 * 7. update_metadata_commit - 在持锁下更新metadata.jsonl并commit推送
 *
 * 事件输出：
 * - 阶段开始：phase_start
 * - 批量进度：batch_progress
 * - 单项事件：item_event（found, diff_preview, audio_stored, cover_stored, verify_ok等）
 * - 错误事件：error
 * - 结果事件：result/summary
 *
 * 锁策略：在需要写metadata前获取写锁（步骤4或7）
 * 失败策略：默认on_error=stop；校验失败或远端不一致为致命错误并中止
 *
 * TODO: 实现Command接口，设置name="publish"，description="发布work目录改动到库"
 * TODO: 实现addArguments方法，添加--changed-only和--preview参数
 * TODO: 实现run方法，按上述7个步骤调用core模块函数
 * TODO: 在步骤1开始时发射phase_start("scan_work")
 * TODO: 实现scan_work步骤（调用core.work.scanWork）
 * TODO: 实现diff_with_metadata步骤（调用core.metadata.diffItems）
 * TODO: 实现preview_and_confirm步骤（使用ctx.ui.render_table显示预览，检查--preview或ctx.mode）
 * TODO: 实现hash_and_store_audio步骤（调用core.audio.hashAndStore，需要获取锁）
 * TODO: 实现compress_and_store_cover步骤（调用core.audio.processCover）
 * TODO: 实现validate_and_verify步骤（调用core.hash.verifyLocalAndRemote）
 * TODO: 实现update_metadata_commit步骤（调用core.metadata.addOrUpdateAndCommit，需要持锁）
 * TODO: 实现错误处理，根据errorStrategy决定行为
 * TODO: 确保锁在finally块中释放
 * TODO: 实现进度更新（batch_progress）和单项事件发射
 */

class PublishCommand : Command {
    override val name: String = "publish"
    override val description: String = "发布work目录改动到库"
    override val aliases: List<String> = emptyList()
    override val errorStrategy: ErrorStrategy = ErrorStrategy.STOP

    override fun addArguments(parser: Any) {
        TODO("添加--changed-only和--preview参数")
    }

    override fun run(ctx: Context, args: Any): Int {
        TODO("实现publish命令的7个步骤工作流")
    }
}