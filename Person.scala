case class Person(name: String, age: Int)
// companion object "Singleton - static variables and methods go here"
object Person {
  given personDefaultOrdering: Ordering[Person] = Ordering.fromLessThan(_.age > _.age)
}

object PersonNameOrdering {
  given personNameOrdering: Ordering[Person] = Ordering.fromLessThan[Person]{ (personA, personB) =>
    personA.name.compareTo(personB.name) < 0
  }
}

@main
def main() = {
    val persons = List(Person("Jon", 24), Person("Akhil", 16), Person("Nikita", 34))
    // import PersonNameOrdering.given // TODO: Uncomment this
    println(persons.sorted)
}
