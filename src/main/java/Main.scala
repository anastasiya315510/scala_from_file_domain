import scala.io.Source

/*
playing with domain  if stream contains the same name second level printing just second level,
if its just uniq name second level printing everything
 */

object Main extends App{

  Source
    .fromFile("src/main/resources/domen.txt")
    .getLines()
    .flatMap(_.split(" "))
    .toStream
    .map({
      line =>
        val lineSplit = line.split("[.]")
        (line, lineSplit(0) + "." + lineSplit(1))
    })
    .toMap
    .groupBy(_._2)
    .foreach({v=>
      if(v._2.size>1)println(v._1+".")
      else v._2.keys.foreach(println)
    })

}
