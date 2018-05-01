package ui

import risc._

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel, JSGlobal}
import scala.util.Try

@JSExportTopLevel("BackendApp")
object UiApp {
  val code = Array.ofDim[Int](100)

  def main(args: Array[String]): Unit = {}

  @JSExport
  def loadProgram(code: js.Array[js.JSNumberOps]): Unit = {
    val ints: Array[Int] = code.map(n => n.toString().toInt).toArray
    Processor.load(ints)
  }

  @JSExport
  def run(): Unit = {
    Executor.execute()
  }

  @JSExport
  def setReadValue(address: Int, value: String): Unit  = {
    val adressInt = address.toInt
    val valueInt = value.toInt
    Executor.jsCallBack(adressInt, valueInt)
  }

  @JSExport
  def showDump(): String = {
    Executor.getDump
  }

}

@js.native
@JSGlobal
object Helper extends js.Object {
  def showReadValueForAddress(address: Int): Unit = js.native

  def addDebug(debugLine: String): Unit = js.native
  def addOutput(debugLine: String): Unit = js.native
}
