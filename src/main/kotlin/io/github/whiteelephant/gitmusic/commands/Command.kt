package io.github.whiteelephant.gitmusic.commands

import io.github.whiteelephant.gitmusic.Context

/**
 * 命令基类 - 所有命令必须实现的接口
 *
 * 职责：
 * 1. 声明命令名称、描述、别名
 * 2. 定义参数解析规则（使用kotlinx-cli）
 * 3. 实现运行逻辑（调用核心库步骤函数）
 * 4. 处理命令级错误策略（on_error）
 * 5. 发射事件（phase_start、batch_progress、item_event、result/error）
 *
 * 设计要点：
 * - 命令是薄适配器：只做参数映射和步骤组合，不实现业务逻辑
 * - 业务逻辑由core/模块提供，命令调用core函数
 * - 关键点必须发射事件：开始阶段、批量进度、单项完成、错误、结果
 * - 仅在必要交互点检查ctx.mode（如preview确认），避免每处渲染前判断
 * - 锁策略：需要写metadata时获取锁，在finally块释放
 *
 * TODO: 定义Command接口或抽象类，包含name、description、onErrorStrategy等属性
 * TODO: 定义addArguments方法（接收ArgumentParser.Builder）
 * TODO: 定义run方法（接收Context和ParsedArguments）
 * TODO: 定义常见错误策略枚举：STOP（遇错停止）、CONTINUE（记录并继续）、NOTIFY（继续并在summary报告）
 * TODO: 提供辅助方法：emitPhaseStart、emitBatchProgress、emitItemEvent、emitError、emitResult
 * TODO: 实现锁获取/释放的辅助方法（使用Context.locking）
 * TODO: 提供交互确认的辅助方法（检查ctx.mode，interactive时提示用户，log-only时按配置处理）
 */

sealed class ErrorStrategy {
    object STOP : ErrorStrategy()
    object CONTINUE : ErrorStrategy()
    object NOTIFY : ErrorStrategy()
}

interface Command {
    val name: String
    val description: String
    val aliases: List<String>
    val errorStrategy: ErrorStrategy

    // TODO: 实现addArguments方法
    fun addArguments(parser: Any /* kotlinx.cli.ArgumentParser.Builder */)

    // TODO: 实现run方法
    fun run(ctx: Context, args: Any /* kotlinx.cli.ParsedArguments */): Int
}