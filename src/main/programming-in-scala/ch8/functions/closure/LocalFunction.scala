package ch8.functions.closure

object LocalFunction extends App {
    
    /**
    *@param filename the path of the target file 
    *@param width the length of the line that you want to process
    * this is an example of local functions which define a method inside a method
    **/
    def processFile(filename: String, width: Int){
        def processLine(filename:String, width:Int, line:String){
            if (line.length > width){
                println(filename + ": " + line)
            }
        }
//        val source = Source.from
    }
}