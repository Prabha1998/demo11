package service

object SourceFinderService {

  def matchSourceAndGetPaths(sourcePath:String)=sourcePath match{
    //case source if source.matches("s3://.*") => "aws"
    //case source if source.matches("hdfs://.*") => "hdfs"

    case source if source.matches("gs://.*")=> service.GcsFileListingService.listFilePaths(sourcePath)
    case _ => null
  }

}
