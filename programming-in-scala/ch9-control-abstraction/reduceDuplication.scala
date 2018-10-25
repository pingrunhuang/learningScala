// initial task: find all files that ends with certain pattern

object FileMatcher {
    private def lsFiles = (new java.io.File(".")).listFiles

    def filesEnding(query: String){
        for(file <- lsFiles; if file.getName.endsWith(query))
            yield file
    }
}


// later if we want to add more features like pattern matching for the matcher class
object FileMatcher {
    private def lsFiles = (new java.io.File(".")).listFiles

    def filesEnding(query: String) {
        for(file <- lsFiles; if file.getName.endsWith(query))
            yield file
    }

    def filesRegex(query: String) {
        for(file<-lsFiles; if file.getName.matches(query))
            yield file
    }
}

// issue: the for loop is obviously duplicated
object FileMatcher {
    private def lsFiles = (new java.io.File(".")).listFiles

    // this method take in two parameters: query for matching and a function that take in a string and return a boolean
    def filesMatching(query: String, matcher: (String => Boolean)) {
        for (file<-lsFiles; if matcher(file))
            yield file
    }

    def filesEnding(query: String): Boolean {
        filesMatching(query, (fileName:String) => fileName.endsWith(query))
    }

    def filesRegex(query: String) {
        filesMatching(query, (fileName:String) => fileName.matches(query))
    }
}

// check if there are negatives inside
def containNeg(arr: List):Boolean{
    var exists = false
    for (n <- nums){
        if (n<0){
            exists = true
        }
    }
    exists
}
// scala way
def containNeg2(arr:List):Boolean{
    arr.exists(_<0)
}
