package adapter.file_storage;

import adapter.file_storage.good_design.FileService;
import adapter.file_storage.good_design.Storage;
import adapter.file_storage.good_design.StorageFactory;

public class TestGoodDesign {
    static void main() {
        Storage localStorage = StorageFactory.create("local");
        FileService service = new FileService(localStorage);

        byte[] data = "hello world".getBytes();

        String locId = service.saveFile(data, "greeting.txt");
        System.out.println("Local saved id: " + locId);

        System.out.println("\n--- switch to S3 ---\n");
        Storage s3Storage = StorageFactory.create("s3");
        service.setStorage(s3Storage);

        String s3Id = service.saveFile(data, "greeting.txt");
        System.out.println("S3 saved id: " + s3Id);

        // Deletions use the normalized identifier returned by saveFile
        service.deleteFile(s3Id);
        service.setStorage(localStorage);
        service.deleteFile(locId);
    }
}
