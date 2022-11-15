// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {
  test("example test that succeeds") {
    var obtained = 1
    var result="A"
    var expected = 1
    
    def testChip(test : Vector[(Int,Int)], func : (Int,Int,Int) =>Int , expectvalue:Int) = 
      
      obtained = test.map( (x,y) => func(x,y,1)).count(_ == 1)
      expected = expectvalue
      result = test.map( (x,y) => func(x,y,1)).mkString(" " )
    end testChip
    
    
    println(maxSubArray(const.stock))
  }
}
