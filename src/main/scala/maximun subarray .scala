// brute force of maxSubArray
def maxSubArray(A:Array[Int]) =
    var result=Array(0,0,-1000)
    for i <- 0 until A.length do
        var sum = 0
        var last=i
        var pre = -1000
        for n <- i until A.length do
            sum = sum +A(n)
            if  sum > pre then 
                pre = sum
                last=n
        if result(2) < sum then result=Array(i+1,last+1,pre)
    result.mkString(" ")
end maxSubArray

def maxSubArray_DAC(A:Array[Int])= ???
