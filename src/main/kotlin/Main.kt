package top.whiteelephant.gitmusic
import java.io.File
//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。

data class Context(
    val workDir: File,
    val isVerbose: Boolean
)

sealed class CliEvent {
    data class Progress(val perceent: Int) : CliEvent()

    data class Error(val error: String) : CliEvent()
}