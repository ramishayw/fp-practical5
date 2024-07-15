object Q3 extends App {
    def finonacciSeries(num: Int): List[Int] = {
        if(num == 0) {
            List(0)
        }
        else if(num == 1) {
            List(0, 1)
        }
        else {
            val list = finonacciSeries(num - 1)
            list :+ (list(num - 1) + list(num - 2))
        }
    }

    val num = scala.io.StdIn.readLine("Enter number: ").toInt

    val number = num + 1
    println("Finonacci Series of first " + number + " numbers: ")
    println(finonacciSeries(num).mkString(" "))
}