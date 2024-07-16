object Q3 extends App {
    def finonacciSeries(num: Int): List[Int] = {
        if(num == 1) {
            List(0)
        }
        else if(num == 2) {
            List(0, 1)
        }
        else {
            val list = finonacciSeries(num - 1)
            list :+ (list(num - 2) + list(num - 3))
        }
    }

    val num = scala.io.StdIn.readLine("Enter number: ").toInt

    println("Finonacci Series of first " + num + " numbers: ")
    println(finonacciSeries(num).mkString(" "))
}
