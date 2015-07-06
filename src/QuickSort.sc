def quickSort(list : List[Int]) : List[Int] =
  if(list.isEmpty)
    list
  else
  {
    val(smaller, bigger) = list.tail partition(_ < list.head)
    quickSort(smaller):::list.head::quickSort(bigger)
  }

val numbers = List(3,1,6,2,0,9,6,8,7,5)
quickSort(numbers)