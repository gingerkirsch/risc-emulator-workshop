package risc

import java.io.{File, PrintWriter}

import scala.io.Source

trait IO {
  def read(path: String): Array[Int]
  def write(path: String, program: Array[Int]): Unit
}

object IO {
  def read(path: String): Array[Int] = {
    val lines = Source.fromFile(path,"utf-8").getLines().toArray
    val program = Array.ofDim[Int](lines.length)
    for (i <- program.indices) {
      println(lines(i))
      program(i) = lines(i).toInt
    }
    program
  }

  def write(path: String, program: Array[Int]): Unit = {
    val printWriter = new PrintWriter(new File(path))
    for (i <- program.indices) {
      printWriter.print(program(i))
      printWriter.print("\n")
    }
    printWriter.close()
  }

}
