package io.github.whiteelephant.gitmusic.commands

import io.github.whiteelephant.gitmusic.Context

/**
 * checkout命令 - 从cache检出音频到work，嵌入最新元数据与封面
 *
 * 功能：根据查询条件从metadata筛选条目，从object_store下载音频和封面，嵌入元数据并写回work目录
 *
 * 必需参数：
 * - <query>：搜索关键词（默认在所有字段搜索）
 * - --missing <fields>：按缺失字段过滤
 * - --force 或 -f：强制覆盖work已有文件
 * - --limit <n>：限制处理数量
 * - --search-field <field>：仅在指定字段搜索
 * - --line <n>：按行号过滤输出，短参数 -l
 *
 * 工作流步骤：
 * 1. query_metadata - 根据query/filters返回候选条目
 * 2. conflict_check - 检查work目录冲突；若冲突且无-f，CLI自动连锁调用publish --preview并退出
 * 3. fetch_objects - 从object_store下载audio与cover到临时位置
 * 4. embed_metadata - 将元数据与封面嵌入音频并写回work，写入METADATA_HASH标签
 *
 * 事件输出：
 * - phase_start("query_metadata")
 * - item_event("candidate")
 * - batch_progress（下载进度）
 * - item_event("fetched", "wrote_file")
 * - error（冲突或下载失败）
 * - result/summary
 *
 * 锁策略：通常不需要锁（只读操作），除非需要写work文件（但work目录是用户工作区）
 * 失败策略：冲突时默认退出并提示；下载失败按on_error策略处理
 *
 * TODO: 实现Command接口，设置name="checkout"
 * TODO: 实现addArguments方法，添加所有必需参数
 * TODO: 实现run方法，按4个步骤调用core模块函数
 * TODO: 实现query_metadata步骤（调用core.metadata.query）
 * TODO: 实现conflict_check步骤（检查work目录文件，冲突时调用publish --preview逻辑）
 * TODO: 实现fetch_objects步骤（调用core.object_store.ensureLocal批量下载）
 * TODO: 实现embed_metadata步骤（调用core.audio.embedTagsAndWrite）
 * TODO: 实现METADATA_HASH标签写入
 * TODO: 处理--limit参数限制处理数量
 * TODO: 实现搜索过滤逻辑（--search-field、--missing等）
 * TODO: 实现进度更新和事件发射
 */

class CheckoutCommand : Command {
    override val name: String = "checkout"
    override val description: String = "从cache检出音频到work，嵌入最新元数据与封面"
    override val aliases: List<String> = emptyList()
    override val errorStrategy: ErrorStrategy = ErrorStrategy.STOP

    override fun addArguments(parser: Any) {
        TODO("添加checkout命令的所有参数")
    }

    override fun run(ctx: Context, args: Any): Int {
        TODO("实现checkout命令的4个步骤工作流")
    }
}