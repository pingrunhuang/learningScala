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


insert into test values ('2011', '111111', '2016/04/01 00:00:00','是','2016-04-18 09:35:01','2017-03-31 23:59:59','无','0.0','0.0','0.0','0.0','0.0','0.0','0.0','0.0','是');



