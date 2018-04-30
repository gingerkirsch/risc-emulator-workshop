package risc

sealed trait Instruction {

  protected[risc] def command(address:Int): Unit


  def execute(address: Int): Unit = {
    if (address < Processor.memorySize) {
      command(address)
    } else {
      Processor.error = OutOfMemory
    }
  }

  def moveInstructionPointer(): Unit = {
    if ((Processor.memory(Processor.instructionPointer) / 100) != 43 &&
      Processor.instructionPointer < Processor.memorySize) {
      Processor.instructionPointer = Processor.instructionPointer + 1
      println(Executor.getDump)
      println(Executor.getOutput)
      Executor.execute()
    }

  }
}

object Empty extends Instruction {
  override def command(address: Int): Unit = ???
}

object Read extends Instruction {
  override def command(address: Int): Unit = ???
}

object Write extends Instruction {
  override def command(address: Int): Unit = ???
}

object Load extends Instruction {
  override def command(address: Int): Unit = ???
}

object Store extends Instruction {
  override def command(address: Int): Unit = ???
}

object Add extends Instruction {
  override def command(address: Int): Unit = ???
}

object Sub extends Instruction {
  override def command(address: Int): Unit = ???
}

object Div extends Instruction {
  override def command(address: Int): Unit = ???
}

object Mul extends Instruction {
  override def command(address: Int): Unit = ???
}

object Go extends Instruction {
  override def command(address: Int): Unit = ???
}

object GoNeg extends Instruction {
  override def command(address: Int): Unit = ???
}


object GoZero extends Instruction {
  override def command(address: Int): Unit = ???
}

object Halt extends Instruction {
  override def command(address: Int): Unit = ()
}
