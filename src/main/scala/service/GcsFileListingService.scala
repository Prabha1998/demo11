package service

//for details refer https://cloud.google.com/storage/docs/listing-objects#code-samples

import com.google.auth.oauth2.GoogleCredentials
import java.io.{File, FileInputStream}
import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions
import scala.collection.JavaConversions._


object GcsFileListingService {
  def listFilePaths(path:String) = {
    val bucketName="sarawaktest"
    val directoryPrefix="test/"
    val credentials = GoogleCredentials.fromStream(new FileInputStream(new File("C:\\Users\\Prabha Rashmi\\IdeaProjects\\demo11\\src\\main\\scala\\service\\credentials.json")))
    val storage = StorageOptions.newBuilder.setCredentials(credentials).build.getService
    val bucket = storage.get(bucketName)
    val files = bucket.list(Storage.BlobListOption.prefix(directoryPrefix))
    val filePaths=for (file <- files.iterateAll)  yield file.getName
    filePaths
  }
}