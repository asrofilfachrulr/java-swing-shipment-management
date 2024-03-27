package View;

import javax.swing.*;
import java.awt.*;

public class LoadingDialog extends JDialog {

    private JProgressBar progressBar;
    public LoadingDialog dialog;

    public LoadingDialog () {}

    private LoadingDialog(Frame owner, String title, String loadingText) {
        super(owner, title, true); // Set modal to true for a modal dialog
        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true); // Use indeterminate mode for a loading spinner

        JLabel label = new JLabel(loadingText);
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        panel.add(progressBar, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        getContentPane().add(panel);
        pack();

        // Center the dialog on the screen
        setLocationRelativeTo(null);
    }

    public void showDialogAndRun(String title, String loadingText, Runnable runnable){
        dialog = new LoadingDialog(new JFrame(), title, loadingText);
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(1000);
                runnable.run();
                return null;
            }

            @Override
            protected void done() {
                // Close the dialog when loading is complete
                dialog.dispose();
            }
        };
        worker.execute();
        dialog.setVisible(true);
    }

    public void showDialogAndRun(String loadingText, Runnable runnable){
        showDialogAndRun("Loading", loadingText, runnable);
    }

    public void disposeDialog(){
        dialog.dispose();
    }
}
