object AplusBFunc {
  case class IO[A](unsafeRun: () => A){
    def map[B](f: A => B): IO[B] = IO(() => f(unsafeRun()))
    def flatMap[B](f: A => IO[B]): IO[B] = IO(() => f(unsafeRun()).unsafeRun())
  }
  val program: IO[Unit] =  for {
    line <- IO(scala.io.StdIn.readLine)
    sum = line.split(" ").map(_.toInt).sum
    _ <- IO(() => println(sum))
  } yield ()

  def main(args: Array[String]): Unit = program.unsafeRun()
}
