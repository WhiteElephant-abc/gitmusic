package io.github.whiteelephant.gitmusic.commands

import io.github.whiteelephant.gitmusic.Context

/**
 * cleanup命令 - 识别并可选清理孤立对象，支持本地与远端双端清理
 *
 * 功能：从metadata生成引用表，扫描本地与远端对象，计算孤立对象集合，报告或删除
 *
 * 必需参数：
 * - --mode <local|server|both>：清理模式（本地cache、远端server或两者）
 * - --confirm：必须指定才执行删除
 *
 * 工作流步骤：
 * 1. build_reference_table - 从metadata生成引用表
 * 2. scan_objects - 列出本地与远端对象
 * 3. compute_orphans - 计算孤立对象集合
 * 4. report_or_delete - 若--confirm执行删除并emit summary
 *
 * 事件输出：
 * - phase_start各阶段
 * - log（扫描结果）
 * - item_event("orphan")
 * - error（删除失败）
 * - result/summary
 *
 * 锁策略：删除操作需要锁保护，避免并发修改
 * 失败策略：默认仅报告；删除需--confirm才执行，避免误删
 *
 * TODO: 实现Command接口，设置name="cleanup"
 * TODO: 实现addArguments方法，添加--mode和--confirm参数
 * TODO: 实现run方法，按4个步骤调用core模块函数
 * TODO: 实现build_reference_table步骤（调用core.metadata.buildReferenceTable）
 * TODO: 实现scan_objects步骤（调用core.object_store.scanLocal和core.transport.scanRemote）
 * TODO: 实现compute_orphans步骤（调用core.cleanup.computeOrphans）
 * TODO: 实现report_or_delete步骤（根据--confirm决定仅报告或执行删除）
 * TODO: 实现安全删除（先移动到临时区域，确认后永久删除）
 * TODO: 处理--mode参数（local/server/both）
 * TODO: 实现引用完整性检查（确保不会删除被metadata引用的对象）
 * TODO: 实现破坏性操作确认（interactive模式双重确认）
 */

class CleanupCommand : Command {
    override val name: String = "cleanup"
    override val description: String = "识别并可选清理孤立对象，支持本地与远端双端清理"
    override val aliases: List<String> = emptyList()
    override val errorStrategy: ErrorStrategy = ErrorStrategy.STOP

    override fun addArguments(parser: Any) {
        TODO("添加cleanup命令的所有参数")
    }

    override fun run(ctx: Context, args: Any): Int {
        TODO("实现cleanup命令的4个步骤工作流")
    }
}