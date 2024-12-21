package hust.soict.hedspi.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.application.Platform;
public class MediaStore extends JPanel {
	private static final long serialVersionUID = 1L;
	private Media media;
	private Cart cart;
	private CartScreen CartScreen;
	
	
    public MediaStore(Media media,Cart cart) {
        this.setMedia(media);
        this.cart = cart;
        this.CartScreen = CartScreen ;
        
        
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton addToCartButton = new JButton("Add to cart");
       
        addToCartButton.addActionListener(new ActionListener() {
        	
            @Override
            
            public void actionPerformed(ActionEvent e) {
                // Thêm media vào giỏ hàng
            	
                cart.addMedia(media);
                new CartScreen(cart);
                JOptionPane.showMessageDialog(null, media.getTitle() + "  has been added to cart.");
              
                
            }
        });
       
        container.add(addToCartButton);
        if (media instanceof Playable) {
            // Tạo nút "Play"
            JButton playButton = new JButton("Play");

            // Gán ActionListener cho nút "Play"
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Hiển thị media trong một cửa sổ dialog (mô phỏng phát media)
                    JDialog playDialog = new JDialog();
                    playDialog.setTitle("Video is playing: " + media.getTitle());
                    playDialog.setSize(400, 200);
                    playDialog.setLocationRelativeTo(null);  // Canh giữa cửa sổ dialog
                    playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

                    // Mô phỏng việc phát media bằng cách hiển thị một thông báo
                    JLabel playingLabel = new JLabel("Video is playing: " + media.getTitle(), JLabel.CENTER);
                    playDialog.add(playingLabel);
                    playDialog.setVisible(true);
                }
            });

            // Thêm nút "Play" vào container
            container.add(playButton);
        }


        container.add(Box.createVerticalGlue());
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}
}
