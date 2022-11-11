// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {
  test("example test that succeeds") {
    val twobit=Vector((0,0),(1,0),(0,1),(1,1))
    var obtained = 0
    var result="A"
    var expected = 1
    
    def testFunc(test : Vector[(Int,Int)], func : (Int,Int,Int) =>Int , expectvalue:Int) = 
      
      obtained = test.map( (x,y) => func(x,y,1)).count(_ == 1)
      expected = expectvalue
      result = test.map( (x,y) => func(x,y,1)).mkString(" " )
    end testFunc

    testFunc(twobit , Mux , 2 )
    println(result)
    assertEquals(obtained, expected)
  }
}
