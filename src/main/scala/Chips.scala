

// Assume that we already have Not and Or
def Not( x:Int ) = 
  if x == 1 then 0 else 1
def Or(x:Int ,y:Int)= 
  if x == 1 || y == 1 then 1 else 0
// Nand : If a=b=1 then out=0 else out=1
def Nand(x:Int,y:Int)= 
  Or( Not(x) , Not(y) )
// equal to &&
def And(x:Int,y:Int)=
  Not(Nand(x,y))
// 
def Eq( x:Int,y:Int,sel:Int)=
  Or(And(x,y) , And(Not(x) ,Not(y)))
def Xor(x:Int,y:Int,sel:Int)=
  Not( Eq(x,y,1))
def Mux(x:Int,y:Int,sel:Int)=
  Or( And(Eq(sel,1,8),x), And(Eq(sel,0,8),y) )

// 2 bit
def Demultiplexor(in:Int ,sel:Int) =
  Array(And(Eq(sel,1,8),in),And(Eq(sel,0,8),in))

// The rules don't allow me to use for so ...
// Not 16 take an array and use not to all of its index then return modified array
def Not16(in :Array[Int])=
  in(0)=Not(in(0))
  in(1)=Not(in(1))
  in(2)=Not(in(2))
  in(3)=Not(in(3))
  in(4)=Not(in(4))
  in(5)=Not(in(5))
  in(6)=Not(in(6))
  in(7)=Not(in(7))
  in(8)=Not(in(8))
  in(9)=Not(in(9))
  in(10)=Not(in(10))
  in(11)=Not(in(11))
  in(12)=Not(in(12))
  in(13)=Not(in(13))
  in(14)=Not(in(14))
  in(15)=Not(in(15))
  in
// SHould I use var?
def Or16(a:Array[Int] , b:Array[Int]) =
  var r=a
  r(0)=Or(a(0),b(0))
  r(1)=Or(a(1),b(1))
  r(2)=Or(a(2),b(2))
  r(3)=Or(a(3),b(3))
  r(4)=Or(a(4),b(4))
  r(5)=Or(a(5),b(5))
  r(6)=Or(a(6),b(6))
  r(7)=Or(a(7),b(7))
  r(8)=Or(a(8),b(8))
  r(9)=Or(a(9),b(9))
  r(10)=Or(a(10),b(10))
  r(11)=Or(a(11),b(11))
  r(12)=Or(a(12),b(12))
  r(13)=Or(a(13),b(13))
  r(14)=Or(a(14),b(14))
  r(15)=Or(a(15),b(15))
  r

def And16(a:Array[Int],b:Array[Int])=
  Not16(Or16(Not16(a),Not16(b)))
// duuno how to make this less dump , the func Mux have to run too many time
def Mux16(a:Array[Int],b:Array[Int],sel:Int)=
  var r=a
  r(0)=Mux(a(0),b(0),sel)
  r(1)=Mux(a(1),b(1),sel)
  r(2)=Mux(a(2),b(2),sel)
  r(3)=Mux(a(3),b(3),sel)
  r(4)=Mux(a(4),b(4),sel)
  r(5)=Mux(a(5),b(5),sel)
  r(6)=Mux(a(6),b(6),sel)
  r(7)=Mux(a(7),b(7),sel)
  r(8)=Mux(a(8),b(8),sel)
  r(9)=Mux(a(9),b(9),sel)
  r(10)=Mux(a(10),b(10),sel)
  r(11)=Mux(a(11),b(11),sel)
  r(12)=Mux(a(12),b(12),sel)
  r(13)=Mux(a(13),b(13),sel)
  r(14)=Mux(a(14),b(14),sel)
  r(15)=Mux(a(15),b(15),sel)
  r
//check a 7 first if a 7 true return true without having to do other Or
def Or8way(a:Array[Int])=
  Or(a(7),Or(a(6),Or(a(5),Or(a(4),Or(a(3),Or(a(2),Or(a(1),a(0))))))))

/*x2 mux 16 */
def Mux16Way4(a:Array[Int],b:Array[Int],c:Array[Int],d:Array[Int],sel:Array[Int])=
  Mux16( Mux16( a , b , Eq(sel(0),sel(1),8) )  ,Mux16( a , b , Xor(sel(0),sel(1),8) ), Eq( sel(0) ,0 ,8) )            
