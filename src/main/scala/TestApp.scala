import risc.{Executor, IO, Processor}


object TestApp extends App {

  var code = IO.read("./src/main/Resources/listings/sumOf2integers.txt")
  Processor.load(code)
  println("Program is loaded")
  Executor.execute()

}
