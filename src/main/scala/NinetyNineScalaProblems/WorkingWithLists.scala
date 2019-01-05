package NinetyNineScalaProblems

import scala.collection.mutable.ListBuffer

/**
  * @author Frank Huang (runping@shanshu.ai)
  * @date 2019/01/05 
  */
object WorkingWithLists extends App {

  val list = List(1, 1, 2, 3, 5, 8, 1)
  println(list)
  println("1. Find the last element of a list.")
  println(list.last)

  println("2. Find the last but one element of a list.")
  println(list.init.last)

  println("3. Find the Kth element of a list.")
  val k = 2
  println(list(2))

  println("4. Find the number of elements of a list.")
  println(list.length)

  println("5. Reverse a list.")
  println(list.reverse)

  println("6. Find out whether a list is a palindrome.")
  def isPalindrome(list: List[Int]):Boolean={
    var left = 0
    var right = list.length-1
    while (left<=right){
      if (list(left)!=list(right))
        return false
      left+=1
      right-=1
    }
    true
  }
  println(isPalindrome(list))

  println("7. Flatten a nested list structure.")
  /**
    * flatmap first map the collections into nested collection and then flatten it
    * Check out blog below:
    * https://www.credera.com/blog/technology-insights/mastering-scala-understanding-map-and-flatmap/
    * dfs*/
  val nested_list = List(List(1, 1), 2, List(3, List(5, 8)))
  def flatten(nested:List[Any]):List[Any]=nested.flatMap({
    case list:List[_]=>flatten(list)
    case e => List(e)
  })
  println(flatten(nested_list).mkString(","))

  println("8. Eliminate consecutive duplicates of list elements.")
  /** magic of fold: https://commitlogs.com/2016/09/10/scala-fold-foldleft-and-foldright/
    * */
  val duplicate_list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  def compressRecursive[T](list: List[T]):List[T]= list match {
    case Nil => Nil
    case h :: tail => h :: compressRecursive(tail.dropWhile(_==h))
  }
  println(compressRecursive(duplicate_list).mkString(","))
  def compressFunctional[T](list: List[T]):List[T]={
    /*foldRight will cause stack overflow because fold is actually like a stack*/
    list.foldLeft(List[T]()) { (accumulated_val, cur_val) =>
      if (accumulated_val.isEmpty || accumulated_val.head != cur_val) cur_val :: accumulated_val
      else accumulated_val
    }.reverse
  }
  println(compressFunctional(duplicate_list).mkString(","))
  def compressFunctional2[T](list: List[T]):List[T]={
    /*this explain what is going on from the prev method*/
    val result = ListBuffer[T]()
    for (ele<-list){
      if (result.isEmpty || ele != result.last) result.append(ele)
    }
    result.toList
  }
  println(compressFunctional2(duplicate_list).mkString(","))


  println("9. Pack consecutive duplicates of list elements into sublists.")
  def packFunctional[T](list: List[T]):List[List[T]]={
    val result = ListBuffer[ListBuffer[T]]()
    for (ele<-list){
      if (result.isEmpty || result.last.head!=ele) result.append(ListBuffer[T](ele))
      else result.last.append(ele)
    }
    result.map(_.toList).toList
  }
  println(packFunctional(duplicate_list).mkString(","))
  def packRecursive[T](list: List[T]):List[List[T]]={
    if (list.isEmpty) List(List())
    else{
      val (packed, left) = list.span(_ == list.head)
      /*or use left == Nil*/
      if (left.isEmpty) List(packed)
      else packed :: packRecursive(left)
    }
  }
  println(packRecursive(duplicate_list).mkString(","))


}
