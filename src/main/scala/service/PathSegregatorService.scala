package service

object PathSegregatorService {
  def segregate(filePaths:Iterable[String],pattern:String){
    filePaths.filter(i=>i matches(pattern)).foreach(println)
  }
}
