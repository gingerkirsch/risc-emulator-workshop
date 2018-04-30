package risc

import ui.Helper

trait Executor {
  def output: StringBuilder
  def dump: StringBuilder
  def debugMode: Boolean
}

object Executor {
  var output = new StringBuilder()
  var dump = new StringBuilder()

  def execute(): Unit = Processor.executeInstruction(Processor.memory(Processor.instructionPointer))


  def checkErrors: StringBuilder = Processor.error match {
    case NoErrors => output.append("Program is completed successfully.")
    case e: Error => output.append(s"Error: ${e.message}\n")
  }

  def read(address: Int): Unit = {
    Helper.showReadValueForAddress(address)
  }

  def jsCallBack(address: Int, value: Int): Unit = {
    Read.processResponse(address, value)
  }

  def write(value: Int): StringBuilder = output.append(s"Result: $value\n")

  def getDump: String = {
    dump.clear()
    dump.append(s"Accumulator: ${Processor.accumulatorRegister}\n")
    dump.append(s"Instruction pointer: ${Processor.instructionPointer}\n")
    dump.append(s"Memory size: ${Processor.memorySize}\n")

    for (i <- Processor.memory.indices)
      dump.append(s"{${"%02d".format(i)}}:{${"%04d".format(Processor.memory(i))}}${
        if ((i + 1) % 10 == 0) "\n"
        else "\t"
      }")

    dump.toString
  }

  def getOutput: String = output.toString
}
