import org.scalajs.core.tools.linker.ModuleInitializer

scalaJSModuleKind := ModuleKind.CommonJSModule

enablePlugins(ScalaJSPlugin)

name := "risc-emulator"

version := "0.1"

scalaVersion := "2.12.5"

scalaJSUseMainModuleInitializer := true

mainClass in Compile := Some("ui.UiApp")
