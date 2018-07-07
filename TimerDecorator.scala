object Timer {
    // T is a type parameter, func is a value parameter
    // the count method takes in one function literal with return type as T
    def count[T](func: => T):T= {
        val start = System.currentTimeMillis()
        val result = func
        val end = System.currentTimeMillis()
        println("Elapsed time: " + (end-start) +"ms")
        result
    }
}