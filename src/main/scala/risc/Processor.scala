package risc

trait Processor {
  def instructionPointer: Int
  def accumulator: Int
  def error: risc.Error
  def memorySize: Int
  def memory: Array[Int]
  def instructionSet: Map[Int, Instruction]
  def errorSet: Map[Int, risc.Error]
}

object Processor {
  var instructionPointer = 0
  var accumulatorRegister = 0
  var error: risc.Error = NoErrors
  val memorySize = 100
  var memory = Array.ofDim[Int](memorySize)
  val MaxVal = 9999
  val MinVal = -9999
  val instructionSet = Map(
    0 -> Empty,
    10 -> Read,
    11 -> Write,
    20 -> Load,
    21 -> Store,
    30 -> Add,
    31 -> Sub,
    32 -> Div,
    33 -> Mul,
    40 -> Go,
    41 -> GoNeg,
    42 -> GoZero,
    43 -> Halt,
  )

  def load(program: Array[Int]): Unit = {
    if (program.length >= Processor.MaxVal)
      Processor.error = OutOfMemory
    else {
      for (i <- memory.indices){
        if (i < program.size){
          memory.update(i, program(i))
        } else {
          memory.update(i, 0)
        }
      }
      Processor.instructionPointer = 0
      Processor.accumulatorRegister = 0
    }
  }

  def executeInstruction(value: Int): Unit = {
    value match {
      case n if n < 0 || n > Processor.MaxVal =>
        Processor.error = UnknownError
      case n =>
        val command = n / 100
        val operand = n % 100
        instructionSet.get(command).map { instruction =>
          instruction.execute(operand)
        }.getOrElse {
          error = UnknownInstruction
        }
    }
  }
}

