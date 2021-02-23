# ProgramInitiator
A Minecraft server plugin allows you to execute external programs.

一个 MC 服务器插件，通过它可以调用系统控制台指令和外部程序。

## 指令
* `/pinit command <command>`：在当前服务器目录下执行控制台命令。
* `/pinit execute <program> [arguments]`：执行位于插件数据文件夹 `plugins/ProgramInitiator` 内的一个程序。

## 权限
* `pinit.command`：使用 `/pinit command <command>` 指令的权限。
* `pinit.execute`：使用 `/pinit execute <program> [arguments]` 指令的权限。

## 建议
1. 请不要随意将 pinit 的权限给予普通玩家。
1. 配合插件 [CustomCommands](https://github.com/Chuanwise/CustomCommands) 使用效果更佳。

## 更新日志
### 1.0
1. 发布于2021年2月23日。