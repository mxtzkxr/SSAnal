package calculation

import calculation.args.InitArgs
import calculation.utils.comb
import kotlin.math.max
import kotlin.math.pow

data class SData(val value: Double, val isStonks: Boolean)

class SequentialAnalysis(private val args: InitArgs) {

    private val AllS = HashMap<Int, SData>()

    init {
        /*for (i in 0..args.N) {
            println("Упало (0), Поднялось (1)?")
            val answer: Int? = readLine()?.toInt()

        }*/
        AllS[0]=SData(args.startS,true)
    }


    private fun S(n: Int, isStonks: Boolean): Double {
        var ro = 0.0
        if (isStonks) {
            ro = args.b
        } else {
            ro = args.a
        }
        if (AllS.containsKey(n)) {
            val elem = AllS[n]
        }
        return ro
    }

    fun putInAllS(n: Int, isStonks: Boolean) {
        var ro = 0.0
        if (isStonks) {
            ro = args.b
        } else {
            ro = args.a
        }
        if (AllS.containsKey(n - 1)) {
            AllS[n] = SData(AllS[n - 1]!!.value * (1 + ro), isStonks)
        }
    }

    fun F(n: Int, x: Double, p: Double): Double {
        var result = 0.0
        for (k in 0..n) {
            result += max(x * (1 + args.b).pow(k) * (1 + args.a).pow(n - k) - args.T, 0.0) * comb(n, k) * p.pow(k) * (1 - p).pow(n - k)
        }
        return result
    }

    fun Cn(): Double = (1 + args.r).pow(-args.N) * F(args.N, args.startS, P())

    private fun P(): Double = (args.r - args.a) / (args.b - args.a)

    private fun B(n: Int):Double{
        var result=args.startB
        for (i in 1..n){
            result*=(1+args.r)
        }
        return result
    }

    fun gammaN(n: Int, isStonks: Boolean): Double {
        var result = 0.0
        if (AllS.containsKey(n-1)) {
            var r = 0.0
            if (isStonks) {
                r = args.b
            } else {
                r = args.a
            }
            result += (1 + r).pow(n - args.N) * (F(args.N - n, AllS[n-1]!!.value*(1+args.b),P())-F(args.N-n,AllS[n-1]!!.value*(1+args.a),P()))/(AllS[n-1]!!.value*(args.b-args.a))

        }
        return result
    }

    fun betaN(n: Int, isStonks: Boolean): Double {
        var result = 0.0
        if (AllS.containsKey(n-1)) {
            var r = 0.0
            if (isStonks) {
                r = args.b
            } else {
                r = args.a
            }
            result += (F(args.N-n+1,AllS[n-1]!!.value,P()))/(B(n-1))-(1 + r).pow(n - args.N) * (F(args.N - n, AllS[n-1]!!.value*(1+args.b),P())-F(args.N-n,AllS[n-1]!!.value*(1+args.a),P()))/(B(n-1)*(args.b-args.a))

        }
        return result
    }

}