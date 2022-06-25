package email_client.callFrame;

import email_client.aboutTeam;
import email_client.global.LookandFeel;
import email_client.global.macOS.subForm;

public class frameAboutTeam {

    public static void anotherframe() {
        LookandFeel.setTheme();
        subForm.isMacOS();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            aboutTeam frame = new aboutTeam();
            subForm.isMacFullWindowContentSupported(frame);
            frame.setVisible(true);
            frame.setTitle("Thông tin nhóm");
            frame.setResizable(false);
        });
    }
    
}
