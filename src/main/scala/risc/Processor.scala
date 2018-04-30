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

  def load(program: Array[Int]): Unit = ???

  def executeInstruction(value: Int): Unit = ???
}

