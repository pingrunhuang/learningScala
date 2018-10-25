import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

/*
if there is return or throw in finally block, it will overrule any previous return 
therefore, finally is used for closing resources
*/
try
    val f = new FileReader("input.txt")
catch {
    case ex: FileNotFoundException => // hanle missing file
    case ex: IOException => // handle other I/O error
} finally {
    f.close()
}



