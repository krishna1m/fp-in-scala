extension [K, V](m: Map[K, V])
    def toCustomString: String = {
      val mapElementsToString = m.map { case k -> v =>
        s""""$k": "$v"""".stripMargin
      }
      mapElementsToString.mkString("{", ",", "}")
    }

@main
def main() = {
  val fruitAttributes = Map("fruit" -> "apple", "colour" -> "red", "taste" -> "sweet")
  println(fruitAttributes.toCustomString)
}
