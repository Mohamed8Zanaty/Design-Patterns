package adapter.file_storage.providor;

public class S3SDK {
    public String upload(byte[] bytes, String bucket, String key) {
        String url = "https://s3.amazonaws.com/" + bucket + "/" + key;
        System.out.println("[S3SDK] Uploaded to " + url);
        return url;
    }

    public void deleteObject(String bucket, String key) {
        System.out.println("[S3SDK] Deleted s3://" + bucket + "/" + key);
    }
}
