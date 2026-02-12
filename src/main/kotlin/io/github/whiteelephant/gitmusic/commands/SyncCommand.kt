package io.github.whiteelephant.gitmusic.commands

import io.github.whiteelephant.gitmusic.Context

/**
 * sync命令 - 双向增量同步本地cache与远端data
 *
 * 功能：扫描本地与远端对象索引，计算差异计划，执行上传/下载，支持重试与指数退避
 *
 * 必需参数：
 * - --direction <upload|download|both>：同步方向，默认both
 * - --dry-run：仅显示差异，不执行同步
 * - --timeout <n>：单个文件超时时间
 * - --workers <n>：并行线程数
 *
 * 别名：
 * - push 等价 sync --direction=upload
 * - pull 等价 sync --direction=download
 *
 * 工作流步骤：
 * 1. scan_local_remote_index - 列出本地与远端oid
 * 2. diff_and_plan - 计算上传/下载计划
 * 3. execute_plan - 执行上传/下载，带重试与指数退避
 * 4. summary - 输出同步摘要
 *
 * 事件输出：
 * - phase_start("scan")
 * - log（计划项）
 * - item_event("plan_item")
 * - batch_progress（执行进度）
 * - item_event("uploaded", "downloaded")
 * - error（传输失败）
 * - result/summary
 *
 * 锁策略：不需要锁（同步操作是幂等的）
 * 失败策略：传输失败按重试策略处理，超时或多次失败按on_error决定是否继续
 *
 * TODO: 实现Command接口，设置name="sync"，别名["push", "pull"]
 * TODO: 实现addArguments方法，添加所有必需参数
 * TODO: 实现run方法，按4个步骤调用core模块函数
 * TODO: 实现scan_local_remote_index步骤（调用core.object_store.scanLocal和core.transport.scanRemote）
 * TODO: 实现diff_and_plan步骤（调用core.sync.plan计算差异计划）
 * TODO: 实现execute_plan步骤（调用core.sync.execute执行计划，支持--dry-run）
 * TODO: 实现重试逻辑（使用core.transport的重试机制）
 * TODO: 实现并行处理（--workers参数）
 * TODO: 处理别名逻辑（push/pull映射到--direction参数）
 * TODO: 实现进度更新（batch_progress）和传输速率统计
 * TODO: 实现超时处理（--timeout参数）
 */

class SyncCommand : Command {
    override val name: String = "sync"
    override val description: String = "双向增量同步本地cache与远端data"
    override val aliases: List<String> = listOf("push", "pull")
    override val errorStrategy: ErrorStrategy = ErrorStrategy.CONTINUE

    override fun addArguments(parser: Any) {
        TODO("添加sync命令的所有参数")
    }

    override fun run(ctx: Context, args: Any): Int {
        TODO("实现sync命令的4个步骤工作流")
    }
}