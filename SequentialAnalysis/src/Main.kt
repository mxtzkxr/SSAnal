import calculation.SequentialAnalysis
import calculation.args.InitArgs

fun main(){
    val args = InitArgs(2,-0.3,0.4,0.1,110.0,100.0,10.0)
    val s = SequentialAnalysis(args)
    println(s.Cn())
}