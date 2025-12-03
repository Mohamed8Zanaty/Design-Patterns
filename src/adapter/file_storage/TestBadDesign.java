package adapter.file_storage;

import adapter.file_storage.bad_design.FileService;

public class TestBadDesign {
    static void main() {
        FileService service = new FileService();

        byte[] data = "hello world".getBytes();
        // Save locally
        String locPath = service.saveFile("local", data, "greeting.txt");
        System.out.println("Local saved at: " + locPath);

        // Save to S3
        String s3Url = service.saveFile("s3", data, "greeting.txt");
        System.out.println("S3 saved at: " + s3Url);

        // Delete both
        service.deleteFile("local", locPath);
        service.deleteFile("s3", s3Url);
    }
}
