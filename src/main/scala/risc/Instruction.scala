package risc

import ui.Helper

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
      Helper.addDebug(Executor.getDump)
      Helper.addOutput(Executor.getOutput)
      Executor.execute()
    }

  }
}

object Empty extends Instruction {
  override def command(address: Int): Unit = moveInstructionPointer
}

object Read extends Instruction {
  override def command(address: Int): Unit = {
    /* Implement 2 steps for read */
  }

  def processResponse(address: Int, value: Int) = ???
}

object Write extends Instruction {
  override def command(address: Int): Unit = {
    Executor.write(Processor.memory(address))
    moveInstructionPointer
  }
}

object Load extends Instruction {
  override def command(address: Int): Unit = {
    Processor.accumulatorRegister = Processor.memory(address)
    moveInstructionPointer
  }
}

object Store extends Instruction {
  override def command(address: Int): Unit  = {
    Processor.memory(address) = Processor.accumulatorRegister
    moveInstructionPointer
  }
}

object Add extends Instruction {
  override def command(address: Int): Unit = {
    Processor.accumulatorRegister = Processor.accumulatorRegister + Processor.memory(address)
    moveInstructionPointer
  }
}

object Sub extends Instruction {
  override def command(address: Int): Unit = {
    Processor.accumulatorRegister = Processor.accumulatorRegister - Processor.memory(address)
    moveInstructionPointer
  }
}

object Div extends Instruction {
  override def command(address: Int): Unit = {
    if (Processor.memory(address) == 0) {
      Processor.error = DivisionByZero
    } else {
      Processor.accumulatorRegister = Processor.accumulatorRegister / Processor.memory(address)
      moveInstructionPointer
    }
  }
}

object Mul extends Instruction {
  override def command(address: Int): Unit = {
    Processor.accumulatorRegister = Processor.accumulatorRegister * Processor.memory(address)
    if (Processor.accumulatorRegister > Processor.MaxVal || Processor.accumulatorRegister < Processor.MinVal) {
      Processor.error = StackOverflow
    } else moveInstructionPointer
  }
}

object Go extends Instruction {
  override def command(address: Int): Unit = {
    Processor.instructionPointer = address
  }
}

object GoNeg extends Instruction {
  override def command(address: Int): Unit = {
    if (Processor.accumulatorRegister < 0) Go.execute(address)
  }
}


object GoZero extends Instruction {
  override def command(address: Int): Unit = {
    if (Processor.accumulatorRegister == 0) Go.execute(address)
  }
}

object Halt extends Instruction {
  override def command(address: Int): Unit = ()
}
