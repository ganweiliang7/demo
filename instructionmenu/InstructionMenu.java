package instructionmenu;

import main.java.GameFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InstructionMenu implements ActionListener {
    InstructionMenuModel instructionMenuModel = new InstructionMenuModel();
    InstructionMenuController instructionMenuController = new InstructionMenuController();
    JButton backbutton = new JButton();
    private static JFrame gameFrame;



    class ImagePanel extends JComponent {
        private Image image;
        public ImagePanel(Image image) {
            this.image = image;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }


    /**
     *This method sets the frame size, load background image and call the methods for drawing the components in instruction menu
     * @param frame  the original frame used by GameFrame
     */
    public void showinstructions(GameFrame frame)
    {
        gameFrame = frame;
        BufferedImage InstructionMenuImage = null;
        String pathtoWallpaper = "src/main/resources/InstructionMenuWallpaper.jpg";
        try
        {
            InstructionMenuImage = ImageIO.read(new File(pathtoWallpaper));

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(500, 450);
        frame.setContentPane(new ImagePanel(InstructionMenuImage));
        drawButton(frame);
        drawText(frame);
        frame.setVisible(true);
    }

    /**
     * draw back button for instruction menu
     * @param frame  The original frame used by GameFrame
     */
    public void drawButton(JFrame frame)
    {
        backbutton = new JButton("Back");
        backbutton.setForeground(new Color(0,0,0));
        backbutton.setBounds(0, 0, 100, 50);
        backbutton.addActionListener(this);

        backbutton.setBackground(new Color(255,255,255,200));

        frame.add(backbutton);

    }

    /**
     *draw the txtarea in the instruction menu
     * @param frame  The original frame used by GameFrame
     */
    public void drawText(GameFrame frame)
    {
        JTextArea txtarea = new JTextArea();
        txtarea.setBounds(50, 100, 400, 300);
        txtarea.append(instructionMenuModel.getInstructionString());

        txtarea.setFont(new Font(Font.DIALOG, Font.BOLD,15));
        txtarea.setBackground(new Color(2,255,255,100));
        txtarea.setForeground(new Color(0,0,0));
        frame.add(txtarea);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        instructionMenuController.instructionMenuActionPerformed(e,this,gameFrame);

    }
}
