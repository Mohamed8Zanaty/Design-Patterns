package adapter.file_storage.good_design;

import adapter.file_storage.providor.S3SDK;

public class S3StorageAdapter implements Storage{
    private final S3SDK sdk;
    private final String bucket;

    public S3StorageAdapter(S3SDK sdk, String bucket) {
        this.sdk = sdk;
        this.bucket = bucket;
    }

    @Override
    public String save(byte[] data, String filename) {
        // return a normalized s3://bucket/key identifier
        String url = sdk.upload(data, bucket, filename);
        // normalize to "s3://bucket/key" so delete can parse easily
        return "s3://" + bucket + "/" + filename;
    }

    @Override
    public boolean delete(String identifier) {
        // identifier expected to be "s3://bucket/key"
        if (!identifier.startsWith("s3://")) {
            System.err.println("[S3StorageAdapter] Bad identifier: " + identifier);
            return false;
        }
        String remainder = identifier.substring("s3://".length());
        int slash = remainder.indexOf('/');
        if (slash < 0) {
            System.err.println("[S3StorageAdapter] Bad identifier (no key): " + identifier);
            return false;
        }
        String bucketFromId = remainder.substring(0, slash);
        String key = remainder.substring(slash + 1);
        sdk.deleteObject(bucketFromId, key);
        return true;
    }
}
