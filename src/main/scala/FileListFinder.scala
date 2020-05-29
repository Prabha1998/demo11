object FileListFinder {
  def main(args: Array[String]) {
    val filePaths=service.SourceFinderService.matchSourceAndGetPaths("gs://dirname")
    val borfPaths=service.PathSegregatorService.segregate(filePaths,".*borf.*")
    val sarawakPaths=service.PathSegregatorService.segregate(filePaths,".*sarawak.*")
  }
}
