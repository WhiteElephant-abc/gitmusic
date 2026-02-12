package io.github.whiteelephant.gitmusic.commands

import io.github.whiteelephant.gitmusic.Context

/**
 * verify命令 - 校验cache或release中文件的SHA256完整性
 *
 * 功能：收集目标文件列表，重新计算SHA256并与期望值比较，可选删除不匹配文件
 *
 * 必需参数：
 * - --mode <data|release>：校验模式（cache数据或release成品）
 * - --delete：自动删除无法匹配或哈希错误的文件（移动到回收站）
 *
 * 工作流步骤：
 * 1. collect_targets - 构建待校验列表
 * 2. compute_and_compare - 重新计算SHA256并与期望值比较
 * 3. optional_delete - 若--delete将坏文件移动到回收站并emit事件
 * 4. summary - 输出结果
 *
 * 事件输出：
 * - phase_start("collect")
 * - batch_progress（校验进度）
 * - item_event("verify_ok", "verify_fail")
 * - item_event("deleted")（若--delete）
 * - error（校验失败）
 * - result/summary
 *
 * 锁策略：读取操作不需要锁，删除操作可能需要锁
 * 失败策略：校验失败记录为error或warn，--delete为破坏性操作需谨慎确认
 *
 * TODO: 实现Command接口，设置name="verify"
 * TODO: 实现addArguments方法，添加--mode和--delete参数
 * TODO: 实现run方法，按4个步骤调用core模块函数
 * TODO: 实现collect_targets步骤（根据--mode调用core.verify.collectTargets）
 * TODO: 实现compute_and_compare步骤（调用core.hash.computeAndCompare批量校验）
 * TODO: 实现optional_delete步骤（若--delete，调用core.cleanup.moveToTrash）
 * TODO: 实现回收站机制（移动到特定目录而非直接删除）
 * TODO: 实现校验结果统计（成功、失败、跳过数量）
 * TODO: 处理破坏性操作确认（在interactive模式提示用户确认）
 * TODO: 实现进度更新和详细报告
 */

class VerifyCommand : Command {
    override val name: String = "verify"
    override val description: String = "校验cache或release中文件的SHA256完整性"
    override val aliases: List<String> = emptyList()
    override val errorStrategy: ErrorStrategy = ErrorStrategy.CONTINUE

    override fun addArguments(parser: Any) {
        TODO("添加verify命令的所有参数")
    }

    override fun run(ctx: Context, args: Any): Int {
        TODO("实现verify命令的4个步骤工作流")
    }
}