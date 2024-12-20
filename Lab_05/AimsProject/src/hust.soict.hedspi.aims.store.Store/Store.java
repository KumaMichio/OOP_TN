package hust.soict.hedspi.aims.store.Store;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Store {

    private ArrayList<Media> itemsInStore;

    public Store() {
        itemsInStore = new ArrayList<>();
    }

    // Check if a Media item exists in the store
    public boolean checkMedia(Media media) {
        return itemsInStore.contains(media);
    }

    // Add a Media item to the store
    public void addMedia(Media media) {
    	if (!checkMedia(media)) {
            itemsInStore.add(media);
            System.out.println(media.getTitle() + " has been added to the store.");
        } else {
            JOptionPane.showMessageDialog(
                null,
                media.getTitle() + " already exists in the store.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // Remove a Media item from the store
    public void removeMedia(Media media) {
        if (checkMedia(media)) {
            itemsInStore.remove(media);
            System.out.println(media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println(media.getTitle() + " is not found in the store.");
        }
    }
    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) { // Duyệt qua danh sách các Media trong Store
            if (media.getTitle().equalsIgnoreCase(title)) { // So sánh tiêu đề, không phân biệt hoa thường
                return media; // Trả về Media nếu tìm thấy
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }
 // Phương thức getter cho danh sách itemsInStore
    public ArrayList<Media> getItems() {
        return itemsInStore;
    }


    // Print the contents of the store
    @Override
    public String toString() {
        StringBuilder storeContents = new StringBuilder("-----------Store contents:-------------\n");
        for (Media media : itemsInStore) {
            storeContents.append(media.getTitle()).append("\n");
        }
        return storeContents.toString();
    }

    public void removeMedia(String title1) {
        // Kiểm tra danh sách không rỗng
        if (itemsInStore == null || itemsInStore.isEmpty()) {
            System.out.println("Danh sách trong cửa hàng trống.");
            return;
        }

        boolean found = false;

        // Duyệt qua danh sách để tìm Media có tiêu đề trùng với title1
        for (int i = 0; i < itemsInStore.size(); i++) {
            Media media = itemsInStore.get(i);
            if (media.getTitle().equalsIgnoreCase(title1)) { // So sánh tiêu đề
                itemsInStore.remove(i); // Xóa phần tử khỏi danh sách
                System.out.println("Đã xóa phương tiện: " + title1);
                found = true;
                break; // Kết thúc vòng lặp sau khi xóa
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy phương tiện có tiêu đề: " + title1);
        }
    }
}
