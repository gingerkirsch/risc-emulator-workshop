package risc

sealed trait Error {
  def message: String
}

case object NoErrors extends Error {
  def message = "Program is completed successfully."
}

case object UnknownInstruction extends Error {
  def message = "Unknown instruction"
}

case object DivisionByZero extends Error {
  def message = "Divizion by zero"
}

case object StackOverflow extends Error {
  def message = "Stack overflow"
}

case object OutOfMemory extends Error {
  def message = "Out of memory"
}

case object UnknownError extends Error {
  def message = "Unknown error"
}
