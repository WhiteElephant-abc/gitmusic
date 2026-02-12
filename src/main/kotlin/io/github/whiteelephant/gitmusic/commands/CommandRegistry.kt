package io.github.whiteelephant.gitmusic.commands

/**
 * 命令注册表 - 管理和发现所有可用命令
 *
 * 职责：
 * 1. 自动发现commands/目录下的所有命令实现
 * 2. 注册命令名称、别名到命令对象的映射
 * 3. 提供按名称查找命令的方法
 * 4. 生成帮助文本和命令列表
 *
 * 设计要点：
 * - 使用ServiceLoader或反射自动发现命令类
 * - 支持命令别名（如push->sync --direction=upload，pull->sync --direction=download）
 * - 在CLI启动时加载所有命令，构建ArgumentParser子命令结构
 * - 支持按需加载命令，避免初始化所有命令的开销
 *
 * TODO: 实现discoverCommands方法（扫描commands包，查找实现Command接口的类）
 * TODO: 实现registerCommand方法（添加命令和别名到内部映射）
 * TODO: 实现getCommand方法（按名称或别名查找）
 * TODO: 实现所有命令的列表（用于生成帮助）
 * TODO: 实现别名解析（将别名映射到实际命令和参数）
 * TODO: 考虑使用Kotlin的ServiceLoader机制或手动注册
 * TODO: 提供命令验证（确保没有名称冲突、别名唯一）
 */

object CommandRegistry {
    private val commands: MutableMap<String, Command> = mutableMapOf()
    private val aliases: MutableMap<String, String> = mutableMapOf() // 别名 -> 命令名

    // TODO: 实现初始化方法（自动发现命令）
    fun init() {
        TODO("实现命令自动发现和注册")
    }

    // TODO: 实现命令注册
    fun register(command: Command) {
        TODO("注册命令及其别名")
    }

    // TODO: 实现按名称查找（支持别名）
    fun get(name: String): Command? {
        TODO("按名称或别名查找命令")
    }

    // TODO: 实现所有命令列表
    fun getAll(): List<Command> {
        TODO("返回所有已注册命令")
    }

    // TODO: 实现帮助文本生成
    fun generateHelp(): String {
        TODO("生成命令列表和描述")
    }
}