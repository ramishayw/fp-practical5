object Q1 extends App {
    def getProductList(): List[String] = {
        var listItems = List[String]()

        println("Enter list items, type done when done:")
        while(true) {
            val item = scala.io.StdIn.readLine().trim
            if(item == "done") {
                return listItems.filter(_.nonEmpty)
            }
            else {
                listItems = listItems :+ item.replaceAll("\\s+", " ")
            }
        }
        listItems 
    }

    def printProductList(numberOfListItems: Int, listItems: List[String]): Unit = {
        println("List items: ")

        for(i <- 0 until numberOfListItems) {
            println(s"${i + 1}. ${listItems(i)}")
        }
    }

    def getTotalProducts(listItems: List[String]): Int = {
        var count = 0
        for(item <- listItems) {
            count = count + 1
        }
        
        count
    }

    val list = getProductList()
    val num = getTotalProducts(list) 
    printProductList(num, list) 
    println(s"Total number of products: $num")
}