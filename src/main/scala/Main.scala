@main def hello: Unit = 
  val twobit=Vector((1,0),(0,0),(1,1),(0,1))
  println(twobit.map((x,y)=>And(x,y)).mkString("  "))

// Assume that we already have Not and Or
def Not( x:Int ) = 
  if x == 1 then 0 else 1
def Or(x:Int ,y:Int)= 
  if x == 1 || y == 1 then 1 else 0

// Nand return 1 If a=b=1 then out=0 else out=1
def Nand(x:Int,y:Int)= 
  Or( Not(x) , Not(y) )

// equal to &&
def And(x:Int,y:Int)=
  Not(Nand(x,y))

def Xor( x:Int,y:Int,sel:Int)=
  Not( Or(And(x,y) , And(Not(x) ,Not(y))))

def Eq(x:Int,y:Int,sel:Int)=
  Not( Xor(x,y,1))

def Mux(x:Int,y:Int,sel:Int)=
  Or( And(Eq(sel,1,8),x), And(Eq(sel,0,8),y) )

  