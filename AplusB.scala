object AplusB {
  def sumNos: Unit = {
    println(scala.io.StdIn.readLine().split(" ").map(_.toInt).sum)
  }
  def main(args: Array[String]): Unit = {
    sumNos
  }
}
