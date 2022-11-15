import scala.collection.mutable.Map

def liss(list:Vector[Int])=
    // cache = list drop i begin 
    var cache:Array[Vector[Int]] = Vector.tabulate(list.length+1)(x => list.drop(list.length-x-1)).toArray
    
    def fillcache =
        for i<- 1 until cache.length do
            var helper = cache.take(i).filter(x=> x.head > cache(i).head)
            if helper.nonEmpty then cache(i)=cache(i).take(1)++ helper.maxBy(_.length) else cache(i)=cache(i).take(1)
    fillcache
    cache.maxBy(_.length)
