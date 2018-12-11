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
